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
	
	
	public Desafio(int cantidadObjetivoDeMuestras,int dificultad,RestriccionTemporal restriccionTemporal, double recompensa) {
		this.cantidadObjetivoDeMuestras = cantidadObjetivoDeMuestras;	//FS: Revisar > El Estado del desafio es de DesafioUsuario
		this.dificultad = dificultad;
		this.restriccionTemporal = restriccionTemporal;
		this.recompensa = recompensa;
	}


	
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


	public double getRecompensa() {
		return recompensa;
	}

	

}



