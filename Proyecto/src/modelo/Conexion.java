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
		String sql = "select idproducto, nombre, precio, cantidad, p.nombreproveedor, c.categoria from producto inner join proveedor as p on p.idproveedor = producto.idpro"+
					 "veedor inner join categoriaproducto as c on c.idcategoria = producto.idcategoria order by idproducto";
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				int id_producto =Integer.parseInt(rs.getString("idproducto"));
				String nombre =rs.getString("nombre");
				float precio=rs.getFloat("precio");
				String proveedor = rs.getString("nommbreproveedor");
				String categoria = rs.getString("categoria");
				int cantidad = Integer.parseInt(rs.getString("cantidad"));
				Producto temp = new Producto(id_producto,nombre,precio, proveedor,categoria,cantidad);
				productos.add(temp);
			}
			
		}
		catch(SQLException ex){
		}
		return productos;
	}
	
	public void insertarProducto(int codigo,String nombre,float precio,String proveedor,String categoria, int cantidad){
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery("Select * FROM categoriaproducto");
			int idCategoria = 0, idProveedor = 0;
			boolean band = false, band1 = false;
			
			while(rs.next())
			{
				if(categoria.equals(rs.getString("categoria")));
				{
					idCategoria = rs.getInt("idcategoria");
					band=true;
					break;
				}	
			}
			
			rs = st.executeQuery("Select * FROM proveedor");
			
			while(rs.next())
			{
				if(proveedor.equals(rs.getString("nombreproveedor")));
				{
					idProveedor = rs.getInt("idproveedor");
					band1=true;
					break;
				}	
			}
			
			if(band==true && band1==true)
			{
				String query = " insert into producto (idproducto,nombre,precio,idproveedor,idcategoria,cantidad)"
				        + " values (?, ?, ?, ?, ?, ?)";
				 
				PreparedStatement pst = conex.prepareStatement(query);
				pst.setInt(1, codigo);
				pst.setString(2, nombre);
				pst.setFloat(3, precio);
				pst.setInt(4, idProveedor);
				pst.setInt(5, idCategoria);
				pst.setInt(6, cantidad);
				int consulta = pst.executeUpdate();
				if (consulta>0){
					JOptionPane.showMessageDialog(null, "Producto agregado");
				}
				else{
				}
			}else
			{
				if(band==false)
					JOptionPane.showMessageDialog(null, "No existe la categoria: "+categoria, "Error al Agregar", JOptionPane.ERROR_MESSAGE);
				else if(band1==false)
					JOptionPane.showMessageDialog(null, "No existe el proveedor: "+proveedor, "Error al Agregar", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}		
	}
	
	public void eliminarProducto(int id){
		conexion();
		String query = "DELETE from producto where idproducto = '"+id+"'";
		try {
			PreparedStatement pst = conex.prepareStatement(query);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void insertarProveedor(String nombre, String domicilio, String telefono, String correo){
		try{
			conexion();
			
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery("SELECT count(idproveedor) as codigo FROM proveedor");
			int id=0;
			
			while (rs.next()) {
			id = rs.getInt("codigo")+1;
	    	}
			
			String query = " insert into proveedor (idproveedor,nombreproveedor,domicilio,telefono,correo)"
			        + " values (?, ?, ?, ?, ?)";
			 
			PreparedStatement pst = conex.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, nombre);
			pst.setString(3, domicilio);
			pst.setString(4, telefono);
			pst.setString(5, correo);
			int consulta = pst.executeUpdate();
			if (consulta>0){
				JOptionPane.showMessageDialog(null, "Proveedor agregado");
			}
			else{
			}	
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
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
				String nombre = rs.getString("nombreproveedor");
				String domicilio = rs.getString("domicilio");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				Proveedor temp = new Proveedor(nombre,domicilio,telefono,correo);
				proveedores.add(temp);
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}
		return proveedores;
	}

	public void eliminarProveedor(String proveedor){
		conexion();
		int id=0;
		String sql = "SELECT idproveedor From proveedor WHERE nombreproveedor ='"+proveedor+"'";
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				id = rs.getInt("idproveedor");
			}
			String query = "DELETE from proveedor where idproveedor = '"+id+"'";
			try {
				PreparedStatement pst = conex.prepareStatement(query);	
				int consulta = pst.executeUpdate();
				if (consulta>0){
					query = "UPDATE proveedor set idproveedor = idproveedor-1 WHERE idproveedor > "+id;
					JOptionPane.showMessageDialog(null, "Proveedor eliminado");
				}
				else{
				}		
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
			}
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
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

	public void insertarEmpleado(String nombre, String apellido, int salario, String puesto, String horario,
			int edad, String telefono, String direccion, String correo) {
		try{
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery("SELECT count(idempleado) as codigo FROM empleado");
			int id=0;
			
			while (rs.next()) {
			id = rs.getInt("codigo")+1;
	    	}
			
			conexion();
			String query = "insert into empleado (idempleado, nombreempleado, apellidoempleado, salario, puesto, horario, edad, telefono, direccion, correo)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			 
			PreparedStatement pst = conex.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, nombre);
			pst.setString(3, apellido);
			pst.setString(2, String.valueOf(salario));
			pst.setString(3, horario);
			pst.setString(4, puesto);
			pst.setString(5, String.valueOf(edad));
			pst.setString(6, nombre);
			int consulta = pst.executeUpdate();
			if (consulta>0){
				JOptionPane.showMessageDialog(null, "Empelado agregado");
			}
			else{
			}	
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarEmpleado(int id) {
		conexion();
		String query = "DELETE from empleado where idempleado = '"+id+"'";
		try {
			PreparedStatement pst = conex.prepareStatement(query);
			int consulta = pst.executeUpdate();
			if (consulta>0){
				query = "UPDATE empleado set idempleado = idempleado-1 WHERE idempleado > "+id;
				JOptionPane.showMessageDialog(null, "Empleado eliminado");
			}
			else{
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}
		return empleados;
	}

	public ArrayList<Ticket> mostrarTablaTickets() {
		ArrayList<Ticket> tickets= new ArrayList<Ticket>();
		String sql = "SELECT ticket.idticket, p.nombre, dt.cantidad, fecha, e.nombreemplead o, e.apellidoempleado from ticket "+
					 "inner join empleado as e on e.idempleado = ticket.idempleado inner join detalleticket as dt on dt.idticket = ticket.idticket"+
					 "inner join producto as p on p.idproducto = dt.idproducto";
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				
				int id_ticket = Integer.parseInt(rs.getString("id_ticket"));
				String producto = rs.getString("nombre");
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
	

	
	
