package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.EstadoDesafio.Aceptado;
import ar.edu.unq.po2.Proyecto.AreaGeografica;
import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Proyecto;
import ar.edu.unq.po2.Proyecto.Ubicacion;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

class DesafioTest {
	
	private Desafio desafio;
	private AreaGeografica area;
	private RestriccionTemporal restriccionTemporal;
	private BloqueSemanal restriccionBloqueSemanalDiaSemana;
	private Ubicacion ubicacion;
	private LocalDate diaDeSemana;
	private boolean esDiaDeSemana;

	
	@BeforeEach
	void setUp() throws Exception {
	desafio = new Desafio(area, 5, 3,restriccionBloqueSemanalDiaSemana, 5);
	this.area = new AreaGeografica(2, 3, 15);
	//this.restriccionTemporal = new RestriccionTemporal();
	this.ubicacion = new Ubicacion(2, 3);
	esDiaDeSemana = true;
	restriccionBloqueSemanalDiaSemana = new BloqueSemanal(esDiaDeSemana);
	diaDeSemana = LocalDate.of(2022, 12, 1);
	restriccionTemporal = restriccionBloqueSemanalDiaSemana;
	}
	
	@Test
	void testComprobarQueAgregaMuestras() {
		int resultadoObtenido = desafio.getCantidadObjetivoDeMuestras();
		assertEquals(5 , resultadoObtenido);

	}
	
	@Test
	void testGetDificultad() {
		int resultadoObtenido = desafio.getDificultad();
		assertEquals(3 , resultadoObtenido);

	}
	@Test 
	void testGetRecompensa() {
		double resultadoObtenido = desafio.getRecompensa();
		assertEquals(5 , resultadoObtenido);
	}
	@Test
	void testDelArea() {
		assertTrue(area.estaEnRango(ubicacion));

	}
	@Test
	void testRestriccionTemporal() {
			boolean resultado = restriccionBloqueSemanalDiaSemana.cumplioPeriodo(diaDeSemana);
			assertTrue(resultado);
		}
	@Test
	void testSetRestriccionTemporal() {
			desafio.setRestriccionTemporal(restriccionTemporal);
			assertEquals(restriccionTemporal,desafio.getRestriccionTemporal());
		}
}
	
