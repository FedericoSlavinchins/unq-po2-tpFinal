package ar.edu.unq.po2.Proyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.SistemaUsuario.Usuario;

class ProyectoTest {
	
	private Proyecto proyecto;
	private ArrayList<Categoria> listaDeCategorias;
	private Categoria categoria;
	private Muestra muestra;
	private Geocoordenada geocoordenada;
	private Usuario usuario;
	
	
	@BeforeEach
	public void setUp() {
		usuario = new Usuario("nombreUsuario");
		geocoordenada = new Geocoordenada();
		muestra = new Muestra(usuario, geocoordenada);
		listaDeCategorias = new ArrayList<Categoria>();
		categoria = new Categoria("Biología");
		listaDeCategorias.add(categoria);
		proyecto = new Proyecto("proyecto", "descripcion", listaDeCategorias);
	}

	@Test
	void cuandoSeCreaUnProyectoTieneUnNombreDescripcionYCategorias() {
		String nombreEsperado = "proyecto";
		String nombreActual	  = proyecto.getNombre();
		
		String descripcionEsperada = "descripcion";
		String descripcionActual   = proyecto.getDescripcion();
		
		ArrayList<String> nombresDeCategoriaEsperados = new ArrayList<String>();
		nombresDeCategoriaEsperados.add("Biología");
		
		
		assertEquals(nombreEsperado, nombreActual);				// FS: Assert por nombre del proyecto.
		assertEquals(descripcionEsperada, descripcionActual);	// FS: Assert por descripcion del proyecto.
		assertEquals(nombresDeCategoriaEsperados, proyecto.nombresDeCategorias()); // FS: Assert por categoria del proyecto.
	}
	
	
	@Test
	void cuandoSeAgregaUnParticipanteElMismoPasaAFormarParteDelProyecto() {
		proyecto.agregarParticipante(usuario);
		assertTrue(proyecto.getParticipantesActivos().contains(usuario));
	}
	
	@Test
	void cuandoSeAgregaUnaMuestraLaMismaPasaAFormarParteDelProyecto() {
		proyecto.agregarMuestra(muestra);
		assertTrue(proyecto.getMuestras().contains(muestra));
	}
	
	/*
	@Test
	void cuandoSeEnviaElMensajeNombresDeCategoriasRetornaListaDeStringsConAquellosNombres {
		ArrayList<String> nombresDeCategoriaEsperados = new ArrayList<String>();
		nombresDeCategoriaEsperados.add("Biología");
		
		ArrayList<String> resultadoActual = (ArrayList<String>) proyecto.nombresDeCategorias();
		
		assertEquals(nombresDeCategoriaEsperados, resultadoActual);
	}
	*/
}