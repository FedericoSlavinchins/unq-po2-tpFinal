package ar.edu.unq.po2.Desafios;


import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.EstadoDesafio.EstadoDesafio;
import ar.edu.unq.po2.EstadoDesafio.NoAceptado;

import ar.edu.unq.po2.Proyecto.AreaGeografica;

public class Desafio  {
	
	private AreaGeografica area;
	private RestriccionTemporal restriccionTemporal;
	private int cantidadObjetivoDeMuestras;
	private int dificultad;
	private double recompensa;
	
	// private int porcentaje;			<--- FS: Lo moví a DesafioUsuario, tiene que ver con el progreso del usuario en el desafio.
	// agregados
	// private int desafiosAceptados;	<--- FS: Esto va en Usuario. No lo borré por las dudas.
		private int voto;
	// private LocalDate fechaAceptado; <--- FS: Esto va en DesafioUsuario. No lo borré por las dudas.

	
	
	// construct 
	/*
	public Desafio() {
		setEstado(new NoAceptado());	FS: Revisar > El Estado del desafio es de DesafioUsuario
	}*/
	
	
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

	public int getVoto() {
		return voto;
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
	 
	
	

	public void aceptar() {}
	public void completar() {}
	
		
	

}



