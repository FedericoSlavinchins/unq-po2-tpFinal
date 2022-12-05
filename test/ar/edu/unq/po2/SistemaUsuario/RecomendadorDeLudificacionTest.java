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
		desafio = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		
		desafiosARecomendar = new ArrayList<Desafio>();
		desafiosARecomendar.add(desafio3);
		desafiosARecomendar.add(desafio4);
		
		desafioDeUsuario = new DesafioDeUsuario(desafio, usuario);
		desafioDeUsuario2 = new DesafioDeUsuario(desafio, usuario);
		
		desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		desafiosDeUsuario.add(desafioDeUsuario);
		desafiosDeUsuario.add(desafioDeUsuario2);
		
		recomendadorPreferencias = mock(RecomendacionPorPreferencias.class);
		preferencias = mock(PreferenciaUsuario.class);
		menuDeDesafios = new MenuDeDesafios();
		usuario = mock(Usuario.class);
		voto = new Voto(5);
		recomendador = new RecomendadorDeLudificacion(desafiosDeUsuario, preferencias, menuDeDesafios);
		recomendador.cambiarEstrategiaDeRecomendacion(recomendadorPreferencias);

	}
	
	@Test
	void testDesafiosRecomendados() {
		recomendador.recomendarDesafios(desafios);
		
		verify(recomendadorPreferencias).recomendar(desafiosDeUsuario, preferencias, desafiosARecomendar);
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
