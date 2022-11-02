package ar.edu.unq.po2.EstadoDesafio;
import ar.edu.unq.po2.Desafios.Desafio;

public interface EstadoDesafio {
	
//	private EstadoDesafio estado ; // Deberia empezar en NoAceptado 
	
	
	public abstract void aceptar();
	public abstract void completar();
	
	public abstract void setDesafio(Desafio desafio);
