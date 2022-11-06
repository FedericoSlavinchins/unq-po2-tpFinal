package ar.edu.unq.po2.EstadoDesafio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.BloqueSemanal;
import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

class AceptadoTest {


	private DesafioDeUsuario desafioUsuario;
	private Desafio desafio;
	private NoAceptado noAceptado;
	private Usuario usuario;
	private LocalDate fechaEsperada;
	private Aceptado aceptado;
	private BloqueSemanal restriccionBloqueSemanal;
	private Muestra	muestra;
	
	@BeforeEach
	void setUp() throws Exception {
		restriccionBloqueSemanal = new BloqueSemanal(true);
		desafio = new Desafio(2, 3, restriccionBloqueSemanal, 1000);
		desafioUsuario = new DesafioDeUsuario(desafio);
		aceptado = new Aceptado();
		desafioUsuario.setEstado(aceptado);
		usuario = new Usuario("pepe");
		//usuario = mock(Usuario.class);
		usuario.agregarDesafiosDisponibles(desafioUsuario);
		fechaEsperada = LocalDate.now();
		
	}

	@Test
	void testComprobarQueElEstadoEsAceptado() {
		assertEquals(aceptado,desafioUsuario.getEstado());
	}

	@Test
	void testFechaDeCompletadoEsLaCorrecta() {
		usuario.aceptarDesafioDeUsuario(desafioUsuario);
		usuario.completarDesafioDeUsuario(desafioUsuario, 1);
		assertEquals(fechaEsperada,desafioUsuario.getFechaCompletado());
	}
	@Test
	void testEmiteVoto() {
		desafio.setCantidadObjetivoDeMuestras(1);
		usuario.aceptarDesafioDeUsuario(desafioUsuario);
		//usuario.recolectarMuestra(mues, null);
		usuario.completarDesafioDeUsuario(desafioUsuario, 1);
		assertEquals(1,desafioUsuario.getVoto());
	
	}
	
	@Test
	void testCambiaDeEstadoAceptado() {
		usuario.aceptarDesafioDeUsuario(desafioUsuario);
		//verify(usuario).aceptarDesafioDeUsuario(desafioUsuario);
		
	}
}