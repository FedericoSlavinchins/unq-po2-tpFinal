package ar.edu.unq.po2.BuscadorProyecto;

import java.util.ArrayList;

import ar.edu.unq.po2.Proyecto.Proyecto;

public abstract class BuscadorCompuesto extends BuscadorDeProyectos {
	
	private BuscadorDeProyectos primerBuscador;
	private BuscadorDeProyectos segundoBuscador;
	
	public BuscadorCompuesto(BuscadorDeProyectos primerBuscador, BuscadorDeProyectos segundoBuscador) {
		this.setPrimerBuscador(primerBuscador);
		this.setSegundoBuscador(segundoBuscador);
	}
	
	
	public abstract ArrayList<Proyecto> filtrar(ArrayList<Proyecto> proyectosAFiltrar);
	
	protected ArrayList<Proyecto> resultadoBusquedaSinDuplicados(ArrayList<Proyecto> listaDeProyectos) {
		ArrayList<Proyecto> listaSinDuplicados = new ArrayList<Proyecto>();
		for (Proyecto proyecto : listaDeProyectos) {
			if (!listaSinDuplicados.contains(proyecto)) {
				listaSinDuplicados.add(proyecto);
			}
		}
		return listaSinDuplicados;
	}
	
	public BuscadorDeProyectos getPrimerBuscador() {
		return primerBuscador;
	}
	public void setPrimerBuscador(BuscadorDeProyectos primerBuscador) {
		this.primerBuscador = primerBuscador;
	}
	public BuscadorDeProyectos getSegundoBuscador() {
		return segundoBuscador;
	}
	public void setSegundoBuscador(BuscadorDeProyectos segundoBuscador) {
		this.segundoBuscador = segundoBuscador;
	}
	
}
