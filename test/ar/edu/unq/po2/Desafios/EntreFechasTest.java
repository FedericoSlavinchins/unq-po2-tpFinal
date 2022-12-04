package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntreFechasTest {
	
	private RestriccionDeEntreFechasSimple restriccionEntreFechas;
	private LocalDate fechaInicioRestriccion;
	private LocalDate fechaFinRestriccion;
	private LocalDate fechaEnQueSeCompletoDesafioTest1;
	private LocalDate fechaEnQueSeCompletoDesafioTest2;
	private LocalDate fechaEnQueSeCompletoDesafioTest3;
	
	@BeforeEach
	public void setUp() {
		fechaInicioRestriccion = LocalDate.of(2022, 9, 20);
		fechaFinRestriccion = LocalDate.of(2022, 9, 25);
		fechaEnQueSeCompletoDesafioTest1 = LocalDate.of(2022, 9, 26);
		fechaEnQueSeCompletoDesafioTest2 = LocalDate.of(2022, 9, 25);
		fechaEnQueSeCompletoDesafioTest3 = LocalDate.of(2022, 9, 20);
		restriccionEntreFechas = new RestriccionDeEntreFechasSimple(fechaInicioRestriccion, fechaFinRestriccion);
	}

	@Test
	void siSeCompletoElDesafioEl26Septiembre2022NoCumplioConElPeriodoDeRestriccion() {
		boolean resultado   = restriccionEntreFechas.cumpleRestriccion(fechaEnQueSeCompletoDesafioTest1);
		assertFalse(resultado);
	}
	
	@Test
	void siSeCompletoElDesafioEl25Septiembre2022CumplioConElPeriodoDeRestriccion() {
		boolean resultado   = restriccionEntreFechas.cumpleRestriccion(fechaEnQueSeCompletoDesafioTest2);
		assertTrue(resultado);
	}
	
	@Test
	void siSeCompletoElDesafioEl20Septiembre2022CumplioConElPeriodoDeRestriccion() {
		boolean resultado   = restriccionEntreFechas.cumpleRestriccion(fechaEnQueSeCompletoDesafioTest3);
		assertTrue(resultado);
	}

}
