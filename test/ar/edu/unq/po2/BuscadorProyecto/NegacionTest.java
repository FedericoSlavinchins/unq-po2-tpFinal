package ar.edu.unq.po2.BuscadorProyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Proyecto;

class NegacionTest {

	private BuscadorTitulo buscadorTitulo;
	private Negacion buscadorNegacion;
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private ArrayList<Proyecto> proyectosAFiltrar;
	private ArrayList<Categoria> listaCategorias;
	private Categoria categoria;
	
	
	@BeforeEach
	public void setUp() {
		buscadorTitulo = new BuscadorTitulo("Estrellas");
		buscadorNegacion = new Negacion(buscadorTitulo);
		
		listaCategorias = new ArrayList<Categoria>();
		
		proyecto1 = new Proyecto("Posición de las Estrellas", "bla1", listaCategorias);
		proyecto2 = new Proyecto("Arboles y plantas", "bla2", listaCategorias);
		
		proyectosAFiltrar = new ArrayList<Proyecto>();
		proyectosAFiltrar.add(proyecto1);
		proyectosAFiltrar.add(proyecto2);
		
		categoria = new Categoria("categoriaNombre");
		listaCategorias.add(categoria);
	}

	@Test
	void cuandoSeUsaNegacionSobreBusquedaPorTituloEstrellaRetornaProyectoQueNoContieneEseTitulo() {
		ArrayList<Proyecto> resultadoEsperado = new ArrayList<Proyecto>();
		resultadoEsperado.add(proyecto2);
		ArrayList<Proyecto> resultadoBusqueda = buscadorNegacion.filtrar(proyectosAFiltrar);
		assertEquals(resultadoEsperado, resultadoBusqueda);
	}
	
	@Test
	
	void cuandoSeUsaGetterBuscadorANegarSobreElBuscadorNegacionRetornaElBuscadorTitulo() {
		BuscadorTitulo resultadoEsperado = buscadorTitulo;
		BuscadorDeProyectos resultado 	 = buscadorNegacion.getBuscadorANegar();
		assertEquals(resultadoEsperado, resultado);
	}
}
