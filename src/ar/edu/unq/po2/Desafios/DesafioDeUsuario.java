package ar.edu.unq.po2.Desafios;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.EstadoDesafio.EstadoDesafio;
import ar.edu.unq.po2.EstadoDesafio.NoAceptado;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.SistemaUsuario.Usuario;


public class DesafioDeUsuario {
	
	// FS: Esta clase permite trackear al Desafio.
	// FS: Realiza un seguimiento del progreso del usuario en el Desafio.
	
	private Desafio desafio;
	private Usuario usuario;
	private ArrayList<Muestra> muestrasRecolectadas = new ArrayList<Muestra>(); // Muestras recolectadas para el desafio.
	private LocalDate fechaAceptado;
	private LocalDate fechaCompletado;
	private EstadoDesafio estado;			//FS: El estado debe estar en esta clase, ya que es parte del progreso del usuario.	
	private Voto voto;
	private ValidadorDeMuestra validadorDeMuestra = new ValidadorDeMuestra(this);
	private OtorgadorDeRecompensa otorgadorDeRecompensas;


	public DesafioDeUsuario(Desafio desafio, Usuario usuario) {
		this.desafio = desafio;
		this.estado  = new NoAceptado();
		this.otorgadorDeRecompensas = new OtorgadorDeRecompensa(this.desafio.getRecompensa());
		this.otorgadorDeRecompensas.setUsuarioARecompensar(usuario);
	}
	
	// FS: Métodos aceptar y completar desafío.
	public void aceptarDesafioDeUsuario() throws Exception {
		this.actualizarse();
		this.usuario.getMenuDeDesafios().moverDesafioAAceptados(this);
	}
		
	public void completarDesafioDeUsuario(int valorVoto) throws Exception {
		this.actualizarse();
		this.usuario.getMenuDeDesafios().moverDesafioACompletados(this);
		this.usuario.getValoradorDeDesafios().votar(this, valorVoto);	// El usuario debe elegir el voto.
	}
	//
	
	public OtorgadorDeRecompensa getOtorgadorDeRecompensa() {
		return this.otorgadorDeRecompensas;
	}
	

	public EstadoDesafio getEstado() {
			return estado;
	}
		
	
	public void setEstado(EstadoDesafio estado) {
		this.estado = estado;
	}
	
	
	
	public void actualizarse() throws Exception {
		this.actualizarEstado();
	}

	private void actualizarEstado() throws Exception {
		this.getEstado().actualizarEstado(this);
	}
		
	public int cantidadMuestrasRecolectadasParaEsteDesafio() {
		return this.muestrasRecolectadas.size();
	}
	
	
	
	public void setFechaCompletado() {
		this.fechaCompletado = LocalDate.now();
	}
	
	

	public LocalDate getFechaCompletado() {
		return this.fechaCompletado;
	}
	
	
	
	public ArrayList<Muestra> getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}


	public int porcentajeDeCompletitud() {	// FS: Este método nos lleva a no tener la necesidad de tener una variable porcentajeCompletitud, por lo tanto la borro.
		return ((this.cantidadMuestrasRecolectadasParaEsteDesafio() * 100) / this.desafio.getCantidadObjetivoDeMuestras()) ;
	}



	public void setFechaAceptado() {
		this.fechaAceptado = LocalDate.now();
	}
	
	public LocalDate getFechaAceptado() {
		return fechaAceptado;
	}
	
	public Desafio getDesafio() {
		return this.desafio;
	}
	
	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public ValidadorDeMuestra getValidadorDeMuestra() {
		return validadorDeMuestra;
	}

	public Voto getVoto() {
		return this.voto;
	}
}
