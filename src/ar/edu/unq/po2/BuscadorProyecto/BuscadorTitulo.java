package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class BuscadorTitulo extends BuscadorDeProyectos {
	
	private String textoABuscar;
	
	public BuscadorTitulo(String textoABuscar) {
		this.textoABuscar = textoABuscar;
	}


	@Override
	public ArrayList<Proyecto> filtrar(ArrayList<Proyecto> proyectosAFiltrar) {
		ArrayList<Proyecto> resultadoBusqueda = new ArrayList<Proyecto>();
		for (Proyecto proyecto : proyectosAFiltrar) {
			if (proyecto.getNombre().contains(this.textoABuscar)) {
				resultadoBusqueda.add(proyecto);
			}
		}
		return resultadoBusqueda;
	}


	public String getTextoABuscar() {
		return textoABuscar;
	}	
	
}
