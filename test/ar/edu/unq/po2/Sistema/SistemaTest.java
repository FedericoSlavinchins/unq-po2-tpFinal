package ar.edu.unq.po2.Sistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.BuscadorProyecto.BuscadorCategoria;
import ar.edu.unq.po2.BuscadorProyecto.BuscadorTitulo;
import ar.edu.unq.po2.Proyecto.Proyecto;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

import static org.mockito.Mockito.*;

class SistemaTest {
	
	private Sistema sistema;
	private Proyecto proyecto1;
	private BuscadorTitulo buscadorTitulo;
	private BuscadorCategoria buscadorCategoria;
	private Usuario usuario1;
	private Usuario usuario2;
	
	@BeforeEach
	public void setUp() {
		sistema = new Sistema();
		proyecto1 = mock(Proyecto.class);
		buscadorTitulo = mock(BuscadorTitulo.class);
		buscadorCategoria = mock(BuscadorCategoria.class);
		usuario1 = mock(Usuario.class);
		usuario2 = mock(Usuario.class);
	}
	
	
	@Test
	public void cuandoSeAgregaUnProyectoAlSistemaElSistemaContieneAlProyecto() {
		sistema.agregarProyecto(proyecto1);
		assertTrue(sistema.getProyectos().contains(proyecto1));
	}
	
	@Test
	public void testSeAgregaLosUsuarios(){
		this.sistema.agregarUsuario(usuario1);
		this.sistema.agregarUsuario(usuario2);
		
		assertTrue(sistema.getUsuarios().contains(usuario1));
		assertTrue(sistema.getUsuarios().contains(usuario2));
	}
	
	@Test
	public void testNuevoBuscador() {
		this.sistema.setBuscadorDeProyectos(buscadorCategoria);
		
		assertEquals(buscadorCategoria, this.sistema.getBuscadorDeProyectos());
	}
	
	

}
