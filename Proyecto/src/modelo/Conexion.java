package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public static String validarNombre(String buscar)
	{
		String temp1, temp2;
		temp1=buscar.substring(0,1);
		temp1=temp1.toUpperCase();
		
		temp2=buscar.substring(1, buscar.length());
		temp2=temp2.toLowerCase();
		
		return buscar=temp1+temp2;
	}
	
	public void insertarProducto(int codigo,String nombre,float precio,String proveedor,String categoria, int cantidad){
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery("Select * FROM categoriaproducto where categoria = '"+categoria+"'");
			int idCategoria = 0, idProveedor = 0;
			
			while(rs.next())
			{
				idCategoria = rs.getInt("idcategoria");
			}
			
			st = conex.createStatement();
			rs = st.executeQuery("Select * FROM proveedor where nombreproveedor = '"+proveedor+"'");
			
			while(rs.next())
			{
				idProveedor = rs.getInt("idproveedor");
			}
			
				String query = " insert into producto (idproducto,nombre,precio,idproveedor,idcategoria,cantidad)"
				        + " values (?, ?, ?, ?, ?, ?)";
				 
				PreparedStatement pst = conex.prepareStatement(query);
				pst.setInt(1, codigo);
				pst.setString(2, validarNombre(nombre));
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
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}		
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
				String proveedor = rs.getString("nombreproveedor");
				String categoria = rs.getString("categoria");
				int cantidad = Integer.parseInt(rs.getString("cantidad"));
				Producto temp = new Producto(id_producto,nombre,precio, proveedor,categoria,cantidad);
				productos.add(temp);
			}	
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}
		return productos;
	}
	
	public void eliminarProducto(int id){
		conexion();
		String query = "DELETE from producto where idproducto = '"+id+"'";
		try {
			PreparedStatement pst = conex.prepareStatement(query);
			int consulta = pst.executeUpdate();
			if (consulta>0){
				JOptionPane.showMessageDialog(null, "Producto eliminado");
			}
			else{
			}	
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void insertarCategoria(String categoria){
		try{
			conexion();
			
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery("SELECT count(idcategoria) as codigo FROM categoriaproductos");
			int id=0;
			
			while (rs.next()) {
			id = rs.getInt("codigo")+1;
	    	}
			
			String query = " insert into categoriaproductos (idcategoria,categoria)"
			        + " values (?, ?)";
			 
			PreparedStatement pst = conex.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, validarNombre(categoria));
			int consulta = pst.executeUpdate();
			if (consulta>0){
				JOptionPane.showMessageDialog(null, "Categoria agregada");
			}
			else{
			}	
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}		
	}
	
	public ArrayList<Categoria> mostrarCategoria(){
		ArrayList<Categoria> categoria = new ArrayList<Categoria>();
		String sql = "Select * FROM categoriaproducto";
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				int id_categoria =rs.getInt("idcategoria");
				String nombre =rs.getString("categoria");
				Categoria temp = new Categoria(id_categoria,nombre);
				categoria.add(temp);
			}	
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}
		return categoria;
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
			pst.setString(2, validarNombre(nombre));
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
		System.out.println(proveedor);
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				id = rs.getInt("idproveedor");
			}
			System.out.println(id);
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
			pst.setString(2, validarNombre(nombre));
			pst.setString(3, validarNombre(apellido));
			pst.setString(4, String.valueOf(salario));
			pst.setString(5, puesto);
			pst.setString(6, horario);
			pst.setString(7, String.valueOf(edad));
			pst.setString(8, telefono);
			pst.setString(9, direccion);
			pst.setString(10, correo);
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
	
	public ArrayList<Empleado> mostrarTablaEmpleado() {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		String sql = "SELECT * From empleado";
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				int id_empleado = Integer.parseInt(rs.getString("idempleado"));
				String nombre   = rs.getString("nombreempleado");
				String apellido   = rs.getString("apellidoempleado");
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

	public void agregarTicket(int id_empleado,String fecha, ArrayList<DetalleProducto> detalle) {
		int id=0;
		try{
			conexion();
			
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery("SELECT count(idticket) as codigo FROM ticket");
			
			while (rs.next()) {
			id = rs.getInt("codigo")+1;
	    	}
			
			String query = "insert into ticket (idempleado,fecha,idticket)"
			        + " values (?, ?, ?)";
			PreparedStatement pst = conex.prepareStatement(query);
			
			pst.setInt(1, id_empleado);
			pst.setString(2, fecha);
			pst.setInt(3, id);
			int consulta = pst.executeUpdate();
			if (consulta>0){
				JOptionPane.showMessageDialog(null, "Venta Exitosa");
			}
			else{
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}
		try{
		for (DetalleProducto d : detalle){
			String query = "insert into detalleticket (idproducto,idticket,cantidad)"
			        + " values (?, ?, ?)";
			PreparedStatement pst = conex.prepareStatement(query);
			
			pst.setInt(1, d.idProducto);
			pst.setInt(2, id);
			pst.setInt(3, 1);
			
			int consulta = pst.executeUpdate();
			if (consulta>0){
				System.out.println("Agrego");
			}
			else{
			}
		}
	}
	catch(SQLException ex){
		System.out.println(ex.getMessage());
	}
	}
	
	public ArrayList<Ticket> mostrarTablaTickets() {
		ArrayList<Ticket> tickets= new ArrayList<Ticket>();
		String sql = "SELECT p.nombre, p.precio, fecha, e.nombreempleado, e.apellidoempleado from ticket"+
					 "inner join empleado as e on e.idempleado = ticket.idempleado"+
					 "inner join detalleticket as dt on dt.idticket = ticket.idticket"+
					 "inner join producto as p on p.idproducto = dt.idproducto";
		try{
			conexion();
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				//Obtener los atributos.
				String producto = rs.getString("nombre");
				float precio = rs.getFloat("precio");
				String fecha     = rs.getString("fecha");
				String empleado  = rs.getString("nombreempleado");
				String apellido  = rs.getString("apellidoempleado");
				
				Ticket temp = new Ticket(producto,precio,fecha,empleado,apellido);
				tickets.add(temp);
			}
			
		}
		catch(SQLException ex){
		}
		return tickets;
	}
	
}