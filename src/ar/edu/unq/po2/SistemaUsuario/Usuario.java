package ar.edu.unq.po2.SistemaUsuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.EstadoDesafio.Aceptado;

public class Usuario {
	
	private PreferenciaUsuario preferenciaUsuario = new PreferenciaUsuario();
	private double recompensasAcumuladas;							// FS: Las ganancias acumuladas que obtuvo por completar desafios.
	private ArrayList<DesafioDeUsuario>	desafiosDisponibles	= new ArrayList<DesafioDeUsuario>();	// FS: No aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosAceptados 	= new ArrayList<DesafioDeUsuario>();	// FS: Aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosCompletados	= new ArrayList<DesafioDeUsuario>();	// FS: Completados.
	
	// FS: Métodos aceptar y completar desafío.
	public void aceptarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		if (desafiosDisponibles.contains(desafioDeUsuario)) {
			this.desafiosAceptados.add(desafioDeUsuario);
			desafioDeUsuario.setEstado(new Aceptado());			// FS: Setea instancia ACEPTADO en DesafioDeUsuario.
			desafioDeUsuario.setFechaAceptado(LocalDate.now());
		}
		// FS: Si el desafio de usuario no está disponible para el usuario, este método no hace nada.
	}
	
	
	public void completarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {		// FS: Precondición: el desafio de usuario debe haber sido previamente aceptado.
		this.desafiosAceptados.remove(desafioDeUsuario);
		this.desafiosCompletados.add(desafioDeUsuario);
		desafioDeUsuario.setFechaCompletado(LocalDate.now());
		this.recompensasAcumuladas += desafioDeUsuario.getDesafio().getRecompensa();	// FS: Otorga recompensa.
		//this.votarDesafio(desafioDeUsuario, 0);	// El usuario debe elegir el voto.
	}
	
	
	/*
	public void votarDesafio(DesafioDeUsuario desafioDeUsuario, int voto) {
		
	}
	*/
	
	
	//FS: Métodos para cambiar preferencias de jugabilidad del usuario.
	
	public void cambiarPreferenciaDeCantidadDeMuestrasARecolectar(int cantidadDeseada) {
		this.preferenciaUsuario.setCantidadDeMestrasARecolectar(cantidadDeseada);
	}
	
	public void cambiarPreferenciaDeDificultadPreferida(int dificultadDeseada) {
		this.preferenciaUsuario.setDificultadPreferida(dificultadDeseada);
	}
	
	public void cambiarPreferenciaDeRecompensaPreferida(int recompensaDeseada) {
		this.preferenciaUsuario.setRecompensaPreferida(recompensaDeseada);
	}
	
	
	// FS: Métodos de conocimiento de información acerca de Desafios del Usuario.
	
	public boolean completoDesafio(DesafioDeUsuario desafioDeUsuario) {		//FS: Indica si completó un desafio del usuario.
		return (desafioDeUsuario.porcentajeDeCompletitud() == 100);			// FS: Revisar si este método sirve (?).
	}
	
	public int porcentajeDeCompletitudGeneral() {			// FS: Entre desafios aceptados.
		int resultado = 0; 
		for (DesafioDeUsuario desafioDeUsuario : this.desafiosAceptados) {
			resultado += desafioDeUsuario.porcentajeDeCompletitud();
		}
		return (resultado + (this.desafiosCompletados.size() * 100)) / 
					(this.desafiosAceptados.size() + 
					this.desafiosCompletados.size());
	}
	
	
	
	
	
	
	/* REALIZADO ANTERIORMENTE
		
	public List<DesafioDeUsuario> getDesafiosCompletados(){
		return this.desafiosCompletados;
	}
	
	
	
	public int porcentajeDeCompletitud(DesafioDeUsuario desafio) {
		return desafio.porcentajeDeCompletitud();
	}
	
	
	*/
}
