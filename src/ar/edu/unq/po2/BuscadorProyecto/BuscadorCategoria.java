package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Proyecto.Proyecto;

public abstract class BuscadorCategoria extends BuscadorDeProyectos {
	
	private List<String> categoriasObjetivo;
	
	public void setCategoriasObjetivo(List<String> categorias) {
		this.categoriasObjetivo = categorias;
	}

	public List<String> getCategoriasObjetivo() {
		return categoriasObjetivo;
	}

}
