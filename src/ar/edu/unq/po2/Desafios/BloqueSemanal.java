package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;

public class BloqueSemanal implements RestriccionTemporal {

	private boolean hayRestriccionesDiaSemana;
	
	public BloqueSemanal(boolean hayRestriccionesDiaSemana) {
		this.hayRestriccionesDiaSemana = hayRestriccionesDiaSemana;
	}
	
	// F.S.: Fecha objetivo es una fecha que debe ser pasada como parámetro, y que corresponde a la fecha en que se completó el desafío.
	
	@Override 
	public boolean cumplioPeriodo(LocalDate fechaObjetivo) {
		if (hayRestriccionesDiaSemana) {
			return cumplioDesafioEnDiaDeSemana(fechaObjetivo);		// F.S.: Retorna true o false si realmente cumplió el desafío en día de semana.
		} else {
			return cumplioDesafioFinDeSemana(fechaObjetivo);		// F.S.: Retorna true o false si realmente cumplió el desafío en fin de semana.
		}	
	}
	
	private boolean cumplioDesafioFinDeSemana(LocalDate fechaObjetivo) {		
		return  (fechaObjetivo.getDayOfWeek().getValue() == 6) 
				||
			    (fechaObjetivo.getDayOfWeek().getValue() == 7);
	}

	private boolean cumplioDesafioEnDiaDeSemana(LocalDate fechaObjetivo) {
		return  (fechaObjetivo.getDayOfWeek().getValue() == 1) 
				||
				(fechaObjetivo.getDayOfWeek().getValue() == 2) 
				||
				(fechaObjetivo.getDayOfWeek().getValue() == 3) 
				||
				(fechaObjetivo.getDayOfWeek().getValue() == 4) 
				||
			    (fechaObjetivo.getDayOfWeek().getValue() == 5);
	}
	
}
