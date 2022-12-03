package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.SistemaUsuario.Usuario;

class OtorgadorDeRecompensaTest {
	
	private OtorgadorDeRecompensa otorgadorDeRecompensa;
	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		usuario = mock(Usuario.class);
		otorgadorDeRecompensa = new OtorgadorDeRecompensa(500.2);
		otorgadorDeRecompensa.setUsuarioARecompensar(usuario);
	}
	
	@Test
	void testOtorgarRecompensaAUsuario() {
		double recompensa = 500.2;
		when(usuario.getRecompensasAcumuladas()).thenReturn(0.0);
		otorgadorDeRecompensa.otorgarRecompensa();
		
		verify(usuario).setRecompensasAcumuladas(0.0 + recompensa);
		when(usuario.getRecompensasAcumuladas()).thenReturn(recompensa);
		assertEquals(500.2, usuario.getRecompensasAcumuladas());
	}

}
