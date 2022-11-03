package ar.edu.unq.po2.EstadoDesafio;

import java.sql.Date;
import java.time.LocalDate;

import ar.edu.unq.po2.Desafios.Desafio;

public class Aceptado implements EstadoDesafio {
	private Desafio desafio;

	@Override
	public void aceptar() {}

	@Override
	public void completar() {
		
		//this.setDate(Date today)
		desafio.setFechaCompletado(LocalDate.now());
		desafio.setEstado(new Completado()); // Setea estado completado
		this.valorar();
		//Private Recompensa
	}
	@Override
	public void valorar() { //Hace la votacion para ver cuanto le gusto el desafio
		
	}

	@Override
	public void setDesafio(Desafio desafio) {
		this.desafio = desafio;
		
	}
}


