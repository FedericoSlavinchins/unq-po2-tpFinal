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

	private AreaGeografica area;
	private RestriccionTemporal restriccionTemporal;
	private int cantidadObjetivoDeMuestras;
	private int dificultad;
	private double recompensa;
	
	@BeforeEach
	void setUp() throws Exception {
		this.area = new AreaGeografica(cantidadObjetivoDeMuestras, cantidadObjetivoDeMuestras, cantidadObjetivoDeMuestras);
		this.restriccionTemporal = new RestriccionTemporal();
		this.cantidadObjetivoDeMuestras = 0;
		this.recompensa = 0;
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
