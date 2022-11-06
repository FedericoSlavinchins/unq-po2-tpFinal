package ar.edu.unq.po2.Sistema;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.BuscadorProyecto.BuscadorTitulo;
import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Proyecto;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

class SistemaTest {
	
	private Sistema sistema;
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private BuscadorTitulo buscadorTitulo;
	private Usuario usuario1;
	private Usuario usuario2;
	private ArrayList<Categoria> listaDeCategorias;
	private Categoria categoria;
	
	@BeforeEach
	public void setUp() {
		sistema = new Sistema();
		categoria = new Categoria("Matemática");
		listaDeCategorias = new ArrayList<Categoria>();
		listaDeCategorias.add(categoria);
		proyecto1 = new Proyecto("proyecto", "descripcion", listaDeCategorias);
		buscadorTitulo = new BuscadorTitulo("Ecuaciones");
	}
	
	
	@Test
	void cuandoSeAgregaUnProyectoAlSistemaElSistemaContieneAlProyecto() {
		sistema.agregarProyecto(proyecto1);
		assertTrue(sistema.getProyectos().contains(proyecto1));
	}

}
