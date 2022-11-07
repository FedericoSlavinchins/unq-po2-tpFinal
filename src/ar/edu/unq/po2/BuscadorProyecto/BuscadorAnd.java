package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class BuscadorAnd extends BuscadorCompuesto{

	
	public BuscadorAnd(BuscadorDeProyectos primerBuscador, BuscadorDeProyectos segundoBuscador) {	// CONSTRUCTOR
		this.setPrimerBuscador(primerBuscador);
		this.setSegundoBuscador(segundoBuscador);
	}
	
	
	public ArrayList<Proyecto> filtrar(ArrayList<Proyecto> proyectosAFiltrar) {
		ArrayList<Proyecto> primerFiltro = new ArrayList<Proyecto>();
		ArrayList<Proyecto> segundoFiltro = new ArrayList<Proyecto>();
		
		primerFiltro.addAll(this.getPrimerBuscador().filtrar(proyectosAFiltrar));
		segundoFiltro.addAll(this.getSegundoBuscador().filtrar(proyectosAFiltrar));
		
		primerFiltro.retainAll(segundoFiltro);		// Se queda solo con los proyectos que se repiten en ambos Array Lists.
		
		return primerFiltro;
	}
	
}
