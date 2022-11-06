package ar.edu.unq.po2.SistemaUsuario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RecomendadorTest {

	RecomendadorDeLudificacion recomendador;
	EstrategiaDeRecomendacion estrategia;
	Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		usuario = mock(Usuario.class);
		estrategia = mock(EstrategiaDeRecomendacion.class);
		recomendador = new RecomendadorDeLudificacion(usuario.getDesafiosCompletados(), usuario.getPreferenciaUsuario());
	}
	
	@Test
	
	
}
