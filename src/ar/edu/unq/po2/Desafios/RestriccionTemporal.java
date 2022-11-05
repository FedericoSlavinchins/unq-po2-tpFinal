package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;

public interface RestriccionTemporal {
	
	public boolean  cumplioPeriodo(LocalDate fechaObjetivo);
	
}