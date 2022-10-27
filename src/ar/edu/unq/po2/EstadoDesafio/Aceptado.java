package ar.edu.unq.po2.EstadoDesafio;



import java.sql.Date;

import ar.edu.unq.po2.Desafios.Desafio;

public class Aceptado implements EstadoDesafio {
	private Desafio desafio;
	private Date date;

	@Override
	public void aceptar() {
		desafio.setFechaAceptado(this.date);
	}

	@Override
	public void completar() {
		
	}
}
