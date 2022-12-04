package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.Desafios.RestriccionTemporal;
import ar.edu.unq.po2.Proyecto.AreaGeografica;

class MenuDeDesafiosTest {
	
	private MenuDeDesafios menuDeDesafios;
	private DesafioDeUsuario desafioDeUsuario1;
	private DesafioDeUsuario desafioDeUsuario2;
	private DesafioDeUsuario desafioDeUsuario3;
	private Desafio desafio;
	private Usuario usuario;
	private AreaGeografica area;
	private RestriccionTemporal restriccion;
	
	@BeforeEach
	public void setUp() {
		menuDeDesafios = new MenuDeDesafios();
		desafioDeUsuario1 = mock(DesafioDeUsuario.class);
		desafioDeUsuario2 = mock(DesafioDeUsuario.class);
		desafioDeUsuario3 = mock(DesafioDeUsuario.class);
		desafio = new Desafio(area, 2, 2, restriccion, 2);
		usuario = mock(Usuario.class);
		area = mock(AreaGeografica.class);
		restriccion = mock(RestriccionTemporal.class);
	}

	@Test
	void testMoverDesafioAAceptados() throws Exception {
		/*
		
		
		List<Desafio> desafios = Arrays.asList(desafio);
		menuDeDesafios.setDesafiosDisponibles(desafios);
		
		desafio.aceptarDesafio(usuario);
		//menuDeDesafios.moverDesafioAAceptados(desafioDeUsuario1);*/
		
		
		when(usuario.getMenuDeDesafios()).thenReturn(menuDeDesafios);
		menuDeDesafios.agregarADisponible(desafio);
		desafio.aceptarDesafio(usuario);
		
		assertEquals(1, menuDeDesafios.getDesafiosAceptados().size());
		assertEquals(0, menuDeDesafios.getDesafiosDisponibles().size());
	}
	
	@Test
	void testMoverDesafioACompletados() throws Exception {
	
		
		menuDeDesafios.agregarAAceptados(desafioDeUsuario1);
		
		menuDeDesafios.moverDesafioACompletados(desafioDeUsuario1);
		//
		assertTrue(menuDeDesafios.getDesafiosCompletados().contains(desafioDeUsuario1));
		assertFalse(menuDeDesafios.getDesafiosAceptados().contains(desafioDeUsuario1));
	}

}
