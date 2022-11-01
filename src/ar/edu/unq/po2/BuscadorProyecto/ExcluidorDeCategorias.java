package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class ExcluidorDeCategorias extends BuscadorCategoria {
	
	public ExcluidorDeCategorias(List<String> categorias) {
		this.setCategoriasObjetivo(categorias);
	}

	@Override
	public ArrayList<Proyecto> filtrar(ArrayList<Proyecto> proyectosAFiltrar) {
		ArrayList<Proyecto> resultadoBusqueda = new ArrayList<Proyecto>();
		for (Proyecto proyecto : proyectosAFiltrar) {
			if (!(proyecto.getNombresDeCategorias().containsAll(this.getCategoriasObjetivo()))) {
				resultadoBusqueda.add(proyecto);
			}
		}
		return resultadoBusqueda;
	}

}
