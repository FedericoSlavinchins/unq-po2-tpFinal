package ar.edu.unq.po2.Sistema;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.BuscadorProyecto.BuscadorDeProyectos;
import ar.edu.unq.po2.BuscadorProyecto.FiltroDeBusqueda;
import ar.edu.unq.po2.Proyecto.Proyecto;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

public class Sistema {			// Representa al sistema de Ciencia Participativa.
	
	private ArrayList<Proyecto> proyectos;
	private ArrayList<Usuario> 	usuarios;
	private FiltroDeBusqueda buscadorDeProyectos;
	
	public Sistema() {
		this.proyectos = new ArrayList<Proyecto>();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public ArrayList<Proyecto> buscarProyectosUsando(FiltroDeBusqueda buscadorDeProyectos) {
		this.buscadorDeProyectos = buscadorDeProyectos;
		return (this.buscadorDeProyectos.filtrar(this.proyectos));
	}
	
	
	public void agregarProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public FiltroDeBusqueda getBuscadorDeProyectos() {
		return buscadorDeProyectos;
	}
	
	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
}
