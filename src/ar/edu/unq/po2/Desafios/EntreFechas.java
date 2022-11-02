package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;

public class EntreFechas extends RestriccionTemporal {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	

	public EntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin    = fechaFin;
	}
	
	@Override 
	public boolean cumplirPeriodo(LocalDate fechaObjetivo) {
		return ((fechaObjetivo.isAfter(fechaInicio)) && (fechaObjetivo.isBefore(fechaFin)));
	}
	
}
