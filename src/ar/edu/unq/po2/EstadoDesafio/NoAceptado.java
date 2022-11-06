package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class NoAceptado implements EstadoDesafio {
	
	private DesafioDeUsuario desafioDeUsuario;

	@Override  
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) {
		this.desafioDeUsuario = desafioDeUsuario;
		desafioDeUsuario.setFechaAceptado(); // guarda la fecha en la que se acepto
		desafioDeUsuario.setEstado(new Aceptado()); // Setea el estado Aceptados
	}
	
}

