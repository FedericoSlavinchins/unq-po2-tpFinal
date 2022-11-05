package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class Aceptado implements EstadoDesafio {

	private DesafioDeUsuario desafio;

	@Override
	public void aceptar() {}

	@Override
	public void completar() {
		
		//this.setDate(Date today)
		desafio.setFechaCompletado(LocalDate.now());
		desafio.setEstado(new Completado()); // Setea estado completado
		this.valorar();
		
	}
	
	public void valorar() { //Hace la votacion para ver cuanto le gusto el desafio
		
	}

	@Override
	public void setDesafio(DesafioDeUsuario desafio) {
		this.desafio = desafio;
		
	}
}

