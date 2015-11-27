package modelo;

public class Proveedor {
	public int id_proveedor;
	public String nombre;
	public String domicilio;
	public String telefono;
	public String correo;
	public Proveedor(int id_proveedor, String nombre, String domicilio, String telefono, String correo) {
		this.id_proveedor = id_proveedor;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "Proveedor [id_proveedor=" + id_proveedor + ", nombre=" + nombre
				+ ", domicilio=" + domicilio + ", telefono=" + telefono + ", correo=" + correo + "]";
	}
	
	

}
