package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Proyecto.AreaGeografica;

class DesafioTest {
	
	private Desafio desafio;
	private AreaGeografica area;
	private RestriccionTemporal restriccionTemporal;
	private RestriccionDeDiasDeSemana restriccionDeDiasDeSemana;

	
	@BeforeEach
	void setUp() throws Exception {
	area = mock(AreaGeografica.class);
	desafio = new Desafio(area, 5, 3, restriccionDeDiasDeSemana, 5);
	restriccionTemporal = mock(RestriccionTemporal.class);
	}
	
	
	
	@Test
	void testGetterMuestrasARecolectar() {
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
	void testGetArea() {
		AreaGeografica resultadoEsperado = area;
		AreaGeografica resultadoObtenido = desafio.getArea();
		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	
	
	
	/* FS: Test debe ir en restriccion temporal.
	@Test
	void testRestriccionTemporal() {
			boolean resultado = restriccionBloqueSemanalDiaSemana.cumpleRestriccion(diaDeSemana);
			assertTrue(resultado);
	}
	*/
	
	@Test
	void testSetRestriccionTemporal() {
			desafio.setRestriccionTemporal(restriccionTemporal);
			assertEquals(restriccionTemporal,desafio.getRestriccionTemporal());
	}
	
	
}
	
