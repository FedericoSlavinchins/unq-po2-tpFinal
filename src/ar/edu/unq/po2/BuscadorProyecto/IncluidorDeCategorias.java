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


	@Override
	public ArrayList<Proyecto> filtrar(ArrayList<Proyecto> proyectosAFiltrar) {
		ArrayList<Proyecto> resultadoBusqueda = new ArrayList<Proyecto>();
		for (Proyecto proyecto : proyectosAFiltrar) {
			if (proyecto.getNombresDeCategorias().containsAll(this.getCategoriasObjetivo())) {
				resultadoBusqueda.add(proyecto);
			}
		}
		return resultadoBusqueda;
	}
	

	
	
}
