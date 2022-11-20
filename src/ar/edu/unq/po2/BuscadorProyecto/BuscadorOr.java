package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class BuscadorOr extends BuscadorCompuesto {
	
	public BuscadorOr(BuscadorDeProyectos primerBuscador, BuscadorDeProyectos segundoBuscador) {	// CONSTRUCTOR
		this.setPrimerBuscador(primerBuscador);
		this.setSegundoBuscador(segundoBuscador);
	}

	
	public ArrayList<Proyecto> filtrar(ArrayList<Proyecto> proyectosAFiltrar) {
		ArrayList<Proyecto> primerFiltro = new ArrayList<Proyecto>();
		ArrayList<Proyecto> segundoFiltro = new ArrayList<Proyecto>();
		ArrayList<Proyecto> filtroFinal = new ArrayList<Proyecto>();
		
		primerFiltro.addAll(this.getPrimerBuscador().filtrar(proyectosAFiltrar));
		segundoFiltro.addAll(this.getSegundoBuscador().filtrar(proyectosAFiltrar));
		
		filtroFinal.addAll(primerFiltro);
		filtroFinal.addAll(segundoFiltro);		// Se queda con los proyectos des ambos Array Lists.
		
		return resultadoBusquedaSinDuplicados(filtroFinal);
	}


}

