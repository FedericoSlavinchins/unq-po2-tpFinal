package ar.edu.unq.po2.Sistema;

import java.util.ArrayList;

import ar.edu.unq.po2.BuscadorProyecto.BuscadorDeProyectos;
import ar.edu.unq.po2.Proyecto.Proyecto;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

public class Sistema {						// Representa al sistema de Ciencia Participativa.
	
	private ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
	private ArrayList<Usuario> 	usuarios  = new ArrayList<Usuario>();
	private BuscadorDeProyectos buscadorDeProyectos;
	
	
	public void agregarProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	
	public BuscadorDeProyectos getBuscadorDeProyectos() {
		return buscadorDeProyectos;
	}
	
	public void setBuscadorDeProyectos(BuscadorDeProyectos buscadorDeProyectos) {
		this.buscadorDeProyectos = buscadorDeProyectos;
	}
	
	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
}
