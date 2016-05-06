package Usuarios;
import Libros.Autor;
import Libros.Ejemplar;
import Libros.Libro;

import Plataforma.Ticket;


public class Bibliotecario extends Usuario {

	public Bibliotecario(String nombreUsuario, String pass,
			String nombre, String apellido, String dni) {
		super(nombreUsuario, pass, nombre, apellido, dni);
		// TODO Auto-generated constructor stub
	}


	public void agregarLibro(Libro libro)
	{


		biblioteca.addLibro(libro);
	}

	public void prestarLibro(Usuario usuario, Libro libro)
	{

		if(((Particular)usuario).getEjemplares().size()<3)
		{



			Ejemplar ejemplar= biblioteca.getLibro(libro.getISBN()).prestarEjemplar(usuario);
			((Particular)usuario).addLibro(ejemplar);


			if(ejemplar!=null)
			{
				Ticket ticket =new Ticket(biblioteca.getIdTicket(), usuario, libro, ejemplar);
				biblioteca.addTicket(ticket);
				biblioteca.setIdTicket(biblioteca.getIdTicket()+1);

				
					usuario.sumarPuntos(10);
				


			}






		}

		else
		{
			System.out.println("El usuario "+ usuario.getNombre()+" "+ usuario.getApellido()+" tiene mas de tres libros en posecion");
		}


	}

	public void addEjemplar(Libro libro)
	{
		biblioteca.getLibro(libro.getISBN()).addEjemplar();
	}

	public void agregarAutor(Autor autor, Libro libro)
	{
		biblioteca.getLibro(libro.getISBN()).addAutores(autor);
	}


	@Override
	public void sumarPuntos(int i) {
		// TODO Auto-generated method stub
		
	}
}
