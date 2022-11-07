package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class IncluidorDeCategorias extends BuscadorCategoria {
	
	
	public IncluidorDeCategorias(List<String> categorias) {
		this.setCategoriasObjetivo(categorias);
	}
	
	protected void aplicarCriterioDeFiltro(ArrayList<Proyecto> resultadoBusqueda, Proyecto proyecto) {
		if (proyecto.nombresDeCategorias().containsAll(this.getCategoriasObjetivo())) {
			resultadoBusqueda.add(proyecto);
		}
	}
	
}
