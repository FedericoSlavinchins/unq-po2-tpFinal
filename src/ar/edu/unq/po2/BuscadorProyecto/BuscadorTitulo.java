package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class BuscadorTitulo extends BuscadorSimple {
	
	private String textoABuscar;
	
	public BuscadorTitulo(String textoABuscar) {
		this.textoABuscar = textoABuscar;
	}

	protected void aplicarCriterioDeFiltro(ArrayList<Proyecto> resultadoBusqueda, Proyecto proyecto) {
		if (proyecto.getNombre().contains(this.textoABuscar)) {
			resultadoBusqueda.add(proyecto);
		}
	}
	
}
