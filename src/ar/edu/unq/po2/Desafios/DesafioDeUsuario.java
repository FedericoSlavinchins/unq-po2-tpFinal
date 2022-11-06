package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.EstadoDesafio.EstadoDesafio;
import ar.edu.unq.po2.EstadoDesafio.NoAceptado;
import ar.edu.unq.po2.Proyecto.Muestra;


public class DesafioDeUsuario {
	
	// FS: Esta clase permite trackear al Desafio.
	// FS: Realiza un seguimiento del progreso del usuario en el Desafio.
	
	private Desafio desafio;
	private ArrayList<Muestra> muestrasRecolectadas = new ArrayList<Muestra>(); // Muestras recolectadas para el desafio.
	private LocalDate fechaAceptado;
	private LocalDate fechaCompletado;
	private EstadoDesafio estado;			//FS: El estado debe estar en esta clase, ya que es parte del progreso del usuario.	
	private int voto;
	private double recompensa;
	
	public double getRecompensa() {
		return recompensa;
	}


	public void setRecompensa(double recompensa) {
		this.recompensa = recompensa;
	}


	public DesafioDeUsuario (Desafio desafio) {
		this.desafio = desafio;
		this.estado  = new NoAceptado();
	}
	

	public EstadoDesafio getEstado() {
			return estado;
		}
		
	
	public void setEstado(EstadoDesafio estado) {
		this.estado = estado;
	}

	public void serAceptado() {
		this.getEstado().aceptar(this);
	}
		
	public int cantidadMuestrasRecolectadasParaEsteDesafio() {
		return this.muestrasRecolectadas.size();
	}
	
	
	
	public void setFechaCompletado(LocalDate fechaEnQueCompletoDesafio) {
		this.fechaCompletado = fechaEnQueCompletoDesafio;
	}
	
	

	public LocalDate getFechaCompletado() {
		return this.fechaCompletado;
	}
	
	
	
	public ArrayList<Muestra> getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}


	public int porcentajeDeCompletitud() {	// FS: Este método nos lleva a no tener la necesidad de tener una variable porcentajeCompletitud, por lo tanto la borro.
		return ((this.cantidadMuestrasRecolectadasParaEsteDesafio() * 100) / this.desafio.getCantidadObjetivoDeMuestras()) ;
	}

	
	
	public int getVoto() {
		return voto;
	}


	public void setFechaAceptado(LocalDate fecha) {
		this.fechaAceptado = fecha;
	}
	
	public LocalDate getFechaAceptado() {
		return fechaAceptado;
	}
	
	public Desafio getDesafio() {
		return this.desafio;
	}
	
	
	// guarda el numero n si esta entre 0 y 5 
	// sino manda mensaje
		public void setVoto(int numero) {
			if(numero >= 0 && numero <= 5 ) {
				voto = numero;
			} else { System. out. println("El voto debe ser entre 0 y 5"); }
		} 

		
	public boolean esMuestraValida(Muestra muestra) {
			return (muestra.getFecha().isEqual(fechaAceptado) || muestra.getFecha().isAfter(fechaAceptado)) //primera parte valida si las muestra es posterior a la fecha de aceptacion
					&& 
			       this.getDesafio().getRestriccionTemporal().cumplioPeriodo(fechaAceptado) // segunda parte valida si cumple las restricciones temporales
			       &&  
			       desafio.getArea().estaEnRango(muestra.getGeocoordenada());		// Tercer parte valida el area de la muestra
		}








}
