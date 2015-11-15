package modelo;

public class Proveedor {
	public int id_proveedor;
	public String nombre;
	public Proveedor(int id_proveedor, String nombre) {
		this.id_proveedor = id_proveedor;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Proveedor [id_proveedor=" + id_proveedor + ", nombre=" + nombre
				+ "]";
	}
	
	

}
