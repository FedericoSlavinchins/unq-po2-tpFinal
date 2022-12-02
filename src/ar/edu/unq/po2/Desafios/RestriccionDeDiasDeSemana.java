package ar.edu.unq.po2.Desafios;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class RestriccionDeDiasDeSemana  implements RestriccionTemporal {

	@Override
	public boolean cumpleRestriccion(LocalDate fechaObjetivo) {
		return (fechaObjetivo.getDayOfWeek() == DayOfWeek.MONDAY) 
				||
				(fechaObjetivo.getDayOfWeek() == DayOfWeek.TUESDAY) 
				||
				(fechaObjetivo.getDayOfWeek() == DayOfWeek.WEDNESDAY) 
				||
				(fechaObjetivo.getDayOfWeek() == DayOfWeek.THURSDAY) 
				||
			    (fechaObjetivo.getDayOfWeek() == DayOfWeek.FRIDAY);
	}
	
}
