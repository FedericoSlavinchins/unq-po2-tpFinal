package ar.edu.unq.po2.Desafios;

import ar.edu.unq.po2.Proyecto.Muestra;

public class ValidadorDeMuestra {
	
	// Tiene como responsabilidad validar las muestras que el usuario recolecta para un desafio específico.
	
	private DesafioDeUsuario desafioDeUsuario;
	
	
	public ValidadorDeMuestra(DesafioDeUsuario desafioDeUsuario) {
		this.desafioDeUsuario = desafioDeUsuario;
	}
	
	public boolean esMuestraValida(Muestra muestra) {
		return (muestra.getFecha().isEqual(this.desafioDeUsuario.getFechaAceptado()) || muestra.getFecha().isAfter(this.desafioDeUsuario.getFechaAceptado())) //primera parte valida si las muestra es posterior a la fecha de aceptacion
				&& 
				this.desafioDeUsuario.getDesafio().getRestriccionTemporal().cumplioPeriodo(this.desafioDeUsuario.getFechaAceptado()) // segunda parte valida si cumple las restricciones temporales
		        &&  
		        this.desafioDeUsuario.getDesafio().getArea().estaEnRango(muestra.getGeocoordenada());		// Tercer parte valida el area de la muestra
	}
}
