package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class Aceptado implements EstadoDesafio {

	private DesafioDeUsuario desafioUsuario;

	@Override
	public void aceptar(DesafioDeUsuario desafioDeUsuario) {}

	@Override
	public void completar(DesafioDeUsuario desafioDeUsuario) {
		
		this.desafioUsuario = desafioDeUsuario;
		desafioUsuario.setFechaCompletado(LocalDate.now());
		desafioUsuario.setEstado(new Completado()); // Setea estado completado
		
	}
}

