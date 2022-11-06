package ar.edu.unq.po2.Sistema;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.BuscadorProyecto.BuscadorCategoria;
import ar.edu.unq.po2.BuscadorProyecto.BuscadorTitulo;
import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Proyecto;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

import static org.mockito.Mockito.*;

class SistemaTest {
	
	private Sistema sistema;
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private BuscadorTitulo buscadorTitulo;
	private BuscadorCategoria buscadorCategoria;
	private Usuario usuario1;
	private Usuario usuario2;
	
	@BeforeEach
	public void setUp() {
		sistema = new Sistema(buscadorTitulo);
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		buscadorTitulo = mock(BuscadorTitulo.class);
		buscadorCategoria = mock(BuscadorCategoria.class);
		usuario1 = mock(Usuario.class);
		usuario2 = mock(Usuario.class);
	}
	
	
	@Test
	void cuandoSeAgregaUnProyectoAlSistemaElSistemaContieneAlProyecto() {
		sistema.agregarProyecto(proyecto1);
		assertTrue(sistema.getProyectos().contains(proyecto1));
	}
	
	

}
