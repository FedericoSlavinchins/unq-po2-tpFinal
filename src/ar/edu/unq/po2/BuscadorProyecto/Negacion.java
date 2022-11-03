package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class Negacion extends BuscadorDeProyectos {
	
	private	BuscadorDeProyectos buscadorANegar;

	
	public Negacion(BuscadorDeProyectos buscadorDeProyectos) {
		this.setBuscadorANegar(buscadorDeProyectos);
	}
	
	
	@Override
	public ArrayList<Proyecto> filtrar(ArrayList<Proyecto> proyectosAFiltrar) {
		return (this.buscadorANegar.getEstrategiaNegacion().filtrarNegado(proyectosAFiltrar));
	}
	
	public void setBuscadorANegar(BuscadorDeProyectos buscadorANegar) {
		this.buscadorANegar = buscadorANegar;
	}


	public BuscadorDeProyectos getBuscadorANegar() {
		return buscadorANegar;
	}

}