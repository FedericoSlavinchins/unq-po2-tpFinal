package ar.edu.unq.po2.EstadoDesafio;

import ar.edu.unq.po2.Desafios.Desafio;

public interface EstadoDesafio {
	
//	private EstadoDesafio estado ; // Deberia empezar en NoAceptado 
	
	
	public void aceptar();
	public void completar();
	
	public void setDesafio(Desafio desafio);
}
