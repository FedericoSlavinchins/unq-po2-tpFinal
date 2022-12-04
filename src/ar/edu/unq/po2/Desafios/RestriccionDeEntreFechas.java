package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;

public abstract class RestriccionDeEntreFechas implements RestriccionTemporal {

	public abstract boolean cumpleRestriccion(LocalDate fechaObjetivo);

}
