package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.EstadoDesafio.Aceptado;
import ar.edu.unq.po2.EstadoDesafio.Completado;
import ar.edu.unq.po2.EstadoDesafio.EstadoDesafio;
import ar.edu.unq.po2.EstadoDesafio.NoAceptado;
import ar.edu.unq.po2.Proyecto.AreaGeografica;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.Proyecto.Ubicacion;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

class DesafioDeUsuarioTest {

	private DesafioDeUsuario desafioUsuario;
	private Usuario usuario;
	private Desafio desafio;
	private EstadoDesafio noAceptado;
	private Aceptado estadoAceptado;
	private Completado estadoCompletado;
	private LocalDate fechaAceptado;
	private LocalDate fechaEnQueSeCompletoDesafioTest1;
	private EstadoDesafio estadoObtenido;
	private LocalDate fechaObtenida;
	
	@BeforeEach
	void setUp() throws Exception {
		
		usuario = new Usuario("nombreUsuario");
		desafio = new Desafio();
		estadoAceptado = new Aceptado();
		estadoCompletado = new Completado();
		desafioUsuario = new DesafioDeUsuario(desafio);
		
		fechaEnQueSeCompletoDesafioTest1 = LocalDate.of(2022, 6, 11);	
		estadoObtenido = desafioUsuario.getEstado();
		
		usuario.agregarDesafiosDisponibles(desafioUsuario);
		 
		noAceptado = desafioUsuario.getEstado();
		
	}
	
	@Test
	void testgetDesafio() {
		assertEquals(desafioUsuario.getDesafio(), desafio);
		assertEquals(desafioUsuario.getEstado(), noAceptado );
	}
	
	@Test
	void testGetFechaAceptado() {	
		usuario.aceptarDesafioDeUsuario(desafioUsuario);
		assertEquals(fechaEnQueSeCompletoDesafioTest1, desafioUsuario.getFechaAceptado()) ;
	}
	@Test
	void testDeEstadoDesafioActualCorrecto() {	
		usuario.aceptarDesafioDeUsuario(desafioUsuario);
		usuario.completarDesafioDeUsuario(desafioUsuario, 0);
		assertEquals(estadoCompletado,estadoObtenido) ;
		
	}
	
}
