package ar.edu.unq.po2.Desafios;

import java.util.Date;
import java.util.List;
import ar.edu.unq.po2.Proyecto.Muestra;

public class DesafioDeUsuario extends Desafio {
	private List<Muestra> muestras;
	private Date fechaDeAceptado;
	private Date fechaCompletado;
	
	public DesafioDeUsuario() {
		super();
		this.muestras = null;
	}

	public void agregarMuestra(Muestra muestra) {
		this.muestras.add(muestra);
	}
	
	public int porcentajeDeCompletitud() {
		return (this.cantidadDeMuestras() * 100)/this.cantidadObjetivoDeMuestras;
	}

	public int cantidadDeMuestras() {
		return this.muestras.size();
	}

	public boolean estaCompleto() {
		return this.cantidadDeMuestras() == this.cantidadObjetivoDeMuestras;
	}
}