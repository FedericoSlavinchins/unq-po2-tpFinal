package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Proyecto.Proyecto;

public class BuscadorAnd extends BuscadorCompuesto{
	
	public BuscadorAnd(BuscadorDeProyectos primerBuscador, BuscadorDeProyectos segundoBuscador) {
		super(primerBuscador, segundoBuscador);
	}
	
	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectosAFiltrar) {
		List<Proyecto> primerFiltro = new ArrayList<Proyecto>();
		List<Proyecto> segundoFiltro = new ArrayList<Proyecto>();
		
		primerFiltro.addAll(this.getPrimerBuscador().filtrar(proyectosAFiltrar));
		segundoFiltro.addAll(this.getSegundoBuscador().filtrar(proyectosAFiltrar));
		
		primerFiltro.retainAll(segundoFiltro);		// Se queda solo con los proyectos que se repiten en ambos Array Lists.
		
		return primerFiltro;
	}
	
}
