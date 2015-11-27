package modelo;

public class Empleado {
	public int id_empleado;
	public String nombre;
	public String apellido;
	public float salario;
	public String puesto;
	public String horario;
	public int edad;
	public String telefono;
	public String direccion;
	public String correo;
	
	public Empleado(int id_empleado, String nombre, String apellido, float salario, String puesto, String horario,
			int edad, String telefono, String direccion, String correo) {
		super();
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
		this.puesto = puesto;
		this.horario = horario;
		this.edad = edad;
		this.nombre = telefono;
		this.puesto = direccion;
		this.puesto = correo;
	}
}
