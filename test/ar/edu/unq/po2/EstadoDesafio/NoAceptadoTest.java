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
	private Desafio desafio;
	private NoAceptado noAceptado;
	private Usuario usuario;
	private LocalDate fechaEsperada;
	private Aceptado aceptado;
	
	@BeforeEach
	void setUp() throws Exception {
		
		desafio = new Desafio();
		desafioUsuario = new DesafioDeUsuario(desafio);
		noAceptado = new NoAceptado();
		desafioUsuario.setEstado(noAceptado);
		usuario = new Usuario("pepe");
		//usuario = mock(Usuario.class);
		usuario.agregarDesafiosDisponibles(desafioUsuario);
		fechaEsperada = LocalDate.now();
		
	}

	@Test
	void testComprobarQueElEstadoEsNoAceptado() {
		assertEquals(noAceptado,desafioUsuario.getEstado());
	}

	@Test
	void testFechaDeAceptadoEsLaCorrecta() {
		usuario.aceptarDesafioDeUsuario(desafioUsuario);
		assertEquals(fechaEsperada,desafioUsuario.getFechaAceptado());
	}
	@Test
	void testCambiaDeEstadoAceptado() {
		usuario.aceptarDesafioDeUsuario(desafioUsuario);
		//verify(usuario).aceptarDesafioDeUsuario(desafioUsuario);
		
	}
}
