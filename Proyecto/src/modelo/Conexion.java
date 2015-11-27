package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;




public class Conexion {
	public Connection conex = null;

	public Connection conexion(){
		try {
			Class.forName("org.postgresql.Driver");
			try {
				conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tiendita","postgres","postgres");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e, "Error2 en la Conexi�n con la BD "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
	            conex=null;
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e, "Error1 en la Conexi�n con la BD "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
            conex=null;
		}
	return conex;
	}
	
	public ArrayList<Producto> mostrarTablaProducto(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		String sql = "SELECT * From producto";
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				int id_producto =Integer.parseInt(rs.getString("idproducto"));
				String nombre =rs.getString("nombre");
				float precio=rs.getFloat("precio");
				int id_proveedor = Integer.parseInt(rs.getString("idproveedor"));
				int id_categoria = Integer.parseInt(rs.getString("idcategoria"));
				int cantidad = Integer.parseInt(rs.getString("cantidad"));
				Producto temp = new Producto(id_producto,nombre,precio, id_proveedor,id_categoria, cantidad);
				//System.out.println(temp);
				productos.add(temp);
			}
			
		}
		catch(SQLException ex){
		}
		return productos;
	}
	
	public void insertarProducto(int codigo,String nombre,int precio,int id_proveedor,String id_categoria, int cantidad){
		try{
			conexion();
			String query = " insert into producto (idproducto,nombre,precio,idproveedor,idcategoria,cantidad)"
			        + " values (?, ?, ?, ?, ?, ?)";
			 
			PreparedStatement pst = conex.prepareStatement(query);
			pst.setString(1, "0");
			pst.setString(2, nombre);
			pst.setString(3, String.valueOf(precio));
			pst.setString(4, String.valueOf(1));
			pst.setString(5, String.valueOf(1));
			pst.setString(6, String.valueOf(cantidad));
			int consulta = pst.executeUpdate();
			if (consulta>0){
				System.out.println("HEKLADLVJAS");
			}
			else{
			}
			
			
		}
		catch(SQLException ex){
			System.out.println("ERROR EN METODO insertar producto");
		}
				
	}
	
	public void eliminarProducto(int id){
		conexion();
		String query = "DELETE from producto where id_producto = '"+id+"'";
		try {
			PreparedStatement pst = conex.prepareStatement(query);
			pst.executeUpdate();
			
		} catch (SQLException e) {
		}
		
	}
	
	public void insertarProveedor(String nombre, String domicilio, String telefono, String correo){
		try{
			conexion();
			String query = " insert into proveedor (idproveedor,nombreproveedor,domicilio,telefono,correo)"
			        + " values (?, ?, ?, ?, ?)";
			 
			PreparedStatement pst = conex.prepareStatement(query);
			pst.setString(1, "0");
			pst.setString(2, nombre);
			pst.setString(3, domicilio);
			pst.setString(4, telefono);
			pst.setString(5, correo);
			int consulta = pst.executeUpdate();
			if (consulta>0){
//				System.out.println("HEKLADLVJAS");
			}
			else{
			}
			
			
		}
		catch(SQLException ex){
			System.out.println("ERROR EN METODO insertar proveedor");
		}
				
	}
	
	public ArrayList<Proveedor> mostrarTablaProveedor(){
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
		String sql = "SELECT * From proveedor";
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				int id_proveedor =Integer.parseInt(rs.getString("idproveedor"));
				String nombre = rs.getString("nombreproveedor");
				String domicilio = rs.getString("domicilio");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				Proveedor temp = new Proveedor(id_proveedor,nombre,domicilio,telefono,correo);
				proveedores.add(temp);
			}
		}
		catch(SQLException ex){
		}
		return proveedores;
	}

	public void eliminarProveedor(int id){
		conexion();
		String query = "DELETE from proveedor where idProveedor = '"+id+"'";
		try {
			PreparedStatement pst = conex.prepareStatement(query);
			pst.executeUpdate();
			
		} catch (SQLException e) {
		}
		
	}
	
	public void actualizarInventario (int id,int cant){
		String query = "UPDATE inventario SET cantidad =? "
				+"WHERE id_producto = ?";
		try {
			PreparedStatement pst = conex.prepareStatement(query);
			pst.setString(1, String.valueOf(cant));
			pst.setString(2, String.valueOf(id));
			pst.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
		}
	}
	
	public ArrayList<Inventario> mostrarTablaInventario(){
		ArrayList<Inventario> inventario = new ArrayList<Inventario>();
		String sql = "SELECT nombre, cantidad ,inventario.id_producto FROM inventario LEFT JOIN  producto  on inventario.id_producto = producto.id_producto";
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				int id_producto = Integer.parseInt(rs.getString("id_producto"));
				String nombre = rs.getString("nombre");
				int cantidad = Integer.parseInt(rs.getString("cantidad"));
				Inventario temp = new Inventario(nombre,id_producto,cantidad);
				inventario.add(temp);
			}
			
		}
		catch(SQLException ex){
		}
		return inventario;
	}

	public void insertarEmpleado(int id_empleado, String nombre, String apellido, int salario, String puesto, String horario,
			int edad, String telefono, String direccion, String correo) {
		try{
			conexion();
			String query = "insert into empleado (idempleado, nombreempleado, apellidoempleado, salario, puesto, horario, edad, telefono, direccion, correo)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			 
			PreparedStatement pst = conex.prepareStatement(query);
			pst.setString(1, "0");
			pst.setString(2, nombre);
			pst.setString(3, apellido);
			pst.setString(2, String.valueOf(salario));
			pst.setString(3, horario);
			pst.setString(4, puesto);
			pst.setString(5, String.valueOf(edad));
			pst.setString(6, nombre);
			int consulta = pst.executeUpdate();
			if (consulta>0){
//				System.out.println("HEKLADLVJAS");
			}
			else{
			}
			
			
		}
		catch(SQLException ex){
			System.out.println("ERROR EN METODO insertar proveedor");
		}
		
	}

	public void eliminarEmpleado(int id) {
		conexion();
		String query = "DELETE from empleado where id_empleado = '"+id+"'";
		try {
			PreparedStatement pst = conex.prepareStatement(query);
			pst.executeUpdate();
			
		} catch (SQLException e) {
		}

		
	}

	public ArrayList<Empleado> mostrarTablaEmpleado() {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		String sql = "SELECT * From empleado";
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				int id_empleado = Integer.parseInt(rs.getString("id_empleado"));
				String nombre   = rs.getString("nombre");
				String apellido   = rs.getString("apellido");
				float salario     = rs.getFloat("salario");
				String puesto   = rs.getString("puesto");
				String horario  = rs.getString("horario");
				int edad        = Integer.parseInt(rs.getString("edad"));
				String telefono   = rs.getString("telefono");
				String direccion   = rs.getString("direccion");
				String correo   = rs.getString("correo");
				
				Empleado temp = new Empleado(id_empleado,nombre,apellido,salario,puesto,horario,edad,telefono,direccion,correo);
				empleados.add(temp);
			}
			
		}
		catch(SQLException ex){
		}
		return empleados;
	}

	public ArrayList<Ticket> mostrarTablaTickets() {
		ArrayList<Ticket> tickets= new ArrayList<Ticket>();
		String sql = "SELECT * From ticket";
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				
				int id_ticket = Integer.parseInt(rs.getString("id_ticket"));
				String fecha     = rs.getString("fecha");
				int id_empleado  = Integer.parseInt(rs.getString("id_empleado"));
				String informacion  = rs.getString("informacion");
				
				
				Ticket temp = new Ticket(id_ticket,fecha,id_empleado,informacion);
				tickets.add(temp);
			}
			
		}
		catch(SQLException ex){
		}
		return tickets;
	}

	public void agregarTicket(int id_empleado,String informacion) {
		try{
			conexion();
			String query = "insert into ticket (id_ticket,fecha,id_empleado, informacion)"
			        + " values (?, ?, ?, ?)";
			PreparedStatement pst = conex.prepareStatement(query);
			pst.setString(1, "0");
			pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			pst.setString(3, String.valueOf(id_empleado));
			pst.setString(4, informacion);
			int consulta = pst.executeUpdate();
			if (consulta>0){
//				System.out.println("HEKLADLVJAS");
			}
			else{
			}
			
			
		}
		catch(SQLException ex){
			System.out.println("ERROR EN METODO insertar proveedor");
		}
		
		
	}
	
}
	

	
	
