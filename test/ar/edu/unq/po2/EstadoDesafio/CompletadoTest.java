package ar.edu.unq.po2.EstadoDesafio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompletadoTest {
	Completado completado;
	
	@BeforeEach
	public void setUp() {
		completado = new Completado();
	}

	//Este test no hace nada ya que el metodo tambien no hace nada.
	@Test
	public void completarTest() {
		this.completado.actualizarEstado(null);
	}
}
