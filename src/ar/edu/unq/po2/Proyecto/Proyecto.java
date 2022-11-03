package ar.edu.unq.po2.Proyecto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.SistemaUsuario.Usuario;

public class Proyecto {
	
	private String nombre;
	private String descripcion;
	private ArrayList<Usuario> participantesActivos;		// Participantes activos en este proyecto actualmente
	private ArrayList<Muestra> muestras;					// Muestras subidas para este proyecto
	private ArrayList<Categoria> categorias;				// Las categorias a las que pertenece el proyecto
	
	
	
	public Proyecto(String nombre, String descripcion, ArrayList<Categoria> categorias) {	// Constructor
		this.nombre 		=	nombre;
		this.descripcion 	= 	descripcion;
		this.categorias 	= 	categorias;
	}
	
	public void agregarParticipante(Usuario participante) {		// Agrega participante activo al proyecto
		this.participantesActivos.add(participante);
	}
	
	public void agregarMuestra(Muestra muestra) {				// Agrega una muestra al proyecto
		this.muestras.add(muestra);
	}
	
	public ArrayList<Muestra> getMuestras() {					// Retorna lista de Muestras del proyecto
		return this.muestras;
	}
	
	public ArrayList<Usuario> getParticipantesActivos() {		// Retorna lista de Participantes activos del proyecto
		return this.participantesActivos;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	
	public List<String> getNombresDeCategorias() {
		ArrayList<String> nombres = new ArrayList<String>();
		for (Categoria categoria : this.categorias) {
			nombres.add(categoria.getNombre());
		}
		return nombres;
	}
}
