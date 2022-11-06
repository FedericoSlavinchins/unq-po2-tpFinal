package ar.edu.unq.po2.Proyecto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class AreaGeograficaTest {
	private AreaGeografica area;
	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	
	@BeforeEach
	public void setUp() {
		area = new AreaGeografica(94, 34, 500);
		ubicacion1 = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);
	}
	
	@Test
	public void areaCotejaSiLasUbicacionesEstaEnSuRadioTest() {
		when(ubicacion1.getLatitud()).thenReturn((float) 94);
		when(ubicacion1.getLongitud()).thenReturn((float) 37);
		when(ubicacion2.getLatitud()).thenReturn((float) 24);
		when(ubicacion2.getLongitud()).thenReturn((float) 67);
		
		area.estaEnRango(ubicacion1);
		area.estaEnRango(ubicacion2);
		
		verify(ubicacion1, times(1)).getLatitud();
		verify(ubicacion1, times(1)).getLongitud();
		
		verify(ubicacion2, times(1)).getLatitud();
		verify(ubicacion2, times(1)).getLongitud();
		
		assertTrue(area.estaEnRango(ubicacion1));
		assertFalse(area.estaEnRango(ubicacion2));
	}
	/*
	@Test
	public void areaCotejaSiUbicacion2EstaEnSuRadioTest() {
		
		
	}*/
}
