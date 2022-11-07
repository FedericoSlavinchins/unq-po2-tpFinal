package ar.edu.unq.po2.Proyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.SistemaUsuario.Usuario;
import static org.mockito.Mockito.*;

class ProyectoTest {
	
	private Proyecto proyecto; //SUC
	private ArrayList<Categoria> listaDeCategorias; 
	private Categoria categoria; //DOC
	private Muestra muestra; //DOC
	private Usuario usuario; //DOC
	private Desafio desafio; //DOC
	
	
	@BeforeEach
	public void setUp() {
		desafio = mock(Desafio.class);
		usuario = mock(Usuario.class);
		muestra = mock(Muestra.class);
		listaDeCategorias = new ArrayList<Categoria>();
		categoria = mock(Categoria.class);
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
		nombresDeCategoriaEsperados.add(categoria.getNombre());
		
		
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
	
	@Test
	void cuandoSeAgregaUnDesafioElMismoPasaAFormarParteDelProyecto() {
		proyecto.agregarDesafio(desafio);
		assertTrue(proyecto.getDesafios().contains(desafio));
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