package ar.edu.unq.po2.Sistema;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.BuscadorProyecto.BuscadorDeProyectos;
import ar.edu.unq.po2.BuscadorProyecto.BuscadorTitulo;
import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Proyecto;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

class SistemaTest {
	
	private Sistema 				sistema;
	private Proyecto 				proyecto1;
	private Usuario 				usuario1;
	private BuscadorTitulo 			buscadorTitulo;
	private ArrayList<Categoria>	listaCategorias;
	
	@BeforeEach
	public void setUp() {
		buscadorTitulo 	= new BuscadorTitulo("Estrellas");
		listaCategorias = new ArrayList<Categoria>();
		proyecto1	 	= new Proyecto("Posición de las Estrellas", "bla1", listaCategorias);
		sistema 		= new Sistema();
		usuario1 		= new Usuario();
	}

	@Test
	void cuandoSeAgregaUnProyectoAlSistemaElProyectoEstaContenidoEnElMismo() {
		sistema.agregarProyecto(proyecto1);
		boolean resultado = sistema.getProyectos().contains(proyecto1);
		assertTrue(resultado);
	}
	
	@Test
	void cuandoSeAgregaUnUsuarioAlSistemaElUsuarioEsParteDelMismo() {
		sistema.agregarUsuario(usuario1);
		boolean resultado = sistema.getUsuarios().contains(usuario1);
		assertTrue(resultado);
	}
	
	@Test
	void cuandoSeSeteaUnBuscadorDeProyectosEnElSistemaElBuscadorFormaParteDelMismo() {
		sistema.setBuscadorDeProyectos(buscadorTitulo);
		BuscadorDeProyectos resultado = sistema.getBuscadorDeProyectos();
		assertEquals(buscadorTitulo, resultado);
	}

}
