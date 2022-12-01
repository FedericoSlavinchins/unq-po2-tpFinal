package ar.edu.unq.po2.EstadoDesafio;

import java.time.LocalDate;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class Aceptado implements EstadoDesafio {
	

	@Override
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) throws Exception {
		if (desafioDeUsuario.porcentajeDeCompletitud() == 100) {
			desafioDeUsuario.setFechaCompletado();
			desafioDeUsuario.setEstado(new Completado()); // Settea estado completado
		} else {
			throw new Exception("El desafio de usuario no está listo para ser completado. Aún te faltan recolectar muestras!");
		}
	}
	
}

