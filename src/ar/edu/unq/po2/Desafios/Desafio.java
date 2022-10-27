package ar.edu.unq.po2.Desafios;

import java.sql.Date;
import java.util.ArrayList;

import ar.edu.unq.po2.EstadoDesafio.EstadoDesafio;

public class Desafio implements ElementoDeLudificacion {
	
	//private AreaGeografica area;
	private ArrayList<Date> restriccionTemporal;
	private int cantidadObjetivoDeMuestras;
	private Dificultad dificultad;
	private double recompensa;
	//private ArrayList<Actividad> actividades;
	private int porcentaje;
	private Date fechaCompletado;
	private Date fechaAceptado;
	private EstadoDesafio estado;
	
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

	public void setEstado(EstadoDesafio estado) {
		this.estado = estado;
	}

}
