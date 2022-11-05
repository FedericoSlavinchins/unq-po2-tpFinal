package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class Negacion extends BuscadorDeProyectos {
	
private	BuscadorDeProyectos buscadorANegar;

	
	public Negacion(BuscadorDeProyectos buscadorDeProyectos) {
		this.setBuscadorANegar(buscadorDeProyectos);
	}
	
	
	@Override
	public ArrayList<Proyecto> filtrar(ArrayList<Proyecto> proyectosAFiltrar) {
		ArrayList<Proyecto> proyectosASacar 	= this.buscadorANegar.filtrar(proyectosAFiltrar);
		ArrayList<Proyecto> resultadoBusqueda 	= new ArrayList<Proyecto>();
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
