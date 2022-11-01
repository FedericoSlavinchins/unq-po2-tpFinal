package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;


import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.ElementoDeLudificacion;

public class Usuario {
	
	private ArrayList<Gusto> 		  	preferencias;				// Gustos del usuario previo a empezar a jugar
	private ArrayList<Comportamiento> 	comportamientos;			// Comportamientos del usuario en el transcurso del juego
	private RecomendadorDeLudificacion 	recomendadorDeLudificacion 	= new RecomendadorDeLudificacion(); //Agregar params
	private ArrayList<Desafio>			desafiosAceptados 			= new ArrayList<Desafio>();
	private ArrayList<Desafio>			desafiosCompletados			= new ArrayList<Desafio>();

	
	
	public void aceptarDesafio(Desafio desafio) {
		this.desafiosAceptados.add(desafio);
	}
	
	public void completarDesafio(Desafio desafio) {
		this.desafiosAceptados.remove(desafio);
		this.desafiosCompletados.add(desafio);
		//Otorgar recompensa
	}
	
	
	
}
