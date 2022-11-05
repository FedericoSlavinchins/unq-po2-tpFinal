package ar.edu.unq.po2.EstadoDesafio;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class Completado implements EstadoDesafio {

	// El protocolo de este estado es fijar que se completo el desafio 
	// por ende los voids son vacios
	
	private DesafioDeUsuario desafioUsuario;
	
	@Override
	public void aceptar() {
		
	}

	@Override
	public void completar() {
	
	}

	@Override
	public void setDesafio(DesafioDeUsuario desafio) {
		this.desafioUsuario = desafio;
	}
}
