package modelo;

public class Empleado {
	public int id_empleado;
	public int salario;
	public String horario;
	public String puesto;
	public int edad;
	public String nombre;
	
	
	public Empleado(int id_empleado, int salario, String horario,
			String puesto, int edad, String nombre) {
		super();
		this.id_empleado = id_empleado;
		this.salario = salario;
		this.horario = horario;
		this.puesto = puesto;
		this.edad = edad;
		this.nombre = nombre;
	}
	
	

}
