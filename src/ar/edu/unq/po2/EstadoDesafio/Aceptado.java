package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class Aceptado implements EstadoDesafio {

	private DesafioDeUsuario desafioUsuario;

	@Override
	public void aceptar(DesafioDeUsuario desafioDeUsuario) {}

	@Override
	public void completar(DesafioDeUsuario desafioDeUsuario) {
		
		//this.setDate(Date today)
		desafioUsuario.setFechaCompletado(LocalDate.now());
		desafioUsuario.setEstado(new Completado()); // Setea estado completado
		
	}

	@Override
	public void setDesafio(DesafioDeUsuario desafio) {
		this.desafioUsuario = desafio;
		
	}
}

