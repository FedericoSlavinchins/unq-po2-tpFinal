package ar.edu.unq.po2.Desafios;


import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.EstadoDesafio.EstadoDesafio;
import ar.edu.unq.po2.EstadoDesafio.NoAceptado;

import ar.edu.unq.po2.Proyecto.AreaGeografica;

public class Desafio implements ElementoDeLudificacion {
	
	private AreaGeografica area;
	private RestriccionTemporal restriccionTemporal;
	private int cantidadObjetivoDeMuestras;
	private int dificultad;
	private double recompensa;
	
	//GETTERS AND SETTERS
	

	public int getCantidadObjetivoDeMuestras() {
		return cantidadObjetivoDeMuestras;
	}

	public AreaGeografica getArea() {
		return area;
	}


	public RestriccionTemporal getRestriccionTemporal() {
		return restriccionTemporal;
	}

	public void setRestriccionTemporal(RestriccionTemporal restriccionTemporal) {
		this.restriccionTemporal = restriccionTemporal;
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
	

}



