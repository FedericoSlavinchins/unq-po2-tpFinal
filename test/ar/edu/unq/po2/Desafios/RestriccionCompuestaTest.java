package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionCompuestaTest {

	private RestriccionDeEntreFechasSimple restriccionEntreFechas;
	private RestriccionDeEntreFechasSimple restriccionEntreFechas2;
	private LocalDate fechaInicioRestriccion2;
	private LocalDate fechaFinRestriccion2;
	private LocalDate fechaInicioRestriccion1;
	private LocalDate fechaFinRestriccion1;
	
	private RestriccionDeFinDeSemana restriccionFinDeSemana;
	
	private RestriccionCompuesta restriccionCompuesta;
	
	@BeforeEach
	public void setUp() {
		
		//FS: Primera restricción.
		fechaInicioRestriccion1 = LocalDate.of(2022, 8, 1);
		fechaFinRestriccion1 = LocalDate.of(2022, 8, 31);
		restriccionEntreFechas2 = new RestriccionDeEntreFechasSimple(fechaInicioRestriccion1, fechaFinRestriccion1); // del 1/11/22 al 31/12/22
		
		// FS: Segunda restricción.
		restriccionFinDeSemana = new RestriccionDeFinDeSemana();
		
		//FS: Tercera restriccion
		fechaInicioRestriccion2 = LocalDate.of(2022, 12, 1);
		fechaFinRestriccion2 = LocalDate.of(2022, 12, 31);
		restriccionEntreFechas = new RestriccionDeEntreFechasSimple(fechaInicioRestriccion2, fechaFinRestriccion2); // del 1/11/22 al 31/12/22
		
		// FS: Restricción de combinación.
		restriccionCompuesta = new RestriccionCompuesta();
		restriccionCompuesta.agregarRestriccionTemporal(restriccionEntreFechas2);
		restriccionCompuesta.agregarRestriccionTemporal(restriccionEntreFechas);
		restriccionCompuesta.agregarRestriccionTemporal(restriccionFinDeSemana);
		// La restriccion compuesta pide todos los fines de semana del mes de Agosto y Diciembre.
	}
	
	@Test
	void cuandoElDesafioEsCompletadoSabadoODomingoEntre1y31DeDiciembreCumplePeriodo() {	
		//FS: Este test contempla cumplir desafios diferentes en un periodo de entre fechas de un mes, en dos fines de semana diferentes.
		boolean resultadoDeSabado3DeDic  = restriccionCompuesta.cumpleRestriccion(LocalDate.of(2022, 12, 3));
		boolean resultadoDeDomingo25DeDic = restriccionCompuesta.cumpleRestriccion(LocalDate.of(2022, 12, 25));
		assertTrue(resultadoDeSabado3DeDic);
		assertTrue(resultadoDeDomingo25DeDic);
	}

}

/*
 * 
 * 
 * sabado3Diciembre = LocalDate.of(2022, 12, 3);
		domingo25Diciembre = LocalDate.of(2022, 12, 25);
		**/
