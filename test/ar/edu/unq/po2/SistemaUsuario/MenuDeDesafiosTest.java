package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

class MenuDeDesafiosTest {
	
	private MenuDeDesafios menuDeDesafios;
	private DesafioDeUsuario desafioDeUsuario1;
	private DesafioDeUsuario desafioDeUsuario2;
	private DesafioDeUsuario desafioDeUsuario3;
	
	@BeforeEach
	public void setUp() {
		menuDeDesafios = new MenuDeDesafios();
		desafioDeUsuario1 = mock(DesafioDeUsuario.class);
		desafioDeUsuario2 = mock(DesafioDeUsuario.class);
		desafioDeUsuario3 = mock(DesafioDeUsuario.class);
	}

	@Test
	void testMoverDesafioAAceptados() {
		menuDeDesafios.agregarDesafioADisponibles(desafioDeUsuario1);
		menuDeDesafios.moverDesafioAAceptados(desafioDeUsuario1);
		
		assertTrue(menuDeDesafios.getDesafiosAceptados().contains(desafioDeUsuario1));
	}
	
	@Test
	void testMoverDesafioACompletados() {
		menuDeDesafios.agregarDesafioADisponibles(desafioDeUsuario1);
		menuDeDesafios.moverDesafioAAceptados(desafioDeUsuario1);
		menuDeDesafios.moverDesafioACompletados(desafioDeUsuario1);
		//
		assertTrue(menuDeDesafios.getDesafiosCompletados().contains(desafioDeUsuario1));
		assertFalse(menuDeDesafios.getDesafiosAceptados().contains(desafioDeUsuario1));
	}

}
