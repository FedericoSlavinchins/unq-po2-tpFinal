package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class RestriccionCompuesta implements RestriccionTemporal  {
	
	private ArrayList<RestriccionTemporal> restricciones = new ArrayList<RestriccionTemporal>();
	
	@Override
	public boolean cumpleRestriccion(LocalDate fechaObjetivo) {
		boolean cumpleConRestriccionCompuesta = false; // Se asigna en true para aprovechar el operador OR luego.
		for (RestriccionTemporal restriccionTemporal : restricciones) {
			cumpleConRestriccionCompuesta = (cumpleConRestriccionCompuesta || restriccionTemporal.cumpleRestriccion(fechaObjetivo));
		} // En caso de que una de las restricciones se cumpla , la variable local será TRUE debido al uso del OR.
		return cumpleConRestriccionCompuesta;
	}
	
	public void agregarRestriccionTemporal(RestriccionTemporal restriccionTemporal) {
		this.restricciones.add(restriccionTemporal);
	}

}
