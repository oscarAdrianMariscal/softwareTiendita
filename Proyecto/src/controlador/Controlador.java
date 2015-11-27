package controlador;

import java.util.ArrayList;

import modelo.Conexion;
import modelo.Empleado;
import modelo.Inventario;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Ticket;

public class Controlador {
	Conexion baseTienda;
	
	public Controlador() {
		baseTienda = new Conexion();
	}

	public void agregarProducto(int codigo_barras,String nombre, int precio, int id_proveedor ,String categoria, int cantidad){
		baseTienda.insertarProducto(codigo_barras, nombre, precio, id_proveedor, categoria, cantidad );
	}
	
	public ArrayList<Empleado> empleados(){
		return baseTienda.mostrarTablaEmpleado();
	}
	
	public void eliminarEmpleado(int id){
		baseTienda.eliminarEmpleado(id);
		
	}
	
	public void agregarEmpleado(int salario, String horario,String puesto, int edad, String nombre){
		baseTienda.insertarEmpleado(salario, horario,puesto, edad, nombre);
	}
	
	public ArrayList<Producto> productos(){
		return baseTienda.mostrarTablaProducto();
	}
	
	public void eliminarProducto(int id){
		baseTienda.eliminarProducto(id);
		
	}
	
	public void agregarProveedor(String nombre){
		baseTienda.insertarProveedor(nombre);
		
	}
	
	public ArrayList<Proveedor> proveedores(){
		return baseTienda.mostrarTablaProveedor();
	}
	
	public void eliminarProveedor(int id){
		baseTienda.eliminarProveedor(id);
		
	}
	
	public void actualizarInventario(int id,int cant){
		baseTienda.actualizarInventario(id,cant);
	}
	
	public ArrayList<Inventario> inventarios (){
		return baseTienda.mostrarTablaInventario();
	}
	
	public ArrayList<Ticket> tickets (){
		return baseTienda.mostrarTablaTickets();
	}
	
	public void ingresarTicket(int id_empleado, String informacion){
		baseTienda.agregarTicket(id_empleado, informacion);
	}
	

}
