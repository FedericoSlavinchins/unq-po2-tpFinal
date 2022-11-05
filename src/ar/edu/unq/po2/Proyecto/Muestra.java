package ar.edu.unq.po2.Proyecto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import ar.edu.unq.po2.SistemaUsuario.Usuario;

public class Muestra {
	
    private Geocoordenada geocoordenada;
	private Usuario usuario;
	private LocalDate fecha = LocalDate.now();
	private LocalTime hora = LocalTime.now();
	
	
	public Muestra(Usuario usuario, Geocoordenada geocoordenada) {
		this.usuario = usuario;
		this.geocoordenada = geocoordenada;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

	public LocalTime getHora() {
		return this.hora.truncatedTo(ChronoUnit.SECONDS);
	}
	
}
