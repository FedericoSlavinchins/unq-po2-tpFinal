package ar.edu.unq.po2.SistemaUsuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.EstadoDesafio.Aceptado;

public class Usuario {
	
	private PreferenciaUsuario preferenciaUsuario = new PreferenciaUsuario();
	private double recompensasAcumuladas;							// FS: Las ganancias que obtuvo por completar desafios.
	private ArrayList<DesafioDeUsuario>	desafiosDisponibles	= new ArrayList<DesafioDeUsuario>();	// FS: No aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosAceptados 	= new ArrayList<DesafioDeUsuario>();	// FS: Aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosCompletados	= new ArrayList<DesafioDeUsuario>();	// FS: Completados.
	
	
	public void aceptarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		this.desafiosAceptados.add(desafioDeUsuario);
		desafioDeUsuario.setEstado(new Aceptado());
		desafioDeUsuario.setFechaAceptado(LocalDate.now());
	}
	
	
	public void completarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		this.desafiosAceptados.remove(desafioDeUsuario);
		this.desafiosCompletados.add(desafioDeUsuario);
		this.recompensasAcumuladas += desafioDeUsuario.getDesafio().getRecompensa();	// FS: Otorga recompensa.
	}
	
	
	
	public void votarDesafio(DesafioDeUsuario desafioDeUsuario) {
		
	}
	
	
	
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
	
	
	
	
	
	
	/* REALIZADO ANTERIORMENTE
		
	public List<DesafioDeUsuario> getDesafiosCompletados(){
		return this.desafiosCompletados;
	}
	
	public boolean esDesafioCompletado(DesafioDeUsuario desafio) {
		return desafio.estaCompleto();
	}
	
	public int porcentajeDeCompletitud(DesafioDeUsuario desafio) {
		return desafio.porcentajeDeCompletitud();
	}
	
	public int porcentajeDeCompletitudGeneral() {
		int resultado = 0; 
		for (DesafioDeUsuario desafio : desafiosAceptados) {
			resultado += desafio.porcentajeDeCompletitud();
		}
		return (resultado + (this.desafiosCompletados.size() * 100)) / 
					(this.desafiosAceptados.size() + 
					this.desafiosCompletados.size());
	}
	*/
}
