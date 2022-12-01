package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class NoAceptado implements EstadoDesafio {
	
	
	@Override  
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) throws Exception {
		if (desafioDeUsuario.porcentajeDeCompletitud() == 0) {
			desafioDeUsuario.setFechaAceptado(); 					// Settea la fecha en la que se acepto.
			desafioDeUsuario.setEstado(new Aceptado()); 			// Settea el estado Aceptado.
		} else {
			throw new Exception("El desafio ya fue iniciado anteriormente");
		}
	}
}

