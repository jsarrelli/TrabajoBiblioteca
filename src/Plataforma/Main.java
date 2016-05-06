package Plataforma;

import java.util.Vector;

import Libros.Libro;
import Usuarios.Administrador;
import Usuarios.Bibliotecario;
import Usuarios.Particular;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Plataforma biblioteca= Plataforma.getInstance();
		
		Particular particular=new Particular("julisarrelli", "1234", "julian", "sarrelli", "41062654");
		Particular particular2=new Particular("jandejong", "4445", "jan", "de jong", "4252775");
		
		Bibliotecario bibliotecario=new Bibliotecario("juanmanunoz", "5484", "juanma", "munoz", "40548792");
		
		Administrador administrador=new Administrador("rociolorenzo", "3243", "rocio", "Lorenzo", "85546");
		
		
		
		administrador.addUsuario(particular);
		administrador.addUsuario(bibliotecario);
		administrador.addUsuario(administrador);
		
		Libro libro1=new Libro(3550, "Harry Potter", 25);
		
		Libro libro2= new Libro(4020,"Cesar",80);
		
		Libro libro3= new Libro (2506,"Roma",200);
		
		
		bibliotecario.agregarLibro(libro1);
		bibliotecario.agregarLibro(libro2);
		bibliotecario.agregarLibro(libro3);
		
		bibliotecario.addEjemplar(libro1);bibliotecario.addEjemplar(libro1);	
		bibliotecario.addEjemplar(libro1);
		
		
		
		bibliotecario.addEjemplar(libro2);
		bibliotecario.addEjemplar(libro2);
		bibliotecario.addEjemplar(libro2);
		
		
		bibliotecario.addEjemplar(libro3);
		bibliotecario.addEjemplar(libro3);
		bibliotecario.addEjemplar(libro3);
		
		Vector<Libro>pack1=new Vector<Libro>();
		pack1.add(libro1);
		
		
		Vector<Libro>pack2=new Vector<Libro>();
		pack2.add(libro2);
		pack2.add(libro3);
		
		particular.reservaLibro(pack1);
		
		

		
		
		
		bibliotecario.prestarLibro(particular2, libro2);
		
	
	
		bibliotecario.prestarLibro(particular2, libro1);
		bibliotecario.prestarLibro(particular, libro1);
		
		
		
		;
		
	
		
		
		biblioteca.mostrarLibros();
		
		
		particular2.mostrarReservas();
		
	}

}
