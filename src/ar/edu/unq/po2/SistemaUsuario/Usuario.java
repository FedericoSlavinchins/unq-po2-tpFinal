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
		//this.setRecomendadorDeLudificacion();
		this.recompensasAcumuladas = 0;
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
		proyecto.agregarMuestra(muestra); 	// FS: Agregar la muestra al proyecto.
		contabilizarMuestraParaDesafiosAceptados(muestra);
	}


	private void contabilizarMuestraParaDesafiosAceptados(Muestra muestra) {
		for (DesafioDeUsuario desafioDeUsuario : this.desafiosAceptados) {
			if (desafioDeUsuario.getValidadorDeMuestra().esMuestraValida(muestra)) {
				// FS: Contabiliza la muestra solo para los desafios aceptados y sin completar, y si es una muestra válida para el desafio.
				desafioDeUsuario.getMuestrasRecolectadas().add(muestra);
			}
		}
	}
	
	
	
	// FS: Métodos aceptar y completar desafío.
	public void aceptarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) {
		
		desafioDeUsuario.serAceptado();	// FS: Setea instancia ACEPTADO en DesafioDeUsuario.
		// FS: Precondición: el desafio de usuario debe estar disponible para el usuario.
		desafiosDisponibles.remove(desafioDeUsuario);
		this.desafiosAceptados.add(desafioDeUsuario);
		
	}
	
	
	
	public void completarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario,int valorVoto) {
		// FS: Precondición: el desafio de usuario debe haber sido previamente aceptado.
		if (this.completoDesafio(desafioDeUsuario)) {
			this.desafiosAceptados.remove(desafioDeUsuario);
			desafioDeUsuario.getEstado().actualizarEstado(desafioDeUsuario);
			//Cambio de estado, deberia pasar de Aceptado a Completado.
			this.desafiosCompletados.add(desafioDeUsuario);
			this.recompensasAcumuladas += desafioDeUsuario.getDesafio().getRecompensa();	// FS: Otorga recompensa.
			this.votar(desafioDeUsuario,valorVoto);	// El usuario debe elegir el voto.
		} else {
			System.out.println("El desafio no está completo. Debés recolectar mas muestras!");
		}
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
		return (desafioDeUsuario.porcentajeDeCompletitud() == 100);	
	}

	//Devuelve el porcentaje de completitud del desafio en cuestion
	public int porcentajeDeCompletitud(DesafioDeUsuario desafio) {
		return desafio.porcentajeDeCompletitud();
	}
	
	public int porcentajeDeCompletitudGeneral() {			// FS: Entre desafios aceptados.
		int resultado = 0; 
		for (DesafioDeUsuario desafioDeUsuario : this.desafiosAceptados) {
			resultado += this.porcentajeDeCompletitud(desafioDeUsuario);
		}
		return ((resultado + (this.desafiosCompletados.size() * 100))) 
				/ 
				(this.desafiosAceptados.size() + this.desafiosCompletados.size());
	}



	public ArrayList<DesafioDeUsuario> getDesafiosDisponibles() {
		return desafiosDisponibles;
	}
	public void agregarDesafiosDisponibles(DesafioDeUsuario desafioUsuario) {
		 desafiosDisponibles.add(desafioUsuario);
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
	
	public PreferenciaUsuario getPreferenciaUsuario() {
		return this.preferenciaUsuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public RecomendadorDeLudificacion getRecomendador() {
		return this.recomendador;
	}
	
	public void setRecomendadorDeLudificacion() {
		ArrayList<DesafioDeUsuario> todosMisDesafios = new ArrayList<DesafioDeUsuario>();
		todosMisDesafios.addAll(desafiosAceptados);
		todosMisDesafios.addAll(desafiosCompletados);
		recomendador = new RecomendadorDeLudificacion(todosMisDesafios, preferenciaUsuario);
		System.out.println("Su recomendador en uso actual se guia por sus preferencias.");
	}
	
	public void recomendarmeDesafios() {
		this.recomendador.recomendarDesafios(this.desafiosDeMisProyectos());
	}

	public ArrayList<Desafio> desafiosDeMisProyectos() {
        ArrayList<Desafio> desafiosDeProyectos = new ArrayList<Desafio>();
        for (Proyecto proyecto : proyectos) {
            desafiosDeProyectos.addAll(proyecto.getDesafios());
        }
        return desafiosDeProyectos;
    }
	
	public void cambiarEstrategiaDeRecomendacion(EstrategiaDeRecomendacion estrategia) {
		this.recomendador.cambiarEstrategiaDeRecomendacion(estrategia);
	}
	
	
}
	
	
	
	

