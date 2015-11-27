package modelo;

public class Producto {
	public int id_producto;
	public String nombre;
	public float precio;
	public String proveedor;
	public String categoria;
	public int cantidad;
	
	
	public Producto(int id_producto, String nombre, float precio, String proveedor,
			String categoria, int cantidad) {
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.precio = precio;
		this.proveedor = proveedor;
		this.categoria = categoria;
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre=" + nombre + ", precio=" + precio
				+ ", id_proveedor=" + proveedor + ", id_categoria=" + categoria
				+ ", cantidad=" + cantidad + "]";
	}
	

}
