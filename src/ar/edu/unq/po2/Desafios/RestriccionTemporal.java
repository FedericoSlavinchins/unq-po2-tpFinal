package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;

public abstract class RestriccionTemporal {
	
	public abstract boolean  cumplirPeriodo(LocalDate fechaObjetivo);
}
