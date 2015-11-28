package modelo;

public class Ticket {
	public String  producto;
	public float precio;
	public String fecha;
	public String empleado;
	public String apellido;
	
	public Ticket(String producto, float precio, String fecha, String empleado, String apellido) {
		super();
		this.producto = producto;
		this.precio = precio;
		this.fecha = fecha;
		this.empleado = empleado;
		this.apellido = apellido;
	}
}
