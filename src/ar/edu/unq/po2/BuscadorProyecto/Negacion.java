package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class Negacion extends BuscadorDeProyectos {
	
private	BuscadorDeProyectos buscadorANegar;

	
	public Negacion(BuscadorDeProyectos buscadorDeProyectos) {
		this.setBuscadorANegar(buscadorDeProyectos);
	}
	
	
	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectosAFiltrar) {
		List<Proyecto> proyectosASacar 	= this.buscadorANegar.filtrar(proyectosAFiltrar);
		List<Proyecto> resultadoBusqueda = new ArrayList<Proyecto>();
		for (Proyecto proyecto : proyectosAFiltrar) {
			if ( ! (proyectosASacar.contains(proyecto)) ) {		// Retorna todos los proyectos pasados por el parámetro, excepto los
				resultadoBusqueda.add(proyecto);				// del resultado de búsqueda del buscador sin el 'not'.
			}
		}
		return resultadoBusqueda;
	}
	
	public void setBuscadorANegar(BuscadorDeProyectos buscadorANegar) {
		this.buscadorANegar = buscadorANegar;
	}


	public BuscadorDeProyectos getBuscadorANegar() {
		return buscadorANegar;
	}


	
	
}
