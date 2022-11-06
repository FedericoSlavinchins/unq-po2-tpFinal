package ar.edu.unq.po2.Desafios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.EstadoDesafio.Aceptado;
import ar.edu.unq.po2.EstadoDesafio.Completado;
import ar.edu.unq.po2.Proyecto.AreaGeografica;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.Proyecto.Ubicacion;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

class DesafioDeUsuarioTest {

	DesafioDeUsuario desafioUsuario;
	Usuario usuario;
	Desafio desafio;
	Aceptado estadoAceptado;
	Completado estadoCompletado;
	Muestra muestra;
	ArrayList<Muestra> muestras;
	Ubicacion coordenada;
	RestriccionTemporal restriccion;
	AreaGeografica area;
	
	@BeforeEach
	void setUp() throws Exception {
		
		coordenada = new Ubicacion(0, 0);
		usuario = new Usuario("nombreUsuario");
		desafio = new Desafio();
		estadoAceptado = new Aceptado();
		estadoCompletado = new Completado();
		desafioUsuario = new DesafioDeUsuario(desafio);
		muestra = muestra = new Muestra(usuario, coordenada);
	}
	
	@Test
	void testgetDesafio() {
		assertEquals(desafioUsuario.getDesafio(), desafio);
	}
	@Test
	void testget() {
		
	}
	
}
