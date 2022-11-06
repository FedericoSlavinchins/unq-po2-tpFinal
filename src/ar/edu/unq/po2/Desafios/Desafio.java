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
	
	// private int porcentaje;			<--- FS: Lo moví a DesafioUsuario, tiene que ver con el progreso del usuario en el desafio.
	// agregados
	// private int desafiosAceptados;	<--- FS: Esto va en Usuario. No lo borré por las dudas.
	// private int voto;				<--- FS: El voto es personal de cada usuario, no de todos los usuarios, lo muevo a DesafioDeUsuario.
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



