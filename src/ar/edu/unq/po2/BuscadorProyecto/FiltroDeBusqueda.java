package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;

import ar.edu.unq.po2.Proyecto.Proyecto;

public interface FiltroDeBusqueda {
	
	public abstract ArrayList<Proyecto> filtrar(ArrayList<Proyecto> proyectosAFiltrar);
	
}