package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Proyecto.Proyecto;

public abstract class BuscadorSimple extends BuscadorDeProyectos {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectosAFiltrar) {
		List<Proyecto> resultadoBusqueda = new ArrayList<Proyecto>();
		aplicarCriterioDeFiltroATodosLosProyectos(proyectosAFiltrar, resultadoBusqueda);
		return resultadoBusqueda;
	}

	protected void aplicarCriterioDeFiltroATodosLosProyectos(List<Proyecto> proyectosAFiltrar,
			List<Proyecto> resultadoBusqueda) {
		for (Proyecto proyecto : proyectosAFiltrar) {
			aplicarCriterioDeFiltro(resultadoBusqueda, proyecto);
		}
	}

	protected abstract void aplicarCriterioDeFiltro(List<Proyecto> resultadoBusqueda, Proyecto proyecto);	// FS: Deben implementarlo las subclases


}
