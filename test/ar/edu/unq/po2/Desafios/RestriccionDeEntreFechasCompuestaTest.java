package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionDeEntreFechasCompuestaTest {
	
	private RestriccionDeEntreFechasCompuesta restriccionDeEntreFechasCompuesta1;
	private RestriccionDeEntreFechasCompuesta restriccionDeEntreFechasCompuesta2;
	private RestriccionDeEntreFechasSimple restriccionDeEntreFechasSimple1;
	private RestriccionDeEntreFechasSimple restriccionDeEntreFechasSimple2;
	private RestriccionDeEntreFechasSimple restriccionDeEntreFechasSimple3;
	
	@BeforeEach
	public void setUp() {
		restriccionDeEntreFechasSimple1 = mock(RestriccionDeEntreFechasSimple.class);
		restriccionDeEntreFechasSimple2 = mock(RestriccionDeEntreFechasSimple.class);
		restriccionDeEntreFechasSimple3 = mock(RestriccionDeEntreFechasSimple.class);
		restriccionDeEntreFechasCompuesta1 = new RestriccionDeEntreFechasCompuesta();
		restriccionDeEntreFechasCompuesta2 = new RestriccionDeEntreFechasCompuesta();
		
		restriccionDeEntreFechasCompuesta1.agregarRestriccionDeEntreFechas(restriccionDeEntreFechasCompuesta2);
		restriccionDeEntreFechasCompuesta2.agregarRestriccionDeEntreFechas(restriccionDeEntreFechasSimple1);
		restriccionDeEntreFechasCompuesta2.agregarRestriccionDeEntreFechas(restriccionDeEntreFechasSimple2);
		restriccionDeEntreFechasCompuesta2.agregarRestriccionDeEntreFechas(restriccionDeEntreFechasSimple3);
	}

	@Test
	void cuandoSeLeEnviaElMensajeCumpleRestriccionAlCompositeSeEnviaATodosLosCompositeYLeafPorIgual() {
		
		when(restriccionDeEntreFechasSimple1.cumpleRestriccion(LocalDate.of(2022, 12, 15))).thenReturn(false);
		when(restriccionDeEntreFechasSimple2.cumpleRestriccion(LocalDate.of(2022, 12, 15))).thenReturn(false);
		when(restriccionDeEntreFechasSimple3.cumpleRestriccion(LocalDate.of(2022, 12, 15))).thenReturn(true); // Se settea solo la última en True para testear que envíe
																											// el mensaje cumpleRestriccion a todas.
		
		boolean cumpleConTodasLasRestriccionesDeEntreFechas = restriccionDeEntreFechasCompuesta1.cumpleRestriccion(LocalDate.of(2022, 12, 15));
		assertTrue(cumpleConTodasLasRestriccionesDeEntreFechas);
		
		
		verify(restriccionDeEntreFechasSimple1).cumpleRestriccion(LocalDate.of(2022, 12, 15));
		verify(restriccionDeEntreFechasSimple2).cumpleRestriccion(LocalDate.of(2022, 12, 15));
		verify(restriccionDeEntreFechasSimple3).cumpleRestriccion(LocalDate.of(2022, 12, 15));
	}
	
	@Test
	void testNoCumpleConRestriccionDeEntreFechas() {
		
		when(restriccionDeEntreFechasSimple1.cumpleRestriccion(LocalDate.of(2022, 12, 15))).thenReturn(false);
		when(restriccionDeEntreFechasSimple2.cumpleRestriccion(LocalDate.of(2022, 12, 15))).thenReturn(false);
		when(restriccionDeEntreFechasSimple3.cumpleRestriccion(LocalDate.of(2022, 12, 15))).thenReturn(false);
		
		
		boolean cumpleConTodasLasRestriccionesDeEntreFechas = restriccionDeEntreFechasCompuesta1.cumpleRestriccion(LocalDate.of(2022, 12, 15));
		assertFalse(cumpleConTodasLasRestriccionesDeEntreFechas);
		
		
		verify(restriccionDeEntreFechasSimple1).cumpleRestriccion(LocalDate.of(2022, 12, 15));
		verify(restriccionDeEntreFechasSimple2).cumpleRestriccion(LocalDate.of(2022, 12, 15));
		verify(restriccionDeEntreFechasSimple3).cumpleRestriccion(LocalDate.of(2022, 12, 15));
	}
	
	

}
