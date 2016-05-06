package Estado;

import Usuarios.Usuario;

public class Prestado implements Estado {

	private Usuario usuario;
	
	
	
	public Prestado(Usuario usuario) {
		super();
		this.usuario = usuario;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public boolean Disponibilidad() {
		return false;
		
	}



	@Override
	public boolean Diferencia() {
		// TODO Auto-generated method stub
		return false;
	}
	
	


}
