package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
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
		when(usuario.getMenuDeDesafios()).thenReturn(menuDeDesafios);
		menuDeDesafios.agregarADisponible(desafio);
		desafio.aceptarDesafio(usuario);
		
		assertEquals(1, menuDeDesafios.getDesafiosAceptados().size());
		assertEquals(0, menuDeDesafios.getDesafiosDisponibles().size());
	}
	
	@Test
	void testMoverDesafioAAceptados2() throws Exception {
		
		menuDeDesafios.agregarADisponible(desafioDeUsuario1.getDesafio());
		menuDeDesafios.moverDesafioAAceptados(desafioDeUsuario1);
		
		assertEquals(1, menuDeDesafios.getDesafiosAceptados().size());

	}
	
	
	
	@Test
	void testMoverDesafioACompletados() throws Exception {
	
		
		menuDeDesafios.agregarAAceptados(desafioDeUsuario1);
		
		menuDeDesafios.moverDesafioACompletados(desafioDeUsuario1);
		//
		assertTrue(menuDeDesafios.getDesafiosCompletados().contains(desafioDeUsuario1));
		assertFalse(menuDeDesafios.getDesafiosAceptados().contains(desafioDeUsuario1));
	}
	
	@Test
	void testAgregarCompletados() {
		ArrayList<DesafioDeUsuario> desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		desafiosDeUsuario.add(desafioDeUsuario1);
		
		menuDeDesafios.agregarACompletados(desafiosDeUsuario);
		//
		assertTrue(menuDeDesafios.getDesafiosCompletados().contains(desafioDeUsuario1));
	}
	
	
	@Test
	void testSetDesafiosDisponibles() {
		List<Desafio> desafiosDisponibles = new ArrayList<Desafio>();
		desafiosDisponibles.add(desafio);
		
		menuDeDesafios.setDesafiosDisponibles(desafiosDisponibles);
		//
		assertEquals(desafiosDisponibles, menuDeDesafios.getDesafiosDisponibles());
	}
	
	

}
