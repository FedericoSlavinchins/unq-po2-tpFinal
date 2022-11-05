package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;

public class CombinacionEntreFechasYBloqueSemanal implements RestriccionTemporal {
	
	// F.S.: Representa la restricción temporal que es combinacion de las variaciones de entre fechas y bloque semanal de la misma.
	
	private EntreFechas 	restriccionEntreFechas;
	private BloqueSemanal 	restriccionBloqueSemanal;
	
	public CombinacionEntreFechasYBloqueSemanal(EntreFechas restriccionEntreFechas, BloqueSemanal restriccionBloqueSemanal) {
		this.restriccionEntreFechas   = restriccionEntreFechas;
		this.restriccionBloqueSemanal = restriccionBloqueSemanal;
	}

	public boolean cumplirPeriodo(LocalDate fechaObjetivo) {		// F.S.: Cumple periodo de restriccion si cumplió con periodo de ambas restricciones (EntreFechas y BloqueSemanal).
		return( restriccionEntreFechas.cumplirPeriodo(fechaObjetivo)
				&&
				restriccionBloqueSemanal.cumplirPeriodo(fechaObjetivo));
	}
	
	
}
