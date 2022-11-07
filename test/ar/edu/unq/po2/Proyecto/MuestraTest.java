package ar.edu.unq.po2.Proyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.SistemaUsuario.Usuario;
import static org.mockito.Mockito.*;

class MuestraTest {
	
	private Muestra muestra;
	private Ubicacion geocoordenada;
	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		usuario = mock(Usuario.class);
		geocoordenada = mock(Ubicacion.class);
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
	
	@Test
	void seRecibeLaInformacionDeLaMuestraAlMomentoDeTomarseTest() {
		assertEquals(muestra.getUsuario(), usuario);
		assertEquals(muestra.getGeocoordenada(), geocoordenada);
	}

}
