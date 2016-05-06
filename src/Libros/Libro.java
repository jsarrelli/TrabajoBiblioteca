package Libros;

import java.util.Vector;

import Estado.Estanteria;
import Estado.Prestado;

import Usuarios.Usuario;

public class Libro {
	
	private int ISBN;
	private String titulo;
	private int cantPags;
	private Vector<Ejemplar> ejemplares;
	private Vector<Autor> autores;
	private int idEjemplar;
	public Libro(int iSBN, String titulo, int cantPags) {
		super();	
		ISBN = iSBN;
		this.titulo = titulo;
		this.cantPags = cantPags;
		this.ejemplares = new Vector<Ejemplar>();
		this.autores = new Vector<Autor>();
		this.idEjemplar=0;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getCantPags() {
		return cantPags;
	}
	public void setCantPags(int cantPags) {
		this.cantPags = cantPags;
	}
	public Vector<Ejemplar> getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(Vector<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}
	public Vector<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Vector<Autor> autores) {
		this.autores = autores;
	}
	
	
	
	
	public Ejemplar reservarEjemplar(Usuario usuario)
	{
		for(Ejemplar ejemplar:ejemplares)
		{
			if(ejemplar.isDisponible())
			{
				ejemplar.reservar(usuario);
				
				return ejemplar;
			}
		}
		return null;
	}
	
	public Ejemplar prestarEjemplar(Usuario usuario)
	{
		
		
		for (Ejemplar ejemplar:ejemplares)
		{
			if(!ejemplar.getEstado().Disponibilidad()&&ejemplar.getEstado().getUsuario().equals(usuario)&&ejemplar.getEstado().Diferencia())
			{
				
				ejemplar.prestar(usuario);
				return ejemplar;
				
			}
		}
		for(Ejemplar ejemplar:ejemplares)
		{
			if(ejemplar.isDisponible())
			{
			
				ejemplar.prestar(usuario);
				return ejemplar;
			}
			
			
		}
		
		
		
		System.out.println("No hay ejemplares del libro "+titulo+"\n");
		
		return null;
	}
	public boolean ejemplaresDisponible()
	{
		for(Ejemplar ejemplar:ejemplares)
		{
			if(ejemplar.isDisponible())
			{
				return true;
				
			}
		}
		return false;
	}
	
	public void addAutores(Autor autor)
	
	{
		if(!existeAutor(autor))
		{
		autores.add(autor);
		}
		else
		{
			System.out.println("Ese autor ya esta ingresado en el libro");
		}
	}
	
	public void addEjemplar()
	{
		Ejemplar ejemplar=new Ejemplar(idEjemplar,this.ISBN);
		ejemplares.add(ejemplar);
		
		this.idEjemplar++;
	}
	
	public void mostrarLibro()
	{
		System.out.println("ISBN:"+this.ISBN+"     Titulo:"+this.titulo);
		for(Ejemplar ejemplar:ejemplares)
		{
			
			ejemplar.mostrarEjemplar();
		}
	}
	
	
	public void eliminarReservas(int idUsuario)
	{
		for(Ejemplar ejemplar:ejemplares)
		{
			if(((Prestado)ejemplar.getEstado()).getUsuario().getIdUsuario()==idUsuario)
			{
				ejemplar.setEstado(new Estanteria());
				
			}
		}
	}
	
	public boolean existeAutor(Autor autor)
	{
		for(Autor autorActual:autores)
		{
			if(autorActual.equals(autor))
			{
				return true;
			}
		}
		
		return false;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + cantPags;
		result = prime * result
				+ ((ejemplares == null) ? 0 : ejemplares.hashCode());
		result = prime * result + idEjemplar;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (ISBN != other.ISBN)
			return false;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (cantPags != other.cantPags)
			return false;
		if (ejemplares == null) {
			if (other.ejemplares != null)
				return false;
		} else if (!ejemplares.equals(other.ejemplares))
			return false;
		if (idEjemplar != other.idEjemplar)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	

}
