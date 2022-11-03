package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;

import ar.edu.unq.po2.Proyecto.Proyecto;

public interface EstrategiaNegacion {
	
	public abstract ArrayList<Proyecto> filtrarNegado(ArrayList<Proyecto> proyectosAFiltrar);
	
}
