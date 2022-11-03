package ar.edu.unq.po2.EstadoDesafio;

import ar.edu.unq.po2.Desafios.Desafio;

public class Completado implements EstadoDesafio {

	// El protocolo de este estado es fijar que se completo el desafio 
	// por ende los voids son vacios
	
	private Desafio desafio;
	
	@Override
	public void aceptar() {
		
	}

	@Override
	public void completar() {
	
	}
	private void valorar() { //Hace la votacion para ver cuanto le gusto el desafio
		
	}

	@Override
	public void setDesafio(Desafio desafio) {
		this.desafio = desafio;
	}

	

