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
	
<<<<<<< HEAD
	// private int porcentaje;			<--- FS: Lo moví a DesafioUsuario, tiene que ver con el progreso del usuario en el desafio.
	// agregados
	// private int desafiosAceptados;	<--- FS: Esto va en Usuario. No lo borré por las dudas.
	// private int voto;				<--- FS: El voto es personal de cada usuario, no de todos los usuarios, lo muevo a DesafioDeUsuario.
	// private LocalDate fechaAceptado; <--- FS: Esto va en DesafioUsuario. No lo borré por las dudas.

	
	
	// construct 
	
	public Desafio(int cantidadObjetivoDeMuestras,int dificultad,RestriccionTemporal restriccionTemporal) {
		this.cantidadObjetivoDeMuestras = cantidadObjetivoDeMuestras;	//FS: Revisar > El Estado del desafio es de DesafioUsuario
		this.dificultad = dificultad;
		this.restriccionTemporal = restriccionTemporal;
	}
	
	
=======
>>>>>>> branch 'main-2' of https://github.com/FedericoSlavinchins/unq-po2-tpFinal.git
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


	public double getRecompensa() {
		return recompensa;
	}

	

}



