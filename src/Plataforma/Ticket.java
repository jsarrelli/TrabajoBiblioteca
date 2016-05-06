package Plataforma;

import Libros.Ejemplar;
import Libros.Libro;
import Usuarios.Usuario;

public class Ticket implements Imprimible{
	
	private Usuario usuario;
	private Libro libro;
	private Ejemplar ejemplar;
	private int idTicket;
	
	
	public Ticket(int idTicket,Usuario usuario, Libro libro, Ejemplar ejemplar) {
		super();
		this.usuario = usuario;
		this.libro = libro;
		this.ejemplar = ejemplar;
		this.idTicket = idTicket;
		
		imprimir();
	}
	
	


	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}




	public Libro getLibro() {
		return libro;
	}




	public void setLibro(Libro libro) {
		this.libro = libro;
	}




	public Ejemplar getEjemplar() {
		return ejemplar;
	}




	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}




	public int getIdTicket() {
		return idTicket;
	}




	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}




	@Override
	public void imprimir() {
		System.out.println("Se ha imprmeso el tike N: "+idTicket);
		System.out.println(usuario.getNombre()+" "+usuario.getApellido()+" ha retirado el libro "+libro.getTitulo());
		System.out.println("\n");
		
	}
	
	


}
