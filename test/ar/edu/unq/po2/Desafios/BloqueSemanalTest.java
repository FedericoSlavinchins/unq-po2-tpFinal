package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BloqueSemanalTest {
	
	private BloqueSemanal restriccionBloqueSemanalDiaSemana;
	private boolean desafioDebeSerCompletadoDiaDeSemana;
	private BloqueSemanal restriccionBloqueSemanalFinDeSemana;
	private boolean desafioDebeSerCompletadoFinDeSemana;
	private LocalDate sabado3Diciembre;
	private LocalDate jueves1Diciembre;
	
	@BeforeEach
	public void setUp() {
		sabado3Diciembre = LocalDate.of(2022, 12, 3);		// FS: Sábado.
		jueves1Diciembre = LocalDate.of(2022, 12, 1);		// FS: Jueves.
		
		desafioDebeSerCompletadoDiaDeSemana = true;
		desafioDebeSerCompletadoFinDeSemana = false;
		restriccionBloqueSemanalDiaSemana	= new BloqueSemanal(desafioDebeSerCompletadoDiaDeSemana);
		restriccionBloqueSemanalFinDeSemana = new BloqueSemanal(desafioDebeSerCompletadoFinDeSemana);
	}

	@Test
	void cuandoHayRestriccionDeDiaDeSemanaYSeCompletaEl3dic2022NoSeCumpleConElPeriodoDeRestriccion() {
		boolean resultado = restriccionBloqueSemanalDiaSemana.cumplioPeriodo(sabado3Diciembre);
		assertFalse(resultado);
	}
	
	@Test
	void cuandoHayRestriccionDeDiaDeSemanaYSeCompletaEl1dic2022SeCumpleConElPeriodoDeRestriccion() {
		boolean resultado = restriccionBloqueSemanalDiaSemana.cumplioPeriodo(jueves1Diciembre);
		assertTrue(resultado);
	}
	
	@Test
	void cuandoHayRestriccionDeFinDeSemanaYSeCompletaEl1dic2022NoSeCumpleConElPeriodoDeRestriccion() {
		boolean resultado = restriccionBloqueSemanalFinDeSemana.cumplioPeriodo(jueves1Diciembre);
		assertFalse(resultado);
	}
	

	@Test
	void cuandoHayRestriccionDeFinDeSemanaYSeCompletaEl3dic2022SeCumpleConElPeriodoDeRestriccion() {
		boolean resultado = restriccionBloqueSemanalFinDeSemana.cumplioPeriodo(sabado3Diciembre);
		assertTrue(resultado);
	}

}
