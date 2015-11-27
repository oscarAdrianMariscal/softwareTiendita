package modelo;

public class Producto {
	public int id_producto;
	public String nombre;
	public int precio;
	public int id_proveedor;
	public int id_categoria;
	public int cantidad;
	public Producto(int id_producto, String nombre, int precio, int id_proveedor,
			int id_categoria, int cantidad) {
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.precio = precio;
		this.id_proveedor = id_proveedor;
		this.id_categoria = id_categoria;
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre=" + nombre + ", precio=" + precio
				+ ", id_proveedor=" + id_proveedor + ", id_categoria=" + id_categoria
				+ ", cantidad=" + cantidad + "]";
	}
	

}
