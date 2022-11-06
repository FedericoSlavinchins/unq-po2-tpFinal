package ar.edu.unq.po2.SistemaUsuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.EstadoDesafio.Aceptado;
import ar.edu.unq.po2.EstadoDesafio.Completado;
import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.Proyecto.Proyecto;

public class Usuario {
	
	private String nombre;
	private PreferenciaUsuario preferenciaUsuario;
	private RecomendadorDeLudificacion recomendador;	// FS: Cambiada la referencia, referenciaba incorrectamente la interfaz y no la clase.
	
	private double recompensasAcumuladas;			 // FS: Las ganancias acumuladas que obtuvo por completar desafios.
	private ArrayList<Proyecto> proyectos;
	
	private ArrayList<DesafioDeUsuario>	desafiosDisponibles;	// FS: No aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosAceptados;		// FS: Aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosCompletados;	// FS: Completados.
	
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.preferenciaUsuario = new PreferenciaUsuario(0,0,0);
		this.recomendador = new RecomendadorDeLudificacion(this.desafiosCompletados, this.preferenciaUsuario);
		this.recompensasAcumuladas = 0;
		this.proyectos = new ArrayList<Proyecto>();
		this.desafiosDisponibles = new ArrayList<DesafioDeUsuario>();
		this.desafiosAceptados 	= new ArrayList<DesafioDeUsuario>();
		this.desafiosCompletados= new ArrayList<DesafioDeUsuario>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}


	public void suscribirseAProyecto(Proyecto proyecto) {
		proyectos.add(proyecto);
		proyecto.agregarParticipante(this);
	}
	
	public void recolectarMuestra(Muestra muestra, Proyecto proyecto) {
		proyecto.agregarMuestra(muestra); 	// FS: Agregar la muestra al proyecto.
		/*
		for (DesafioDeUsuario desafioDeUsuario : desafiosAceptados) {
			desafioDeUsuario.va
		}
		*/
	}
	
	
	
	// FS: Métodos aceptar y completar desafío.
	public void aceptarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		// FS: Precondición: el desafio de usuario debe estar disponible para el usuario.
		desafiosDisponibles.remove(desafioDeUsuario);
		this.desafiosAceptados.add(desafioDeUsuario);
		desafioDeUsuario.getEstado().aceptar();		// FS: Setea instancia ACEPTADO en DesafioDeUsuario.
	}
	
	
	public void completarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario,int valorVoto) {
		// FS: Precondición: el desafio de usuario debe haber sido previamente aceptado.
		this.desafiosAceptados.remove(desafioDeUsuario);
		this.desafiosCompletados.add(desafioDeUsuario);
		desafioDeUsuario.getEstado().completar();
		this.recompensasAcumuladas += desafioDeUsuario.getDesafio().getRecompensa();	// FS: Otorga recompensa.
		this.votar(desafioDeUsuario,valorVoto);	// El usuario debe elegir el voto.
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



	public ArrayList<DesafioDeUsuario> getDesafiosDisponibles() {
		return desafiosDisponibles;
	}


	public ArrayList<DesafioDeUsuario> getDesafiosAceptados() {
		return desafiosAceptados;
	}


	public ArrayList<DesafioDeUsuario> getDesafiosCompletados() {
		return desafiosCompletados;
	}
		
	public void votar(DesafioDeUsuario desafioDeUsuario,int valorDeVoto) {
		desafioDeUsuario.setVoto(valorDeVoto);
	}
	
	//Metodos para ajustar y solicitar la recomendacion de desafios.
	
	public void cambiarEstrategiaDeRecomendadorDeDesafio(EstrategiaDeRecomendacion estrategia) {
		this.recomendador.cambiarEstrategiaDeRecomendacion(estrategia);
	}
	
	public void recomendarmeDesafio() {
		ArrayList<DesafioDeUsuario> desafiosRecomendados = this.recomendador.recomendarDesafios();
	}
	
	/* REALIZADO ANTERIORMENTE
		
	
	
	public int porcentajeDeCompletitud(DesafioDeUsuario desafio) {
		return desafio.porcentajeDeCompletitud();
	}
	
	
	*/
}
