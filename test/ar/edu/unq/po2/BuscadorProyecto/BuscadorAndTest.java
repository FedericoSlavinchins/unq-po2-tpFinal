package ar.edu.unq.po2.BuscadorProyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Proyecto;

class BuscadorAndTest {

	private BuscadorTitulo buscadorTitulo;
	private BuscadorTitulo buscadorTitulo2;
	private IncluidorDeCategorias buscadorIncluidorCategorias;
	private IncluidorDeCategorias buscadorIncluidorCategorias2;
	private BuscadorAnd buscadorAnd;
	private BuscadorAnd buscadorAnd1;
	private BuscadorAnd buscadorAnd2;
	private BuscadorAnd buscadorAnd3;
	
	private List<String> nombresDeCategoriasABuscar;
	private List<String> nombresDeCategoriasABuscar2;
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Proyecto proyecto3;
	private Proyecto proyecto4;
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
		nombresDeCategoriasABuscar.add("Astronomía");
		nombresDeCategoriasABuscar.add("Física");
		
		// Preparación de test 1.
		buscadorTitulo = new BuscadorTitulo("Estrellas");
		buscadorIncluidorCategorias = new IncluidorDeCategorias(nombresDeCategoriasABuscar);
		buscadorAnd = new BuscadorAnd(buscadorTitulo, buscadorIncluidorCategorias);
		
		// Preparación de test 2.
		buscadorTitulo2 = new BuscadorTitulo("Planetas");
		buscadorIncluidorCategorias2 = new IncluidorDeCategorias(nombresDeCategoriasABuscar2);
		nombresDeCategoriasABuscar2 = new ArrayList<String>();
		nombresDeCategoriasABuscar2.add("Astronomía");
		buscadorAnd2 = new BuscadorAnd(buscadorTitulo, buscadorTitulo2);
		buscadorAnd3 = new BuscadorAnd(buscadorIncluidorCategorias, buscadorIncluidorCategorias);
		buscadorAnd1 = new BuscadorAnd(buscadorAnd2, buscadorAnd3);
		
		
		
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
		
		
		proyecto1 = new Proyecto("Las Estrellas y Planetas", "blabla1", listaCategoriasProyecto1);
		proyecto2 = new Proyecto("Biología y Química", "blabla2", listaCategoriasProyecto2);
		proyecto3 = new Proyecto("Las Matemáticas", "blabla3", listaCategoriasProyecto3);
		proyecto4 = new Proyecto("Biología y Química  en Planetas de otras Estrellas", "blabla4", listaCategoriasProyecto1);
		
		
		proyectosAFiltrar.add(proyecto1);
		proyectosAFiltrar.add(proyecto2);
		proyectosAFiltrar.add(proyecto3);
		proyectosAFiltrar.add(proyecto4);
		
	}

	@Test
	void losProyectosCorrespondientesAlCriterioDeBusquedaAndSonEl1yEl4() {
		ArrayList<Proyecto> resultadoEsperado = new ArrayList<Proyecto>();
		resultadoEsperado.add(proyecto1);
		resultadoEsperado.add(proyecto4);
		ArrayList<Proyecto> resultadoBusqueda = buscadorAnd.filtrar(proyectosAFiltrar);
		assertEquals(resultadoEsperado, resultadoBusqueda);
	}
	
	@Test
	void losProyectosCorrespondientesAlCriterioDeBusquedaAndRecursivoSonEl1yEl4() {	//El objetivo es que de tres proyectos, retorne un array list con el proyecto1 y proyecto2.
		ArrayList<Proyecto> resultadoEsperado = new ArrayList<Proyecto>();
		resultadoEsperado.add(proyecto1);
		resultadoEsperado.add(proyecto4);
		ArrayList<Proyecto> resultadoBusqueda = buscadorAnd1.filtrar(proyectosAFiltrar);
		assertEquals(resultadoEsperado, resultadoBusqueda);
	}


}
