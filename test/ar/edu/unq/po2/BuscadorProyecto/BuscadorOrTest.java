package ar.edu.unq.po2.BuscadorProyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Proyecto;

class BuscadorOrTest {
	
	private BuscadorTitulo buscadorTitulo;
	private BuscadorTitulo buscadorTitulo2;

	private IncluidorDeCategorias buscadorIncluidorCategorias;
	private IncluidorDeCategorias buscadorIncluidorCategorias2;
	
	private BuscadorOr buscadorOr;
	private BuscadorOr buscadorOr1;
	private BuscadorOr buscadorOr2;
	private BuscadorOr buscadorOr3;
	
	private List<String> nombresDeCategoriasABuscar;
	private List<String> nombresDeCategoriasABuscar2;
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Proyecto proyecto3;
	private ArrayList<Proyecto> proyectosAFiltrar;
	private ArrayList<Categoria> listaCategoriasProyecto1;
	private ArrayList<Categoria> listaCategoriasProyecto2;
	private ArrayList<Categoria> listaCategoriasProyecto3;
	private Categoria categoria1;
	private Categoria categoria2;
	private Categoria categoria3;
	private Categoria categoria4;
	private Categoria categoria5;
	private Categoria categoria6;
	
	
	@BeforeEach
	public void setUp() {
		nombresDeCategoriasABuscar = new ArrayList<String>();
		nombresDeCategoriasABuscar.add("Biología");
		nombresDeCategoriasABuscar.add("Química");
		nombresDeCategoriasABuscar2 = new ArrayList<String>();
		nombresDeCategoriasABuscar2.add("Matemática");
		nombresDeCategoriasABuscar2.add("Geometría");
		
		
		// Preparación test 1.
		buscadorTitulo = new BuscadorTitulo("Estrellas");
		buscadorIncluidorCategorias = new IncluidorDeCategorias(nombresDeCategoriasABuscar);
		buscadorOr = new BuscadorOr(buscadorTitulo, buscadorIncluidorCategorias);
		
		// Preparación test 2.
		buscadorTitulo2 = new BuscadorTitulo("Química");
		buscadorOr2 = new BuscadorOr(buscadorTitulo, buscadorTitulo2); // Busca por nombre de proyecto "Estrellas" y "Química".
		buscadorIncluidorCategorias2 = new IncluidorDeCategorias(nombresDeCategoriasABuscar2);
		buscadorOr3 = new BuscadorOr(buscadorIncluidorCategorias, buscadorIncluidorCategorias2);
		buscadorOr1 = new BuscadorOr(buscadorOr2, buscadorOr3);
		
		listaCategoriasProyecto1 = new ArrayList<Categoria>();
		listaCategoriasProyecto2 = new ArrayList<Categoria>();
		
		proyectosAFiltrar = new ArrayList<Proyecto>();
		
		listaCategoriasProyecto1 = new ArrayList<Categoria>();
		listaCategoriasProyecto2 = new ArrayList<Categoria>();
		listaCategoriasProyecto3 = new ArrayList<Categoria>();
		
		categoria1 = new Categoria("Astronomía");
		categoria2 = new Categoria("Física");
		categoria3 = new Categoria("Biología");
		categoria4 = new Categoria("Química");
		categoria5 = new Categoria("Matemática");
		categoria6 = new Categoria("Geometría");
		
		listaCategoriasProyecto1.add(categoria1);
		listaCategoriasProyecto1.add(categoria2);
		listaCategoriasProyecto2.add(categoria3);
		listaCategoriasProyecto2.add(categoria4);
		listaCategoriasProyecto3.add(categoria5);
		listaCategoriasProyecto3.add(categoria6);
		
		
		proyecto1 = new Proyecto("Las Estrellas", "blabla1", listaCategoriasProyecto1);
		proyecto2 = new Proyecto("Biología y Química", "blabla2", listaCategoriasProyecto2);
		proyecto3 = new Proyecto("Las Matemáticas", "blabla2", listaCategoriasProyecto3);
		
		proyectosAFiltrar.add(proyecto1);
		proyectosAFiltrar.add(proyecto2);
		proyectosAFiltrar.add(proyecto3);
		
	}

	@Test
	void losProyectosCorrespondientesAlCriterioDeBusquedaOrEsElProyecto1y2() {
		List<Proyecto> resultadoEsperado = new ArrayList<Proyecto>();
		resultadoEsperado.add(proyecto1);
		resultadoEsperado.add(proyecto2);
		List<Proyecto> resultadoBusqueda = buscadorOr.filtrar(proyectosAFiltrar);
		assertEquals(resultadoEsperado, resultadoBusqueda);
	}
	
	@Test
	void losProyectosCorrespondientesAlCriterioDeBusquedaOrRecursivoSonEl1El2yEl3() {
		List<Proyecto> resultadoEsperado = new ArrayList<Proyecto>();
		resultadoEsperado.add(proyecto1);
		resultadoEsperado.add(proyecto2);
		resultadoEsperado.add(proyecto3);
		List<Proyecto> resultadoBusqueda = buscadorOr1.filtrar(proyectosAFiltrar);
		assertEquals(resultadoEsperado, resultadoBusqueda);
	}
}
