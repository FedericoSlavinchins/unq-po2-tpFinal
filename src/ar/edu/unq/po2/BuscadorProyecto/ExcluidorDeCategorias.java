package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class ExcluidorDeCategorias extends BuscadorCategoria {
	
	public ExcluidorDeCategorias(List<String> categorias) {
		this.setCategoriasObjetivo(categorias);
	}


	protected void aplicarCriterioDeFiltro(List<Proyecto> resultadoBusqueda, Proyecto proyecto) {
		if (!(proyecto.nombresDeCategorias().containsAll(this.getCategoriasObjetivo()))) {
			resultadoBusqueda.add(proyecto);
		}
	}

}
