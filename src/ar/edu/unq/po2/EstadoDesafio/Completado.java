package ar.edu.unq.po2.EstadoDesafio;

import java.sql.Date;

import ar.edu.unq.po2.Desafios.Desafio;

public class Completado implements EstadoDesafio {
	private Desafio desafio;
	private Date date;
	
	@Override
	public void aceptar() {
		
	}

	@Override
	public void completar() {
		desafio.setFechaAceptado(this.date);
	}
	

}
