package ar.edu.unq.po2.SistemaUsuario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RecomendadorTest {

	RecomendadorDeLudificacion recomendador;
	EstrategiaDeRecomendacion estrategia1;
	EstrategiaDeRecomendacion estrategia2;
	Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		usuario = mock(Usuario.class);
		estrategia1 = mock(EstrategiaDeRecomendacion.class);
		estrategia2 = mock(EstrategiaDeRecomendacion.class);
		recomendador = new RecomendadorDeLudificacion(usuario.getDesafiosCompletados(), usuario.getPreferenciaUsuario());
		listaDeDesafios = new 
	}
	
	@Test
	public void testCambiaLaEstrategia() {
		recomendador.cambiarEstrategiaDeRecomendacion(estrategia1);
		
		assertEquals(estrategia1, recomendador.getEstrategia());
	}
	
	@Test
	public void testRecomendar() {
		when(estrategia1.recomendar(recomendador.getDesafiosCompletados(), recomendador.getPreferencias())).thenReturn(listaDeDesafios);
		this.recomendador.recomendarDesafios();
		
		
	}
	
}
