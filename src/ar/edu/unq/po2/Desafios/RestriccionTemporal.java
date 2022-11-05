package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;

public interface RestriccionTemporal {
	
	public abstract boolean  cumplioPeriodo(LocalDate fechaObjetivo);
	
}
