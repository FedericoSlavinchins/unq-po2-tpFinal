package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

class RecomendadorDeLudificacionTest {
	
	private RecomendadorDeLudificacion recomendador;
	private RecomendacionPorPreferencias recomendadorPreferencias;
	private List<DesafioDeUsuario> desafiosDeUsuario;
	private List<Desafio> desafios;
	private PreferenciaUsuario preferencias;
	
	
	@BeforeEach
	public void setUp() {
		recomendadorPreferencias = mock(RecomendacionPorPreferencias.class);
		preferencias = mock(PreferenciaUsuario.class);
		recomendador = new RecomendadorDeLudificacion(desafiosDeUsuario, preferencias);
		recomendador.cambiarEstrategiaDeRecomendacion(recomendadorPreferencias);
	}
	
	@Test
	void testDesafiosRecomendados() {
		recomendador.recomendarDesafios(desafios);
		
		verify(recomendador.getEstrategia()).recomendar(desafiosDeUsuario, preferencias, desafios);
	}

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

}
