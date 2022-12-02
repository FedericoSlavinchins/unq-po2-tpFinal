package ar.edu.unq.po2.SistemaUsuario;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class MenuDeProgreso {
	
	private Usuario usuarioAConsultarProgreso;
	
	
	public MenuDeProgreso(Usuario usuario) {
		this.usuarioAConsultarProgreso = usuario;
	}

	public int porcentajeDeCompletitudGeneral() {			// FS: Entre desafios aceptados.
		int resultado = 0; 
		for (DesafioDeUsuario desafioDeUsuario : this.usuarioAConsultarProgreso.getMenuDeDesafios().getDesafiosAceptados()) {
			resultado += this.porcentajeDeCompletitud(desafioDeUsuario);
		}
		return ((resultado + (this.usuarioAConsultarProgreso.getMenuDeDesafios().getDesafiosCompletados().size() * 100))) 
				/ 
				(this.usuarioAConsultarProgreso.getMenuDeDesafios().getDesafiosAceptados().size() + this.usuarioAConsultarProgreso.getMenuDeDesafios().getDesafiosCompletados().size());
	}
	
	// FS: Métodos de conocimiento de información acerca de Desafios del Usuario.
	
	public boolean completoDesafio(DesafioDeUsuario desafioDeUsuario) {	   //FS: Indica si completó un desafio del usuario.
		return (this.usuarioAConsultarProgreso.getMenuDeDesafios().getDesafiosCompletados().contains(desafioDeUsuario));
	}
	
	// Devuelve el porcentaje de completitud del desafio en cuestion
	
	public int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario) {
		return desafioDeUsuario.porcentajeDeCompletitud();
	}

	private boolean usuarioEstaRealizandoElDesafio(DesafioDeUsuario desafioDeUsuario) {
		return this.usuarioAConsultarProgreso.getMenuDeDesafios().getDesafiosAceptados().contains(desafioDeUsuario);
	}
	
	
	
	
}
