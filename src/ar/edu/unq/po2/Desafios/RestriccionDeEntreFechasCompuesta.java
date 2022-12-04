package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;
import java.util.ArrayList;

public class RestriccionDeEntreFechasCompuesta extends RestriccionDeEntreFechas {
	
	private ArrayList<RestriccionDeEntreFechas> restriccionesDeEntreFechas = new ArrayList<RestriccionDeEntreFechas>();

	@Override
	public boolean cumpleRestriccion(LocalDate fechaObjetivo) {
		boolean cumpleRestriccion = false;  // Se asigna en true para aprovechar el operador OR luego.
		for (RestriccionDeEntreFechas restriccionDeEntreFechas : this.restriccionesDeEntreFechas) {
			cumpleRestriccion = (cumpleRestriccion || restriccionDeEntreFechas.cumpleRestriccion(fechaObjetivo));
		} // En caso de que una de las restricciones se cumpla , la variable local será TRUE debido al uso del OR.
		return cumpleRestriccion;
	}
	
	public void agregarRestriccionDeEntreFechas(RestriccionDeEntreFechas restriccionDeEntreFechas) {
		this.restriccionesDeEntreFechas.add(restriccionDeEntreFechas);
	}

}
