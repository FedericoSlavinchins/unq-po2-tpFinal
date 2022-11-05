package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombinacionEntreFechasYBloqueSemanalTest {
	
	private EntreFechas restriccionEntreFechas;
	private LocalDate fechaInicioRestriccion;
	private LocalDate fechaFinRestriccion;
	
	private boolean desafioDebeSerCompletadoDiaDeSemana;
	private BloqueSemanal restriccionBloqueSemanalFinDeSemana;
	private boolean desafioDebeSerCompletadoFinDeSemana;
	private LocalDate sabado3Diciembre;
	private LocalDate domingo25Diciembre;
	
	private CombinacionEntreFechasYBloqueSemanal restriccionCombinacion;
	
	@BeforeEach
	public void setUp() {
		//FS: Primera restricción.
		fechaInicioRestriccion = LocalDate.of(2022, 12, 1);
		fechaFinRestriccion = LocalDate.of(2022, 12, 31);
		sabado3Diciembre = LocalDate.of(2022, 12, 3);
		domingo25Diciembre = LocalDate.of(2022, 12, 25);
		restriccionEntreFechas = new EntreFechas(fechaInicioRestriccion, fechaFinRestriccion);
		// FS: Segunda restricción.
		desafioDebeSerCompletadoDiaDeSemana = true;
		desafioDebeSerCompletadoFinDeSemana = false;
		restriccionBloqueSemanalFinDeSemana = new BloqueSemanal(desafioDebeSerCompletadoFinDeSemana);
		
		// FS: Restricción de combinación.
		restriccionCombinacion = new CombinacionEntreFechasYBloqueSemanal(restriccionEntreFechas, restriccionBloqueSemanalFinDeSemana);
	}
	
	@Test
	void cuandoElDesafioEsCompletadoSabadoODomingoEntre1y31DeDiciembreCumplePeriodo() {	
		//FS: Este test contempla cumplir desafios diferentes en un periodo de entre fechas de un mes, en dos fines de semana diferentes.
		boolean resultadoDeSabado24deSept  = restriccionCombinacion.cumplirPeriodo(sabado3Diciembre);
		boolean resultadoDeDomingo25deSept = restriccionCombinacion.cumplirPeriodo(domingo25Diciembre);
		assertTrue(resultadoDeSabado24deSept);
		assertTrue(resultadoDeDomingo25deSept);
	}

}
