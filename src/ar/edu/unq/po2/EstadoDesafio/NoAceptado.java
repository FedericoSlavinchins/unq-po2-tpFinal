package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class NoAceptado implements EstadoDesafio {
	
	private DesafioDeUsuario desafio;
	private LocalDate date;

	@Override  
	public void aceptar() {
		
		desafio.setFechaAceptado(date.now()); // guarda la fecha en la que se acepto
	//	desafio.setDesafiosAceptados( desafio.getDesafiosAceptados() + 1); // Se guardan los desafios aceptados una vez que se aceptan
		desafio.setEstado(new Aceptado()); // Setea el estado Aceptados
		
	}

	@Override
	public void completar() {}

	@Override
	public void setDesafio(DesafioDeUsuario desafio) {
		this.desafio = desafio;
		
	}
	
	@Override
	public void valorar() {

		
	}
}
