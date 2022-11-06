package ar.edu.unq.po2.EstadoDesafio;

import static org.junit.jupiter.api.Assertions.*;

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
	
	@BeforeEach
	void setUp() throws Exception {
		
		desafio = new Desafio();
		desafioUsuario = new DesafioDeUsuario(desafio);
		noAceptado = new NoAceptado();
		desafioUsuario.setEstado(noAceptado);
		usuario = new Usuario("nombre");
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
}
