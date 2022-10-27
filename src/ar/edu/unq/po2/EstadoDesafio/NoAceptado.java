package ar.edu.unq.po2.EstadoDesafio;

import java.sql.Date;

import ar.edu.unq.po2.Desafios.Desafio;

public class NoAceptado implements EstadoDesafio {
	private Desafio desafio;
	private Date date;

	@Override
	public void aceptar() {
		
		desafio.setFechaAceptado(this.date);
		desafio.desafiosAceptados = desafio.desafiosAceptados + 1 ; 
		desafio.setEstado(new Aceptado()); // Setea el estado Aceptados
		
	}

	@Override
	public void completar() {
		
		
	}

	@Override
	public void setDesafio(Desafio desafio) {
		this.desafio = desafio;
		
	}
	

}
