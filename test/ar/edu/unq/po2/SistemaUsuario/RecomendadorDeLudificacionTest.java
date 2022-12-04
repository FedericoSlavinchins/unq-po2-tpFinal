package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.Desafios.Voto;

class RecomendadorDeLudificacionTest {
	
	private RecomendadorDeLudificacion recomendador;
	private RecomendacionPorPreferencias recomendadorPreferencias;
	private ArrayList<DesafioDeUsuario> desafiosDeUsuario;
	private DesafioDeUsuario desafioDeUsuario;
	private List<Desafio> desafios;
	private PreferenciaUsuario preferencias;
	private MenuDeDesafios menuDeDesafios;
	private Voto voto;
	
	
	
	@BeforeEach
	public void setUp() {
		recomendadorPreferencias = mock(RecomendacionPorPreferencias.class);
		preferencias = mock(PreferenciaUsuario.class);
		menuDeDesafios = mock(MenuDeDesafios.class);
		recomendador = new RecomendadorDeLudificacion(desafiosDeUsuario, preferencias, menuDeDesafios);
		recomendador.cambiarEstrategiaDeRecomendacion(recomendadorPreferencias);
		desafioDeUsuario = mock(DesafioDeUsuario.class);
		voto = mock(Voto.class);
	}
	
	@Test
	void testDesafiosRecomendados() {
		recomendador.recomendarDesafios(desafios);
		
		verify(recomendador.getEstrategia()).recomendar(desafiosDeUsuario, preferencias, desafios);
	}
	
	@Test
	void testDesafioFavorito() {
		desafiosDeUsuario.add(desafioDeUsuario);
		when(menuDeDesafios.getDesafiosCompletados()).thenReturn(desafiosDeUsuario);
		when(desafioDeUsuario.getVoto()).thenReturn(voto);
		when(voto.getValorVoto()).thenReturn(5);
		
		
		
		assertEquals(desafioDeUsuario, recomendador.filtroDesafioQueMasLeGusto());
	}
	
/*
	@Test
	void testConstructorDelRecomendador() {
		assertEquals(recomendadorPreferencias.getClass(), recomendador.getEstrategia().getClass());
	}
	
	@Test
	void testGetterDesafiosDeUsuario() {
		assertEquals(desafiosDeUsuario, recomendador.getDesafiosDelUsuario());
	}
	
	@Test
	void testGetterPreferenciasDeUsuario() {
		assertEquals(preferencias, recomendador.getPreferencias());
	}
*/
}
