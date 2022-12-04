package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

class RecomendacionPorPreferenciasTest {

	private RecomendacionPorPreferencias estrategiaPreferencias;
	private PreferenciaUsuario preferenciasDelUsuario;
	private List<DesafioDeUsuario> listaDeDesafiosDeUsuario;
	private List<Desafio> listaDeDesafios;
	private Desafio desafio;
	private Desafio desafio2;
	
	@BeforeEach
	public void setUp() {
		estrategiaPreferencias = new RecomendacionPorPreferencias();
		preferenciasDelUsuario = mock(PreferenciaUsuario.class);
		listaDeDesafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
		desafio = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		
	}
	
	
	@Test
	public void testDesafiosOrdenadosPorCoincidencia() {
		ArrayList<Desafio> listaDeDesafiosPosibles = new ArrayList<Desafio>();
		listaDeDesafiosPosibles.add(desafio2);
		listaDeDesafiosPosibles.add(desafio);
		
		estrategiaPreferencias.setDesafiosPosibles(listaDeDesafiosPosibles);
		estrategiaPreferencias.setPreferencias(preferenciasDelUsuario);
		
		when(preferenciasDelUsuario.getCantidadDeMuestrasARecolectar()).thenReturn(5);
		when(preferenciasDelUsuario.getDificultadPreferida()).thenReturn(2);
		when(preferenciasDelUsuario.getRecompensaPreferida()).thenReturn(6.5);
		
		when(desafio.getCantidadObjetivoDeMuestras()).thenReturn(1);
		when(desafio.getDificultad()).thenReturn(1);
		when(desafio.getRecompensa()).thenReturn(2.5);
		
		when(desafio2.getCantidadObjetivoDeMuestras()).thenReturn(5);
		when(desafio2.getDificultad()).thenReturn(2);
		when(desafio2.getRecompensa()).thenReturn(6.5);
		
		
		List<Desafio> resultadoEsperado  = Arrays.asList(desafio2, desafio);
		List<Desafio> resultadoActual	 = estrategiaPreferencias.desafiosOrdenadosPorCoincidencia();
		
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
	
	@Test
	public void testRecomendarPorPreferencias() {
		estrategiaPreferencias.recomendar(listaDeDesafiosDeUsuario, preferenciasDelUsuario, listaDeDesafios);
		
		assertEquals(listaDeDesafios, estrategiaPreferencias.getDesafiosPosibles());
	}
	
	
	@Test
	public void testCalcularCoincidencia() {
		when(preferenciasDelUsuario.getCantidadDeMuestrasARecolectar()).thenReturn(5);
		when(preferenciasDelUsuario.getDificultadPreferida()).thenReturn(2);
		when(preferenciasDelUsuario.getRecompensaPreferida()).thenReturn(6.5);
		
		estrategiaPreferencias.setPreferencias(preferenciasDelUsuario);
		estrategiaPreferencias.calcularCoincidencia(desafio);
		
		
		verify(desafio).getCantidadObjetivoDeMuestras();
		verify(desafio).getDificultad();
		verify(desafio).getRecompensa();
	}
	
	@Test
	public void testSetterDesafiosPosibles() {
		estrategiaPreferencias.setDesafiosPosibles(listaDeDesafios);
		
		assertEquals(listaDeDesafios, estrategiaPreferencias.getDesafiosPosibles());
	}
	
	

}
