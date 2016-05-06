package Plataforma;

import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import java.util.Set;


import Libros.Autor;
import Libros.Libro;
import Libros.Reserva;
import Usuarios.Usuario;

public class Plataforma {
    private static Plataforma INSTANCE;
    private  HashMap<Integer, Libro> libros;
    private  HashMap<Integer, Autor> autores;
    private  HashMap<Integer, Usuario> usuarios;
    private  HashMap<Integer, Ticket> tickets;
    private int idReserva;
    private int idAutor;
    private int idUsuario;
    private int idTicket;
    
    

	public HashMap<Integer, Libro> getLibros() {
		return libros;
	}

	public void setLibros(HashMap<Integer, Libro> libros) {
		this.libros = libros;
	}
	

	public int getIdReserva() {
		return idReserva;
	}

	
	

	public HashMap<Integer, Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashMap<Integer, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public HashMap<Integer, Autor> getAutores() {
		return autores;
	}

	public void setAutores(HashMap<Integer, Autor> autores) {
		this.autores = autores;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	private Plataforma() {
		
		this.usuarios=new HashMap<Integer, Usuario>();
		this.libros=new HashMap<Integer, Libro>();
		this.autores=new HashMap<Integer, Autor>();
		this.setTickets(new HashMap<Integer, Ticket>());
	}

    public static Plataforma getInstance() {
    	
    	if (INSTANCE==null){
    		INSTANCE = new Plataforma();
    	}
    	
    		return INSTANCE;
    }
    
    
    
    public void addLibro (Libro libro)
    {
    	if(!libros.containsKey(libro.getISBN()))
    	{
    	libros.put(libro.getISBN(), libro);
    	}
    	
    	else
    	{
    		System.out.println("Ese libro ya esta ingresado");
    	}
    }
    
    public void addAutor (Autor autor)
    {
    	autores.put(idAutor,autor);
    	idAutor++;
    	
    }
    
    public void addUsuario (Usuario usuario)
    {
    	usuarios.put(usuario.getIdUsuario(), usuario);
    	
    }
    
   
    
    public Libro getLibro (Integer ISBN)
    {
    	return libros.get(ISBN);
    }
    
    public void mostrarLibros()
    {
    	Set<Integer> keys=libros.keySet();
    	for(Integer key:keys)
    	{
    		libros.get(key).mostrarLibro();
    		System.out.println("\n");
    	}
    }
    
    public void eliminarReservas(int idUsuario)
    {
    	
    	Set<Integer> keys= libros.keySet();
    	for(Integer key:keys)
    	{
    		libros.get(key).eliminarReservas(idUsuario);
    	}
    }
    
    public void eliminarUsuario(int idUsuario)
    {
    	usuarios.remove(idUsuario);
    	
    	
    }
    
    public Reserva reservarLibros (Vector<Libro> libros,Usuario usuario)
    {
    	Date fecha=new Date();
    	Reserva reserva= new Reserva(idReserva, usuario, fecha);
    	
    	for(Libro libro:libros){
    		
    		if(getLibro(libro.getISBN()).ejemplaresDisponible())
    		{

    			reserva.agregarEjemplar(libro.reservarEjemplar(usuario));

    		}
    		
    		else{
    			System.out.println("No hay ejemplares disponibles de: "+libro.getTitulo());
    		}
    		
    		}
    	
    	idReserva++;
    	
    	if(reserva.getEjemplares()==null){
    		System.out.println("No se encuentran ejemplares disponibles de ningun libro");
    		return null;
    	}
    	else
    	return reserva;
    }

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public HashMap<Integer, Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(HashMap<Integer, Ticket> tickets) {
		this.tickets = tickets;
	}
    public void addTicket(Ticket ticket)
    {
    	tickets.put(ticket.getIdTicket(), ticket);
    }
	
	
    
}
