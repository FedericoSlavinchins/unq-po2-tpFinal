package ar.edu.unq.po2.Proyecto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class AreaGeograficaTest {
	private AreaGeografica area;
	private Ubicacion ubicacion1;
	
	@BeforeEach
	public void setUp() {
		area = new AreaGeografica(94, 34, 16);
		ubicacion1 = mock(Ubicacion.class);
	}
	
	@Test
	public void ubicacionSeEncuentraEnRangoTest() {
		
		assertFalse(area.estaEnRango(ubicacion1));
		verify(ubicacion1, times(1)).getLatitud();
		verify(ubicacion1, times(1)).getLongitud();
	}
}
