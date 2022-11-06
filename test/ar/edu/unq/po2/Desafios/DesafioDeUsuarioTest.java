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
import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.Proyecto.Proyecto;
import ar.edu.unq.po2.Proyecto.Ubicacion;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

class DesafioDeUsuarioTest {

	private DesafioDeUsuario desafioUsuario;
	private Usuario usuario;
	private Desafio desafio;
	private EstadoDesafio noAceptado;
	private Aceptado estadoAceptado;
	private LocalDate fechaAceptado;
	private LocalDate fechaEnQueSeCompletoDesafioTest1;
	private LocalDate fechaObtenida;
	private BloqueSemanal restriccionBloqueSemanal;
	private Muestra	muestra;
	private AreaGeografica area;
	private Proyecto proyecto;
	private Categoria categoria;
	private ArrayList<Categoria> listaCategorias;
	
	@BeforeEach
	void setUp() throws Exception {
		restriccionBloqueSemanal = new BloqueSemanal(true);
		categoria = new Categoria("Biología");
		listaCategorias = new ArrayList<Categoria>();
		listaCategorias.add(categoria);
		area = new AreaGeografica(500, 500, 500);
		desafio = new Desafio(area, 2, 3, restriccionBloqueSemanal, 1000);
		usuario = new Usuario("nombreUsuario");
		estadoAceptado = new Aceptado();
		desafioUsuario = new DesafioDeUsuario(desafio);
		
		fechaAceptado = LocalDate.of(2022, 11, 06);
		
		usuario.agregarDesafiosDisponibles(desafioUsuario);
		 
		noAceptado = desafioUsuario.getEstado();
		
		proyecto = new Proyecto("proyecto", "descripcion", listaCategorias);
		
	}
	
	@Test
	void testgetDesafio() {
		assertEquals(desafioUsuario.getDesafio(), desafio);
		assertEquals(desafioUsuario.getEstado(), noAceptado);
	}
	
	@Test
	void testGetFechaAceptado() {
		usuario.aceptarDesafioDeUsuario(desafioUsuario);
		assertEquals(fechaAceptado, desafioUsuario.getFechaAceptado()) ;
	}
	
	@Test
	void testDeEstadoDesafioActualCorrectoDebeSerCompletado() {
		usuario.aceptarDesafioDeUsuario(desafioUsuario);
		desafio.setCantidadObjetivoDeMuestras(1);
		usuario.recolectarMuestra(muestra, proyecto);
		usuario.completarDesafioDeUsuario(desafioUsuario, 5);
		
		EstadoDesafio estadoObtenido = desafioUsuario.getEstado();
		EstadoDesafio estadoCompletado = new Completado();
		
		assertEquals(estadoCompletado.getClass(), estadoObtenido.getClass());
		
	}
	
}
