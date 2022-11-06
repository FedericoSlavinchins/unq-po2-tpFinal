package ar.edu.unq.po2.EstadoDesafio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.Desafios.RestriccionTemporal;
import ar.edu.unq.po2.Proyecto.AreaGeografica;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.Proyecto.Ubicacion;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

class NoAceptadoTest {

	Usuario usuario;
	Desafio desafio;
	DesafioDeUsuario desafioUsuario;
	Aceptado desafioAceptado;
	Completado desafioCompletado;
	Muestra muestra;
	ArrayList<Muestra> muestrasAProbar;
	Ubicacion coordenada;
	RestriccionTemporal restriccion;
	AreaGeografica area;

	@BeforeEach
	void setUp() throws Exception {
		desafioAceptado = new Aceptado();

		usuario = new Usuario("nombre");
		desafio = new Desafio();
		desafioUsuario = new DesafioDeUsuario(desafio);
		muestra = new Muestra(usuario, coordenada);
		desafioCompletado = new Completado();
	}

	@Test
	void test() {
		
	
	}

	@Test
	void test1() {
		
	}
}
