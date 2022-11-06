package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

import static org.mockito.Mockito.*;

public class RecomendacionPreferenciasTest {

	private RecomendacionPorPreferencias estrategiaPreferencias;
	private PreferenciaUsuario preferenciasDelUsuario;
	private List<DesafioDeUsuario> desafiosCompletados;
	private Desafio desafio;
	
	@BeforeEach
	public void setUp() {
		estrategiaPreferencias = new RecomendacionPorPreferencias();
		preferenciasDelUsuario = mock(PreferenciaUsuario.class);
		desafiosCompletados = new ArrayList<DesafioDeUsuario>();
		desafio = mock(Desafio.class);
		
	}
	
	@Test
	public void testCalcularCoincidencia() {
		when(preferenciasDelUsuario.getCantidadDeMuestrasARecolectar()).thenReturn(5);
		when(preferenciasDelUsuario.getDificultadPreferida()).thenReturn(2);
		when(preferenciasDelUsuario.getRecompensaPreferida()).thenReturn(6.5);
		
		estrategiaPreferencias.setPreferencias(preferenciasDelUsuario);
		estrategiaPreferencias.setDesafiosCompletados(desafiosCompletados);
		estrategiaPreferencias.calcularCoincidencia(desafio);

		
		verify(desafio).getCantidadObjetivoDeMuestras();
		verify(desafio).getDificultad();
		verify(desafio).getRecompensa();
	}
}
