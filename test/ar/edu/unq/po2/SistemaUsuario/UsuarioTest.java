package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Geocoordenada;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.Proyecto.Proyecto;

class UsuarioTest {
	
	private Usuario usuario;
	private DesafioDeUsuario desafioDeUsuario;
	private Desafio desafio;
	private Proyecto proyecto;
	private ArrayList<Categoria> listaDeCategorias;
	private Categoria categoria;
	private Muestra muestra;
	private Geocoordenada geocoordenada;
	
	@BeforeEach
	public void setUp() {
		desafio = new Desafio();
		desafioDeUsuario = new DesafioDeUsuario(desafio);
		usuario = new Usuario("nombreUsuario");
		geocoordenada = new Geocoordenada();
		muestra = new Muestra(usuario, geocoordenada);
		listaDeCategorias = new ArrayList<Categoria>();
		categoria = new Categoria("Biología");
		listaDeCategorias.add(categoria);
		proyecto = new Proyecto("proyecto", "descripcion", listaDeCategorias);
	}

	@Test
	void cuandoElUsuarioSeSuscribePasaAFormarParteDeLosProyectosEnLosQueParticipa() {
		usuario.suscribirseAProyecto(proyecto);
		assertTrue(usuario.getProyectos().contains(proyecto));
	}
	
	@Test
	void cuandoElUsuarioRecolectaUnaMuestraSeGuardaEnSuVariableMuestras() {
		usuario.recolectarMuestra(muestra, proyecto);
		assertTrue(usuario.getMuestrasSubidas().contains(muestra));
	}
	
	@Test
	void cuandoElUsuarioAceptaUnDesafioDeUsuarioElMismoSeGuardaEnSuListaDeDesafiosAceptados() {
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		assertTrue(usuario.getDesafiosAceptados().contains(desafioDeUsuario));
		assertFalse(usuario.getDesafiosDisponibles().contains(desafioDeUsuario));
	}
	
	@Test
	void cuandoElUsuarioCompletaUnDesafioDeUsuarioElMismoSeGuardaEnSuListaDeDesafiosCompletadosYDesapareceDeAceptados() {
		usuario.completarDesafioDeUsuario(desafioDeUsuario);
		assertTrue(usuario.getDesafiosCompletados().contains(desafioDeUsuario));
		assertFalse(usuario.getDesafiosAceptados().contains(desafioDeUsuario));
	}

}
