package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class RestriccionCompuesta implements RestriccionTemporal {
	
	private ArrayList<RestriccionTemporal> restricciones = new ArrayList<RestriccionTemporal>();
	
	@Override
	public boolean cumpleRestriccion(LocalDate fechaObjetivo) {
		boolean cumpleConTodasLasRestricciones = true; // Se asigna en true para aprovechar el operador AND luego.
		for (RestriccionTemporal restriccionTemporal : restricciones) {
			cumpleConTodasLasRestricciones = (cumpleConTodasLasRestricciones && restriccionTemporal.cumpleRestriccion(fechaObjetivo));
		} // En caso de que una de las restricciones no se cumpla, la variable local será FALSE debido al uso del AND.
		return cumpleConTodasLasRestricciones;
	}

}
