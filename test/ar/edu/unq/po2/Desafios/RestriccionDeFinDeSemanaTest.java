package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionDeFinDeSemanaTest {
	
	private RestriccionDeFinDeSemana restriccionFinDeSemana;
	private LocalDate sabado;
	private LocalDate domingo;
	
	@BeforeEach
	public void setUp() {
		restriccionFinDeSemana = new RestriccionDeFinDeSemana();
		sabado = LocalDate.of(2022, 12, 03);
		domingo = LocalDate.of(2022, 12, 04);
	}

	@Test
	void testCumpleRestriccionSiSeLePasaParametroDiaSabado() {
		assertTrue(restriccionFinDeSemana.cumpleRestriccion(sabado));
	}
	
	@Test
	void testCumpleRestriccionSiSeLePasaParametroDiaDomingo() {
		assertTrue(restriccionFinDeSemana.cumpleRestriccion(domingo));
	}
	
	@Test
	void testNoCumpleRestriccionSiSeLePasaParametroDiaLunes() {
		assertFalse(restriccionFinDeSemana.cumpleRestriccion(LocalDate.of(2022, 12, 05)));
	}

}
