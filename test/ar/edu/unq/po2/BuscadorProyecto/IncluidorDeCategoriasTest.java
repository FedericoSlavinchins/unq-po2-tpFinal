package ar.edu.unq.po2.BuscadorProyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Proyecto;

class IncluidorDeCategoriasTest {

	private IncluidorDeCategorias buscadorIncluidorCategorias;
	private List<String> nombresDeCategoriasABuscar;
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private ArrayList<Proyecto> proyectosAFiltrar;
	private ArrayList<Categoria> listaCategoriasProyecto1;
	private ArrayList<Categoria> listaCategoriasProyecto2;
	private Categoria categoria1;
	private Categoria categoria2;
	private Categoria categoria3;
	private Categoria categoria4;
	
	
	@BeforeEach
	public void setUp() {
		nombresDeCategoriasABuscar = new ArrayList<String>();
		nombresDeCategoriasABuscar.add("Astronomía");
		nombresDeCategoriasABuscar.add("Física");
		
		buscadorIncluidorCategorias = new IncluidorDeCategorias(nombresDeCategoriasABuscar);
		listaCategoriasProyecto1 = new ArrayList<Categoria>();
		listaCategoriasProyecto2 = new ArrayList<Categoria>();
		
		proyectosAFiltrar = new ArrayList<Proyecto>();
		
		listaCategoriasProyecto1 = new ArrayList<Categoria>();
		listaCategoriasProyecto2 = new ArrayList<Categoria>();
		
		categoria1 = new Categoria("Astronomía");
		categoria2 = new Categoria("Física");
		categoria3 = new Categoria("Biología");
		categoria4 = new Categoria("Química");
		
		listaCategoriasProyecto1.add(categoria1);
		listaCategoriasProyecto1.add(categoria2);
		listaCategoriasProyecto2.add(categoria3);
		listaCategoriasProyecto2.add(categoria4);
		
		
		proyecto1 = new Proyecto("Las Estrellas", "blabla1", listaCategoriasProyecto1);
		proyecto2 = new Proyecto("Biología y Química", "blabla2", listaCategoriasProyecto2);
		
		proyectosAFiltrar.add(proyecto1);
		proyectosAFiltrar.add(proyecto2);
		
	}

	@Test
	void elProyectoCorrespondienteAlCriterioDeBusquedaIncluidorDeCategoriasEsElProyecto1() {
		List<Proyecto> resultadoEsperado = new ArrayList<Proyecto>();
		resultadoEsperado.add(proyecto1);
		List<Proyecto> resultadoBusqueda = buscadorIncluidorCategorias.filtrar(proyectosAFiltrar);
		assertEquals(resultadoEsperado, resultadoBusqueda);
	}
}
