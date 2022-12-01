package ar.edu.unq.po2.Desafios;

import ar.edu.unq.po2.Proyecto.Muestra;

public class ValidadorDeMuestra {
	
	// Tiene como responsabilidad validar las muestras que el usuario recolecta para un desafio específico.
	
	private DesafioDeUsuario desafioDeUsuario;
	
	
	public ValidadorDeMuestra(DesafioDeUsuario desafioDeUsuario) {
		this.desafioDeUsuario = desafioDeUsuario;
	}
	
	public boolean esMuestraValida(Muestra muestra) {
		return laMuestraSeTomoDespuesDeAceptarElDesafio(muestra) //primera parte valida si la muestra se tomó despues de aceptar el desafío. (FS: Ver el tema del horario)
				&& 
				laMuestraCumpleConRestriccionTemporal() // segunda parte valida si cumple las restricciones temporales
		        &&  
		        laMuestraEstaEnRangoSolicitadoPorDesafio(muestra);		// Tercer parte valida el area de la muestra
	}

	private boolean laMuestraCumpleConRestriccionTemporal() {
		return this.desafioDeUsuario.getDesafio().getRestriccionTemporal().cumpleRestriccion(this.desafioDeUsuario.getFechaAceptado());
	}

	private boolean laMuestraEstaEnRangoSolicitadoPorDesafio(Muestra muestra) {
		return this.desafioDeUsuario.getDesafio().getArea().estaEnRango(muestra.getGeocoordenada());
	}

	private boolean laMuestraSeTomoDespuesDeAceptarElDesafio(Muestra muestra) {
		return muestra.getFecha().isEqual(this.desafioDeUsuario.getFechaAceptado()) || muestra.getFecha().isAfter(this.desafioDeUsuario.getFechaAceptado());
	}
}
