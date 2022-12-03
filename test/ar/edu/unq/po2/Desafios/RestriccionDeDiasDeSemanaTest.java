package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionDeDiasDeSemanaTest {

	private RestriccionDeDiasDeSemana restriccionDeDiasDeSemana;
	private LocalDate sabado3Diciembre;
	private LocalDate jueves1Diciembre;
	
	@BeforeEach
	public void setUp() {
		restriccionDeDiasDeSemana = new RestriccionDeDiasDeSemana();
		sabado3Diciembre = LocalDate.of(2022, 12, 3);		// FS: Sábado.
		jueves1Diciembre = LocalDate.of(2022, 12, 1);		// FS: Jueves.
	}

	@Test
	void cuandoHayRestriccionDeDiaDeSemanaYSeCompletaEl3dic2022NoSeCumpleConElPeriodoDeRestriccion() {
		boolean resultado = restriccionDeDiasDeSemana.cumpleRestriccion(sabado3Diciembre);
		assertFalse(resultado);
	}
	
	@Test
	void cuandoHayRestriccionDeDiaDeSemanaYSeCompletaEl1dic2022SeCumpleConElPeriodoDeRestriccion() {
		boolean resultado = restriccionDeDiasDeSemana.cumpleRestriccion(jueves1Diciembre);
		assertTrue(resultado);
	}
	

}
