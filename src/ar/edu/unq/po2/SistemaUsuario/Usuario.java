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
	
	private MenuDeDesafios menuDeDesafios = new MenuDeDesafios();
	
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.preferenciaUsuario = new PreferenciaUsuario(0,0,0);
		//this.setRecomendadorDeLudificacion();
		this.recompensasAcumuladas = 0;
		this.proyectos = new ArrayList<Proyecto>();
		
		
	}


	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}
	
	
	public void recolectarMuestra(Muestra muestra, Proyecto proyecto) {
		proyecto.agregarMuestra(muestra); 	// FS: Agregar la muestra al proyecto.
		contabilizarMuestraParaDesafiosAceptados(muestra);
	}


	private void contabilizarMuestraParaDesafiosAceptados(Muestra muestra) {
		for (DesafioDeUsuario desafioDeUsuario : this.menuDeDesafios.getDesafiosAceptados()) {
			if (desafioDeUsuario.getValidadorDeMuestra().esMuestraValida(muestra)) {
				// FS: Contabiliza la muestra solo para los desafios aceptados y sin completar, y si es una muestra válida para el desafio.
				desafioDeUsuario.getMuestrasRecolectadas().add(muestra);
			}
		}
	}
	
	
	
	// FS: Métodos aceptar y completar desafío.
	public void aceptarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario) throws Exception {
		desafioDeUsuario.actualizarse();
		this.menuDeDesafios.moverDesafioAAceptados(desafioDeUsuario);
	}
	
	
	
	public void completarDesafioDeUsuario(DesafioDeUsuario desafioDeUsuario,int valorVoto) throws Exception {
		desafioDeUsuario.actualizarse();
		this.menuDeDesafios.moverDesafioACompletados(desafioDeUsuario);
		this.recompensasAcumuladas += desafioDeUsuario.getDesafio().getRecompensa();	// FS: Otorga recompensa.
		this.votar(desafioDeUsuario, valorVoto);	// El usuario debe elegir el voto.
	}
	
	
	
	//FS: Métodos para cambiar preferencias de jugabilidad del usuario.
	
	public void cambiarPreferenciaDeCantidadDeMuestrasARecolectar(int cantidadDeseada) {
		this.preferenciaUsuario.setCantidadDeMuestrasARecolectar(cantidadDeseada);
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
		for (DesafioDeUsuario desafioDeUsuario : this.menuDeDesafios.getDesafiosAceptados()) {
			resultado += this.porcentajeDeCompletitud(desafioDeUsuario);
		}
		return ((resultado + (this.menuDeDesafios.getDesafiosCompletados().size() * 100))) 
				/ 
				(this.menuDeDesafios.getDesafiosAceptados().size() + this.menuDeDesafios.getDesafiosCompletados().size());
	}

		
	public void votar(DesafioDeUsuario desafioDeUsuario,int valorDeVoto) {
		desafioDeUsuario.setVoto(valorDeVoto);
	}
	
	public PreferenciaUsuario getPreferenciaUsuario() {
		return this.preferenciaUsuario;
	}
	
	
	public RecomendadorDeLudificacion getRecomendador() {
		return this.recomendador;
	}
	
	public void setRecomendadorDeLudificacion() {
		ArrayList<DesafioDeUsuario> todosMisDesafios = new ArrayList<DesafioDeUsuario>();
		todosMisDesafios.addAll(this.menuDeDesafios.getDesafiosAceptados());
		todosMisDesafios.addAll(this.menuDeDesafios.getDesafiosCompletados());
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
	
	
	public double getRecompensasAcumuladas() {
		return recompensasAcumuladas;
	}


	public void setRecompensasAcumuladas(double recompensasAcumuladas) {
		this.recompensasAcumuladas = recompensasAcumuladas;
	}
	
}
	
	
	
	

