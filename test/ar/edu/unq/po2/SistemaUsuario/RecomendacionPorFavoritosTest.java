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

class RecomendacionPorFavoritosTest {
	
	private RecomendacionPorFavoritos estrategiaFavoritos;
	private PreferenciaUsuario preferenciasDelUsuario;
	private List<DesafioDeUsuario> listaDeDesafiosDeUsuario;
	private List<Desafio> listaDeDesafios;
	private Desafio desafio;
	private Desafio desafio2;
	private DesafioDeUsuario desafioDeUsuario2;
	private Desafio desafio3;
	private Desafio desafio4;
	private Desafio desafioFavorito;
	private PreferenciaUsuario preferencias;
	
	
	@BeforeEach
	public void setUp() {
		estrategiaFavoritos = new RecomendacionPorFavoritos();
		preferenciasDelUsuario = mock(PreferenciaUsuario.class);
		listaDeDesafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		desafio = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		desafioFavorito = mock(Desafio.class);
		desafioDeUsuario2 = mock(DesafioDeUsuario.class);
		estrategiaFavoritos.setDesafioFavorito(desafioFavorito);
	}
	
	@Test
	void testRecomendarDesafios() {
		
		List<Desafio> desafiosDelProyecto = Arrays.asList(desafio, desafio2, desafio3, desafio4);
		List<DesafioDeUsuario> desafiosQueYaAcepto = Arrays.asList(desafioDeUsuario2);
		when(desafioDeUsuario2.getDesafio()).thenReturn(desafio2);
		
		when(desafio.getCantidadObjetivoDeMuestras()).thenReturn(5);
		when(desafio.getDificultad()).thenReturn(2);
		when(desafio.getRecompensa()).thenReturn(6.5);	//3.3
		
		when(desafio2.getCantidadObjetivoDeMuestras()).thenReturn(1);
		when(desafio2.getDificultad()).thenReturn(1);
		when(desafio2.getRecompensa()).thenReturn(2.5);
		
		when(desafio3.getCantidadObjetivoDeMuestras()).thenReturn(3);
		when(desafio3.getDificultad()).thenReturn(4);
		when(desafio3.getRecompensa()).thenReturn(12.5); //0
		
		when(desafio4.getCantidadObjetivoDeMuestras()).thenReturn(1);
		when(desafio4.getDificultad()).thenReturn(1);
		when(desafio4.getRecompensa()).thenReturn(1.0);	//5.5
		
		when(desafioFavorito.getCantidadObjetivoDeMuestras()).thenReturn(3);
		when(desafioFavorito.getDificultad()).thenReturn(4);
		when(desafioFavorito.getRecompensa()).thenReturn(12.5);
		
		when(preferenciasDelUsuario.getCantidadDeMuestrasARecolectar()).thenReturn(3);
		when(preferenciasDelUsuario.getDificultadPreferida()).thenReturn(4);
		when(preferenciasDelUsuario.getRecompensaPreferida()).thenReturn(12.6);
		
		List<Desafio> resultadoActual = estrategiaFavoritos.recomendar(desafiosQueYaAcepto, preferenciasDelUsuario, desafiosDelProyecto);
		List<Desafio> resultadoEsperado = Arrays.asList(desafio3, desafio, desafio4);
		
		assertEquals(resultadoEsperado, resultadoActual);
	}
	

}
