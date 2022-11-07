package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class Aceptado implements EstadoDesafio {

	private DesafioDeUsuario desafioDeUsuario;

	@Override
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) {
		this.desafioDeUsuario = desafioDeUsuario;
		desafioDeUsuario.setFechaCompletado();
		desafioDeUsuario.setEstado(new Completado()); // Setea estado completado
	}
}

