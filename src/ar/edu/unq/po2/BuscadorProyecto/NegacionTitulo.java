package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class NegacionTitulo extends Negacion {
	
	
	public ArrayList<Proyecto> filtrarNegado(ArrayList<Proyecto> proyectosAFiltrar) {
		ArrayList<Proyecto> resultadoBusqueda = new ArrayList<Proyecto>();
		for (Proyecto proyecto : proyectosAFiltrar) {
			if ( ! (proyecto.getNombre().contains(this.getBuscadorANegar().getTextoABuscar())) ) {
				resultadoBusqueda.add(proyecto);
			}
		}
		return resultadoBusqueda;
	}
	
}
