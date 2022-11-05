package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;

public class EntreFechas implements RestriccionTemporal {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	

	public EntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin    = fechaFin;
	}
	
	// F.S.: Fecha objetivo es una fecha que debe ser pasada como parámetro, y que corresponde a la fecha en que se completó el desafío.
	
	@Override 
	public boolean cumplirPeriodo(LocalDate fechaObjetivo) {
		return (fechaObjetivo.isEqual(this.fechaInicio)				// FS: Completo el día de fecha inicio restricción.
				||
				(fechaObjetivo.isAfter(fechaInicio)) && (fechaObjetivo.isBefore(fechaFin)) // FS: Completó entre fecha inicio y fecha fin.
				||
				fechaObjetivo.isEqual(this.fechaFin)				// FS: Completo el desafío en el último día.
				);
	}
	
}
