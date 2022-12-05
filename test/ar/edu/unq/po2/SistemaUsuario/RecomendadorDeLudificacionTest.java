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
	private Usuario usuario;
	private Desafio desafio;
	
	
	
	@BeforeEach
	public void setUp() {
		recomendadorPreferencias = mock(RecomendacionPorPreferencias.class);
		preferencias = mock(PreferenciaUsuario.class);
		menuDeDesafios = new MenuDeDesafios();
		desafio = mock(Desafio.class);
		usuario = mock(Usuario.class);
		desafioDeUsuario = new DesafioDeUsuario(desafio, usuario);
		voto = mock(Voto.class);
		recomendador = new RecomendadorDeLudificacion(desafiosDeUsuario, preferencias, menuDeDesafios);
		recomendador.cambiarEstrategiaDeRecomendacion(recomendadorPreferencias);
	}
	
	@Test
	void testDesafiosRecomendados() {
		recomendador.recomendarDesafios(desafios);
		
		verify(recomendador.getEstrategia()).recomendar(desafiosDeUsuario, preferencias, desafios);
	}
	
	@Test
	void testDesafioFavorito() {
		when(desafioDeUsuario.getVoto()).thenReturn(voto);
		when(voto.getValorVoto()).thenReturn(5);
		ArrayList<DesafioDeUsuario> desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		desafiosDeUsuario.add(desafioDeUsuario);
		menuDeDesafios.agregarACompletados(desafiosDeUsuario);
		
		assertEquals(desafioDeUsuario, recomendador.filtroDesafioQueMasLeGusto());
	}
}
