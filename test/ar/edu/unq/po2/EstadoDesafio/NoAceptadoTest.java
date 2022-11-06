package ar.edu.unq.po2.EstadoDesafio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

import ar.edu.unq.po2.SistemaUsuario.Usuario;

class NoAceptadoTest {

	private DesafioDeUsuario desafioUsuario;
	private NoAceptado noAceptado;
	private LocalDate fechaEsperada;
	
	@BeforeEach
	void setUp() throws Exception {
		
		desafioUsuario = mock(DesafioDeUsuario.class);
		noAceptado = new NoAceptado();
		fechaEsperada = LocalDate.now();
		
	}
	
	@Test
	void testComprobarQueElEstadoEsNoAceptado() {
		when(desafioUsuario.getEstado()).thenReturn(noAceptado);
		
		assertEquals(noAceptado,desafioUsuario.getEstado());
		verify(desafioUsuario, times(1)).getEstado();
	}
	
	@Test
	void testSeAceptaDesafio() {
		this.noAceptado.aceptar(desafioUsuario);
		
		verify(desafioUsuario).setFechaAceptado();
	}

	//Este test no hace nada ya que el metodo tambien no hace nada.
	@Test
	void testCompletar() {
		this.noAceptado.completar(desafioUsuario);
	}
}
