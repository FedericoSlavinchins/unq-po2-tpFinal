package ar.edu.unq.po2.SistemaUsuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.EstadoDesafio.Aceptado;
import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.Proyecto.Proyecto;

public class Usuario {
	
	private String nombre;
	private PreferenciaUsuario preferenciaUsuario;
	private RecomendadorDeLudificacion estrategiaDeRecomendacionDeDesafios;	// FS: Cambiada la referencia, referenciaba incorrectamente la interfaz y no la clase.
	
	private double recompensasAcumuladas;			 // FS: Las ganancias acumuladas que obtuvo por completar desafios.
	private ArrayList<Muestra> muestrasSubidas;
	private ArrayList<Proyecto> proyectos;
	
	private ArrayList<DesafioDeUsuario>	desafiosDisponibles;	// FS: No aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosAceptados;		// FS: Aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosCompletados;	// FS: Completados.
	
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.preferenciaUsuario = new PreferenciaUsuario(0,0,0);
		this.recompensasAcumuladas = 0;
		this.muestrasSubidas = new ArrayList<Muestra>();
		this.proyectos = new ArrayList<Proyecto>();
		this.desafiosDisponibles = new ArrayList<DesafioDeUsuario>();
		this.desafiosAceptados 	= new ArrayList<DesafioDeUsuario>();
		this.desafiosCompletados	= new ArrayList<DesafioDeUsuario>();
		
	}
	
	
	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}


	public void suscribirseAProyecto(Proyecto proyecto) {
		proyectos.add(proyecto);
		proyecto.agregarParticipante(this);
	}
	
	public void recolectarMuestra(Muestra muestra, Proyecto proyecto) {
		this.muestrasSubidas.add(muestra);	// FS: Agregar a muestras subidas del usuario.
		proyecto.agregarMuestra(muestra); 	// FS: Agregar la muestra al proyecto.
	}
	
	
	
	// FS: Métodos aceptar y completar desafío.
	public void aceptarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		// FS: Precondición: el desafio de usuario debe estar disponible para el usuario.
		desafiosDisponibles.remove(desafioDeUsuario);
		this.desafiosAceptados.add(desafioDeUsuario);
		desafioDeUsuario.setEstado(new Aceptado());			// FS: Setea instancia ACEPTADO en DesafioDeUsuario.
		desafioDeUsuario.setFechaAceptado(LocalDate.now());
	}
	
	
	public void completarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		// FS: Precondición: el desafio de usuario debe haber sido previamente aceptado.
		this.desafiosAceptados.remove(desafioDeUsuario);
		//Cambio de estado, deberia pasar de Aceptado a Completado.
		this.desafiosCompletados.add(desafioDeUsuario);
		desafioDeUsuario.setFechaCompletado(LocalDate.now());
		this.recompensasAcumuladas += desafioDeUsuario.getDesafio().getRecompensa();	// FS: Otorga recompensa.
		//this.votarDesafio(desafioDeUsuario, 0);	// El usuario debe elegir el voto.
	}
	
	
	/*
	public void votarDesafio(DesafioDeUsuario desafioDeUsuario, int voto) {
		Falta realizar.
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


	public ArrayList<Muestra> getMuestrasSubidas() {
		return this.muestrasSubidas;
	}


	public ArrayList<DesafioDeUsuario> getDesafiosDisponibles() {
		return desafiosDisponibles;
	}


	public ArrayList<DesafioDeUsuario> getDesafiosAceptados() {
		return desafiosAceptados;
	}


	public ArrayList<DesafioDeUsuario> getDesafiosCompletados() {
		return desafiosCompletados;
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
