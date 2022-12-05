package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class BuscadorOr extends BuscadorCompuesto {
	
	public BuscadorOr(BuscadorDeProyectos primerBuscador, BuscadorDeProyectos segundoBuscador) {
		super(primerBuscador, segundoBuscador);
	}
	
	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectosAFiltrar) {
		List<Proyecto> primerFiltro = new ArrayList<Proyecto>();
		List<Proyecto> segundoFiltro = new ArrayList<Proyecto>();
		List<Proyecto> filtroFinal = new ArrayList<Proyecto>();
		
		primerFiltro.addAll(this.getPrimerBuscador().filtrar(proyectosAFiltrar));
		segundoFiltro.addAll(this.getSegundoBuscador().filtrar(proyectosAFiltrar));
		
		filtroFinal.addAll(primerFiltro);
		filtroFinal.addAll(segundoFiltro);		// Se queda con los proyectos des ambos Array Lists.
		
		return resultadoBusquedaSinDuplicados(filtroFinal);
	}

	

}

