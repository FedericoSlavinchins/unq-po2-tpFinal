package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;

import ar.edu.unq.po2.Proyecto.Proyecto;

public abstract class BuscadorDeProyectos implements FiltroDeBusqueda {

	private EstrategiaNegacion  estrategiaNegacion;

	public abstract ArrayList<Proyecto> filtrar(ArrayList<Proyecto> proyectosAFiltrar);

	public EstrategiaNegacion getEstrategiaNegacion() {
		return this.estrategiaNegacion;
	}

	public void setEstrategiaNegacion(EstrategiaNegacion estrategiaNegacion) {
		this.estrategiaNegacion = estrategiaNegacion;
	}

	
}