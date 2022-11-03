package ar.edu.unq.po2.Desafios;


import java.sql.Date;
import java.util.ArrayList;

import ar.edu.unq.po2.EstadoDesafio.EstadoDesafio;
import ar.edu.unq.po2.EstadoDesafio.NoAceptado;
import ar.edu.unq.po2.Proyecto.AreaGeografica;

	public class Desafio  {

	protected AreaGeografica area;
	protected ArrayList<RestriccionTemporal> restriccionTemporal = new ArrayList<RestriccionTemporal>();
	protected int cantidadObjetivoDeMuestras;
	protected int dificultad;
	protected double recompensa;
	protected int porcentaje;
	protected Date fechaCompletado;
	// agregados
	public int desafiosAceptados;
	private int voto;
	private int cantidadMuestrasRealizadas;
	private Date fechaAceptado;

	
	private EstadoDesafio estado;
	
	
	// construct 
	
	public Desafio() {
		setEstado(new NoAceptado());
	}
	
	
	//GETTERS AND SETTERS
	

	public int getCantidadObjetivoDeMuestras() {
		return cantidadObjetivoDeMuestras;
	}

	public void setCantidadObjetivoDeMuestras(int cantidadObjetivoDeMuestras) {
		this.cantidadObjetivoDeMuestras = cantidadObjetivoDeMuestras;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	public double getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(double recompensa) {
		this.recompensa = recompensa;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	
	
	public Date getFechaCompletado() {
		return fechaCompletado;
	}

	public void setFechaCompletado(Date fechaCompletado) {
		this.fechaCompletado = fechaCompletado;
	}

	public Date getFechaAceptado() {
		return fechaAceptado;
	}

	public void setFechaAceptado(Date fechaAceptado) {
		this.fechaAceptado = fechaAceptado;
	}

	public EstadoDesafio getEstado() {
		return estado;
	}

	public int getVoto() {
		return voto;
	}

	public void setEstado(EstadoDesafio estado) {
		this.estado = estado;
		this.estado.setDesafio(this); //guarda la referencia de el estado de este desafio
	}

	public int getDesafiosAceptados() {
		return desafiosAceptados;
	}
	
	// MAS Methods

	public void AceptarDesafio() {
		
	}
	
	
	// guarda el numero n si esta entre 0 y 5 
	// sino manda mensaje
	public void votar(int n ) {
		if(n >= 0 && n <= 5 ) {
			this.voto = n;
		} else { System. out. println("El voto debe ser entre 0 y 5"); }
	}
	 
	
	public int porcentajeCompletitud() {
		return (this.cantidadMuestrasRealizadas * 100) / this.cantidadObjetivoDeMuestras ;
	}

	public void aceptar() {}
	public void completar() {}
	
		
	
	

}



