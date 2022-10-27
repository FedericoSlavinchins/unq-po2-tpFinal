package ar.edu.unq.po2.Desafios;

import java.sql.Date;
import java.util.ArrayList;

import ar.edu.unq.po2.EstadoDesafio.EstadoDesafio;
import ar.edu.unq.po2.EstadoDesafio.NoAceptado;

public class Desafio implements ElementoDeLudificacion {
	
	//private AreaGeografica area;
	private ArrayList<Date> restriccionTemporal;
	private int cantidadObjetivoDeMuestras;
	private Dificultad dificultad;
	private double recompensa;
	//private ArrayList<Actividad> actividades;
	private int porcentaje;
	private Date fechaCompletado;
	
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
	
	
	public ArrayList<Date> getRestriccionTemporal() {
		return restriccionTemporal;
	}

	public void setRestriccionTemporal(ArrayList<Date> restriccionTemporal) {
		this.restriccionTemporal = restriccionTemporal;
	}

	public int getCantidadObjetivoDeMuestras() {
		return cantidadObjetivoDeMuestras;
	}

	public void setCantidadObjetivoDeMuestras(int cantidadObjetivoDeMuestras) {
		this.cantidadObjetivoDeMuestras = cantidadObjetivoDeMuestras;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
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
	
		
	
	

}
