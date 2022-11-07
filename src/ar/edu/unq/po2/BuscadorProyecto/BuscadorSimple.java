package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;

import ar.edu.unq.po2.Proyecto.Proyecto;

public abstract class BuscadorSimple extends BuscadorDeProyectos {

	@Override
	public ArrayList<Proyecto> filtrar(ArrayList<Proyecto> proyectosAFiltrar) {
		ArrayList<Proyecto> resultadoBusqueda = new ArrayList<Proyecto>();
		aplicarCriterioDeFiltroATodosLosProyectos(proyectosAFiltrar, resultadoBusqueda);
		return resultadoBusqueda;
	}

	protected void aplicarCriterioDeFiltroATodosLosProyectos(ArrayList<Proyecto> proyectosAFiltrar,
			ArrayList<Proyecto> resultadoBusqueda) {
		for (Proyecto proyecto : proyectosAFiltrar) {
			aplicarCriterioDeFiltro(resultadoBusqueda, proyecto);
		}
	}

	protected abstract void aplicarCriterioDeFiltro(ArrayList<Proyecto> resultadoBusqueda, Proyecto proyecto);	// FS: Deben implementarlo las subclases


}
