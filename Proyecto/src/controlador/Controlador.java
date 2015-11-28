package controlador;

import java.util.ArrayList;

import modelo.Categoria;
import modelo.Conexion;
import modelo.Empleado;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Ticket;

public class Controlador {
	Conexion baseTienda;
	
	public Controlador() {
		baseTienda = new Conexion();
	}

	public void agregarProducto(int codigo,String nombre,float precio,String proveedor,String categoria, int cantidad){
		baseTienda.insertarProducto(codigo, nombre, precio, proveedor, categoria, cantidad );
	}
	
	public ArrayList<Producto> productos(){
		return baseTienda.mostrarTablaProducto();
	}
	
	public void eliminarProducto(int id){
		baseTienda.eliminarProducto(id);
	}
	
	public ArrayList<Categoria> categoria(){
		return baseTienda.mostrarCategoria();
	}
	
	public void agregarProveedor(String nombre, String domicilio, String telefono, String correo){
		baseTienda.insertarProveedor(nombre, domicilio, telefono, correo);
		
	}
	
	public ArrayList<Proveedor> proveedores(){
		return baseTienda.mostrarTablaProveedor();
	}
	
	public void eliminarProveedor(String proveedor){
		baseTienda.eliminarProveedor(proveedor);
	}
	
	public void agregarEmpleado(String nombre, String apellido, int salario, String puesto, String horario,
			int edad, String telefono, String direccion, String correo){
		baseTienda.insertarEmpleado(nombre, apellido,salario,puesto,horario,edad,telefono,direccion,correo);
	}
	
	public ArrayList<Empleado> empleados(){
		return baseTienda.mostrarTablaEmpleado();
	}
	
	public void eliminarEmpleado(int id){
		baseTienda.eliminarEmpleado(id);
		
	}
	
	public ArrayList<Ticket> tickets (){
		return baseTienda.mostrarTablaTickets();
	}
	
	public void ingresarTicket(int id_empleado, String informacion){
		baseTienda.agregarTicket(id_empleado, informacion);
	}
	

}
