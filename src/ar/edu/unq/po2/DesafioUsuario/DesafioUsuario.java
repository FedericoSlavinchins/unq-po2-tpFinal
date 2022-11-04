package ar.edu.unq.po2.DesafioUsuario;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.EstadoDesafio.NoAceptado;
import ar.edu.unq.po2.Proyecto.Muestra;


public class DesafioUsuario {

	private ArrayList<Muestra> muestrasUsuario = new ArrayList<Muestra>(); 
	private LocalDate fechaCompletado;
	private LocalDate fechaAceptado;
	
// Constructor!!
	
	public DesafioUsuario(Desafio desafio) {
		desafio.setEstado(new NoAceptado());
	}
	
 // GETTERS AND SETTERS!
	public ArrayList<Muestra> getMuestrasUsuario() {
		return muestrasUsuario;
	}
	public void agregarMuestrasUsuario(Muestra muestra) {
		this.muestrasUsuario.add(muestra);
	}
	public LocalDate getFechaCompletado() {
		return fechaCompletado;
	}
	public void setFechaCompletado(LocalDate fechaCompletado) {
		this.fechaCompletado = fechaCompletado;
	}
	public LocalDate getFechaAceptado() {
		return fechaAceptado;
	}
	public void setFechaAceptado(LocalDate fechaAceptado) {
		this.fechaAceptado = fechaAceptado;
	}
	
	public int porcentajeCompletitud(Desafio desafio) {
		return (desafio.getCantidadMuestrasRealizadas()* 100 / desafio.getCantidadObjetivoDeMuestras()); 
	}
	
// OTHERS	
	public void aceptar(Desafio desafio) {
		
	}
	public void completar(Desafio desafio) {
		
	}
}
