package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class NoAceptado implements EstadoDesafio {
	
	private DesafioDeUsuario desafio;

	@Override  
	public void aceptar() {
		
		desafio.setFechaAceptado(LocalDate.now()); // guarda la fecha en la que se acepto
		desafio.setEstado(new Aceptado()); // Setea el estado Aceptados
		
	}

	@Override
	public void completar() {}

	@Override
	public void setDesafio(DesafioDeUsuario desafio) {
		this.desafio = desafio;
		
	}
}
