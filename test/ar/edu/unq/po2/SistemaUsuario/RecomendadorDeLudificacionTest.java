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
	private DesafioDeUsuario desafioDeUsuario2;
	private List<Desafio> desafios;
	private PreferenciaUsuario preferencias;
	private MenuDeDesafios menuDeDesafios;
	private Voto voto;
	private Usuario usuario;
	private Desafio desafio;
	private Desafio desafio2;
	private Desafio desafio3;
	private Desafio desafio4;
	private List<Desafio> desafiosARecomendar;
	
	
	
	@BeforeEach
	public void setUp() throws Exception {
		
		desafioDeUsuario = mock(DesafioDeUsuario.class);
		desafioDeUsuario2 = mock(DesafioDeUsuario.class);
		
		desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		desafiosDeUsuario.add(desafioDeUsuario);
		desafiosDeUsuario.add(desafioDeUsuario2);
		
		recomendadorPreferencias = mock(RecomendacionPorPreferencias.class);
		preferencias = mock(PreferenciaUsuario.class);
		menuDeDesafios = mock(MenuDeDesafios.class);
		desafio = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		usuario = mock(Usuario.class);
		desafios = new ArrayList<Desafio>();
		desafios.add(desafio2);
		desafios.add(desafio3);
		desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		voto = mock(Voto.class);
		recomendador = new RecomendadorDeLudificacion(desafiosDeUsuario, preferencias, menuDeDesafios);
	}
	
	@Test
	void testDesafiosRecomendados() {
		recomendador.recomendarDesafios(desafios);
		
		
		verify(menuDeDesafios).setDesafiosDisponibles(desafios);
	}
	
	
	@Test
	void testDesafioFavorito() {
		desafioDeUsuario.setVoto(voto);
		
		ArrayList<DesafioDeUsuario> desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		desafiosDeUsuario.add(desafioDeUsuario);
		desafiosDeUsuario.add(desafioDeUsuario2);
		
		menuDeDesafios.agregarACompletados(desafiosDeUsuario);
		
		assertEquals(desafioDeUsuario, recomendador.filtroDesafioQueMasLeGusto());
	}
}
