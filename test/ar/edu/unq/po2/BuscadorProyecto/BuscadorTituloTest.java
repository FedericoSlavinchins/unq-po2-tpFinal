package ar.edu.unq.po2.BuscadorProyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Proyecto;

class BuscadorTituloTest {

	private BuscadorTitulo buscadorTitulo;
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private ArrayList<Proyecto> proyectosAFiltrar;
	private ArrayList<Categoria> listaCategorias;
	private Categoria categoria;
	
	
	@BeforeEach
	public void setUp() {
		buscadorTitulo = new BuscadorTitulo("Estrellas");
		listaCategorias = new ArrayList<Categoria>();
		
		proyectosAFiltrar = new ArrayList<Proyecto>();
		
		proyecto1 = new Proyecto("Posición de las Estrellas", "bla1", listaCategorias);
		proyecto2 = new Proyecto("Arboles y plantas", "bla2", listaCategorias);
		
		proyectosAFiltrar.add(proyecto1);
		proyectosAFiltrar.add(proyecto2);
		
		categoria = new Categoria("categoriaNombre");
		listaCategorias.add(categoria);
	}

	@Test
	void elProyectoCorrespondienteAlCriterioDeBusquedaEsElProyecto1() {
		List<Proyecto> resultadoEsperado = new ArrayList<Proyecto>();
		resultadoEsperado.add(proyecto1);
		List<Proyecto> resultadoBusqueda = buscadorTitulo.filtrar(proyectosAFiltrar);
		assertEquals(resultadoEsperado, resultadoBusqueda);
	}

}
