package modelo;

import java.sql.Date;

public class Ticket {
	public int  id_ticket;
	public String fecha;
	public int id_empleado;
	public String informacion;
	public Ticket(int id_ticket, String fecha, int id_empleado, String informacion) {
		super();
		this.id_ticket = id_ticket;
		this.fecha = fecha;
		this.id_empleado = id_empleado;
	}
	
	

}
