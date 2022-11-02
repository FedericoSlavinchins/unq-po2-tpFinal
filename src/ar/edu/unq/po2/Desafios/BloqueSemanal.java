package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;

public class BloqueSemanal extends RestriccionTemporal {

	private boolean hayRestriccionesDiaSemana;
	
	public BloqueSemanal(boolean hayRestriccionesDiaSemana) {
		this.hayRestriccionesDiaSemana = hayRestriccionesDiaSemana;
	}
	
	@Override 
	public boolean cumplirPeriodo(LocalDate fechaObjetivo) {
		if(hayRestriccionesDiaSemana) {
			return cumplioDesafioEnDiaDeSemana(fechaObjetivo);
		} else {
			return cumplioDesafioFinDeSemana(fechaObjetivo);
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
