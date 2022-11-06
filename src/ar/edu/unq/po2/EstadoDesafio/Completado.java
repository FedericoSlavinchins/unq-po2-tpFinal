package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class Completado implements EstadoDesafio {

	// El protocolo de este estado es fijar que se completo el desafio 
	// por ende los voids son vacios
	
	private DesafioDeUsuario desafioUsuario;

	@Override
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) {
		// El comportamiento es hacer nada. El desafio debe quedarse en Completado.
	}


}
