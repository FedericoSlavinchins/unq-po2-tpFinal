package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Proyecto.Proyecto;

public interface FiltroDeBusqueda {
	
	public abstract List<Proyecto> filtrar(List<Proyecto> proyectosAFiltrar);
	
}