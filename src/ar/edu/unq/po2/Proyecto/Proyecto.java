package ar.edu.unq.po2.Proyecto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

public class Proyecto {
	
	private String nombre;
	private String descripcion;
	private List<Usuario> participantesActivos 	= 	new ArrayList<Usuario>();		// Participantes activos en este proyecto actualmente
	private List<Muestra> muestras 				=	new ArrayList<Muestra>();		// Muestras subidas para este proyecto
	private List<Categoria> categorias 			=	new ArrayList<Categoria>();		// Las categorias a las que pertenece el proyecto
	private List<Desafio> desafios 				= 	new ArrayList<Desafio>();		// Los desafios que cumplen los requerimientos del proyecto.
	
	
	public Proyecto(String nombre, String descripcion, ArrayList<Categoria> categorias) {	// Constructor
		this.nombre 		=	nombre;
		this.descripcion 	= 	descripcion;
		this.categorias 	= 	categorias;
	}
	
	public void agregarParticipante(Usuario participante) {		// Agrega participante activo al proyecto
		this.participantesActivos.add(participante);
		participante.agregarProyectoEnLosQueParticipa(this);
	}
	
	public void agregarMuestra(Muestra muestra) {				// Agrega una muestra al proyecto
		this.muestras.add(muestra);
	}
	
	public List<Muestra> getMuestras() {					// Retorna lista de Muestras del proyecto
		return this.muestras;
	}
	
	public List<Usuario> getParticipantesActivos() {		// Retorna lista de Participantes activos del proyecto
		return this.participantesActivos;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	
	public List<String> nombresDeCategorias() {
		List<String> nombres = new ArrayList<String>();
		nombres = this.categorias.stream().map(c -> c.getNombre()).toList();
		return nombres;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void agregarDesafio(Desafio desafio) {
		this.desafios.add(desafio);
	}

	public List<Desafio> getDesafios() {
		return this.desafios;
	}
}
