package ar.edu.unq.po2.Desafios;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class RestriccionDeFinDeSemana implements RestriccionTemporal {

	@Override
	public boolean cumpleRestriccion(LocalDate fechaObjetivo) {
		return (fechaObjetivo.getDayOfWeek() == DayOfWeek.SATURDAY) 
				||
			    (fechaObjetivo.getDayOfWeek() == DayOfWeek.SUNDAY);
	}

}
