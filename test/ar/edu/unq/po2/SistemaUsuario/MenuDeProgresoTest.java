package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

class MenuDeProgresoTest {
	
	private MenuDeProgreso menuDeProgreso;
	private DesafioDeUsuario desafioDeUsuario1;
	private Usuario usuario;
	private MenuDeDesafios menuDeDesafios;
	
	@BeforeEach
	public void setUp() {
		usuario = mock(Usuario.class);
		menuDeDesafios = mock(MenuDeDesafios.class);
		desafioDeUsuario1 = mock(DesafioDeUsuario.class);
		menuDeProgreso = new MenuDeProgreso(usuario);
	}

	@Test
	void testPorcentajeDeCompletitudGeneral() {
		ArrayList<DesafioDeUsuario> listaDesafiosDisponibles = new ArrayList<DesafioDeUsuario>();
		ArrayList<DesafioDeUsuario> listaDesafiosCompletados = new ArrayList<DesafioDeUsuario>();
		listaDesafiosDisponibles.add(desafioDeUsuario1);
	
		when(usuario.getMenuDeDesafios()).thenReturn(menuDeDesafios);
		when(menuDeDesafios.getDesafiosAceptados()).thenReturn(listaDesafiosDisponibles);
		when(menuDeDesafios.getDesafiosCompletados()).thenReturn(listaDesafiosCompletados);
		
		assertTrue(menuDeProgreso.porcentajeDeCompletitudGeneral() == 0);
		verify(desafioDeUsuario1).porcentajeDeCompletitud();
	}
	
	@Test
	void testCompletoDesafio() {
		ArrayList<DesafioDeUsuario> listaDesafiosCompletados = new ArrayList<DesafioDeUsuario>();
		listaDesafiosCompletados.add(desafioDeUsuario1);
		
		when(usuario.getMenuDeDesafios()).thenReturn(menuDeDesafios);
		when(usuario.getMenuDeDesafios().getDesafiosCompletados()).thenReturn(listaDesafiosCompletados);
		
		assertTrue(menuDeProgreso.completoDesafio(desafioDeUsuario1));
	}
	
	
	@Test
	void testUsuarioEstaRealizandoElDesafio() {
		ArrayList<DesafioDeUsuario> listaDesafiosAceptados = new ArrayList<DesafioDeUsuario>();
		listaDesafiosAceptados.add(desafioDeUsuario1);
		
		when(usuario.getMenuDeDesafios()).thenReturn(menuDeDesafios);
		when(usuario.getMenuDeDesafios().getDesafiosAceptados()).thenReturn(listaDesafiosAceptados);
		
		assertTrue(menuDeProgreso.usuarioEstaRealizandoElDesafio(desafioDeUsuario1));
	}

}
