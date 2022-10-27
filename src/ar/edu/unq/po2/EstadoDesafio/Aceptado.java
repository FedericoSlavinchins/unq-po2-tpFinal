package ar.edu.unq.po2.EstadoDesafio;



import java.sql.Date;

import ar.edu.unq.po2.Desafios.Desafio;

public class Aceptado implements EstadoDesafio {
	private Desafio desafio;
	private Date date;

	@Override
	public void aceptar() {
		
	}

	@Override
	public void completar() {
		desafio.setFechaCompletado(this.date);
		desafio.setEstado(new Completado()); // Setea estado completado
	}
}
