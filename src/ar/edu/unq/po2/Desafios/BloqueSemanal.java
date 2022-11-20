package ar.edu.unq.po2.Desafios;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class BloqueSemanal implements RestriccionTemporal {

	private boolean hayRestriccionesDiaSemana;
	
	public BloqueSemanal(boolean hayRestriccionesDiaSemana) {
		this.hayRestriccionesDiaSemana = hayRestriccionesDiaSemana;
	}
	
	// F.S.: Fecha objetivo es una fecha que debe ser pasada como parámetro, y que corresponde a la fecha en que se completó el desafío.
	
	@Override 
	public boolean cumpleRestriccion(LocalDate fechaObjetivo) {
		if (hayRestriccionesDiaSemana) {
			return cumplioDesafioEnDiaDeSemana(fechaObjetivo);		// F.S.: Retorna true o false si realmente cumplió el desafío en día de semana.
		} else {
			return cumplioDesafioFinDeSemana(fechaObjetivo);		// F.S.: Retorna true o false si realmente cumplió el desafío en fin de semana.
		}	
	}
	
	private boolean cumplioDesafioFinDeSemana(LocalDate fechaObjetivo) {		
		return  (fechaObjetivo.getDayOfWeek() == DayOfWeek.SATURDAY) 
				||
			    (fechaObjetivo.getDayOfWeek() == DayOfWeek.SUNDAY);
	}

	private boolean cumplioDesafioEnDiaDeSemana(LocalDate fechaObjetivo) {
		return  (fechaObjetivo.getDayOfWeek() == DayOfWeek.MONDAY) 
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
