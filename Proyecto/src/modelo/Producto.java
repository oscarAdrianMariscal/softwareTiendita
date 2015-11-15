package modelo;

public class Producto {
	public int id_producto;
	public int precio;
	public int id_proveedor;
	public String nombre;
	public String descripcion;
	public Producto(int id_producto, int precio, int id_proveedor,
			String nombre, String descripcion) {
		this.id_producto = id_producto;
		this.precio = precio;
		this.id_proveedor = id_proveedor;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", precio=" + precio
				+ ", id_proveedor=" + id_proveedor + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + "]";
	}
	

}
