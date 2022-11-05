package ar.edu.unq.po2.Proyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.SistemaUsuario.Usuario;

class MuestraTest {
	
	private Muestra muestra;
	private Geocoordenada geocoordenada;
	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		usuario = new Usuario();
		geocoordenada = new Geocoordenada();
		muestra = new Muestra(usuario, geocoordenada);
	}

	@Test
	void cuandoSeRecolectaLaMuestraRecibeComoFechaElDiaDeLaRecoleccion() {
		LocalDate resultadoEsperado = LocalDate.now();
		LocalDate resultadoActual	= muestra.getFecha();
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
	@Test
	void cuandoSeRecolectaLaMuestraRecibeComoHoraLaHoraDeLaRecoleccion() {
		LocalTime resultadoEsperado = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		LocalTime resultadoActual	= muestra.getHora();
		assertEquals(resultadoEsperado, resultadoActual);
	}

}
