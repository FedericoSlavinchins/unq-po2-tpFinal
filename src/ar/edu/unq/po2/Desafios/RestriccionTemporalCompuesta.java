package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class RestriccionTemporalCompuesta implements RestriccionTemporal  {
	
	private ArrayList<RestriccionTemporal> restricciones = new ArrayList<RestriccionTemporal>();
	
	@Override
	public boolean cumpleRestriccion(LocalDate fechaObjetivo) {
		boolean cumpleConRestriccionCompuesta = true; // Se asigna en true para aprovechar el operador AND luego.
		for (RestriccionTemporal restriccionTemporal : this.restricciones) {
			cumpleConRestriccionCompuesta = (cumpleConRestriccionCompuesta && restriccionTemporal.cumpleRestriccion(fechaObjetivo));
		} // En caso de que todas las restricciones se cumplan , la variable local será TRUE debido al uso del operador AND.
		return cumpleConRestriccionCompuesta;
	}
	
	public void agregarRestriccionTemporal(RestriccionTemporal restriccionTemporal) {
		this.restricciones.add(restriccionTemporal);
	}

}
