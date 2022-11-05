package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.EstadoDesafio.EstadoDesafio;
import ar.edu.unq.po2.EstadoDesafio.NoAceptado;
import ar.edu.unq.po2.Proyecto.Muestra;

public class DesafioDeUsuario {
	
	// FS: Esta clase permite trackear al Desafio.
	// FS: Realiza un seguimiento del progreso del usuario en el Desafio.
	
	private Desafio desafio;
	private ArrayList<Muestra> muestrasRecolectadas = new ArrayList<Muestra>();
	private LocalDate fechaAceptado;		//FS: Se instancia cuando se acepta el desafio, por lo tanto, al instanciarse toma la fecha en que es aceptado.
	private LocalDate fechaCompletado;
	private EstadoDesafio estado;			//FS: El estado debe estar en esta clase, ya que es parte del progreso del usuario.
	private int porcentajeCompletitud;
	
	public DesafioDeUsuario (Desafio desafio) {
		this.desafio = desafio;
		this.estado  = new NoAceptado();
	}
	
	public int cantidadMuestrasRecolectadasParaEsteDesafio() {
		return this.muestrasRecolectadas.size();
	}
	
	public void setFechaCompletado(LocalDate fechaEnQueCompletoDesafio) {
		this.fechaCompletado = fechaEnQueCompletoDesafio;
	}

	public LocalDate getFechaCompletado() {
		return this.fechaCompletado;
	}
	
	public int porcentajeCompletitud() {
		return (this.cantidadMuestrasRecolectadasParaEsteDesafio() * 100) / this.desafio.getCantidadObjetivoDeMuestras() ;
	}
	
	public void setEstado(EstadoDesafio estado) {
		this.estado = estado;
		this.estado.setDesafio(this); //guarda la referencia de el estado de este desafio
	}

}
