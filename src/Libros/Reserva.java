package Libros;




import java.util.Date;
import java.util.Vector;

import Usuarios.Usuario;

public class Reserva {
	
	private int idReserva;
	
	private Vector<Ejemplar> ejemplares;
	private Usuario usuario;
	private Date fecha;
	public Reserva(int idReserva, Usuario usuario,Date fecha) {
		super();
		this.idReserva = idReserva;
		this.ejemplares= new Vector<Ejemplar>();
		this.usuario = usuario;
		this.fecha = fecha;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
	
	public Vector<Ejemplar> getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(Vector<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void agregarEjemplar(Ejemplar ejemplar)
	{
		ejemplares.add(ejemplar);
	}

}
