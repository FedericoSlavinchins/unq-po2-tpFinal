package ar.edu.unq.po2.EstadoDesafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public interface EstadoDesafio {
	
	public abstract void aceptar();
	public abstract void completar();
	
	
	public abstract void setDesafio(DesafioDeUsuario desafioDeUsuario);
}