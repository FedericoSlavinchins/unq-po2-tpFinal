package ar.edu.unq.po2.EstadoDesafio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.BloqueSemanal;
import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.Desafios.RestriccionDeDiasDeSemana;
import ar.edu.unq.po2.Proyecto.AreaGeografica;
import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.Proyecto.Proyecto;
import ar.edu.unq.po2.Proyecto.Ubicacion;
import ar.edu.unq.po2.SistemaUsuario.Usuario;

class AceptadoTest {


	private DesafioDeUsuario desafioUsuario;
	private Desafio desafio;
	private NoAceptado noAceptado;
	private Usuario usuario;
	private LocalDate fechaEsperada;
	private Aceptado aceptado;
	private RestriccionDeDiasDeSemana restriccionDeDiasDeSemana;
	private Muestra	muestra;
	private Muestra	muestra2;
	private AreaGeografica area;
	private Proyecto proyecto;
	private Categoria categoria;
	private ArrayList<Categoria> listaCategorias;
	
	@BeforeEach
	void setUp() throws Exception {
		restriccionDeDiasDeSemana = new RestriccionDeDiasDeSemana();
		categoria = new Categoria("Biología");
		listaCategorias = new ArrayList<Categoria>();
		listaCategorias.add(categoria);
		area = new AreaGeografica(500, 500, 500);
		desafio = new Desafio(area, 1, 3, restriccionDeDiasDeSemana, 1000);
		desafioUsuario = new DesafioDeUsuario(desafio, usuario);
		aceptado = new Aceptado();
		desafioUsuario.setEstado(aceptado);
		usuario = new Usuario("pepe");
		//usuario = mock(Usuario.class);
		//usuario.agregarDesafiosDisponibles(desafioUsuario);
		fechaEsperada = LocalDate.now();
		proyecto = new Proyecto("proyecto", "descripcion", listaCategorias);
		muestra = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
	}

	@Test // FS: VERIFICAR: Es necesario este test?
	void testComprobarQueElEstadoEsAceptado() {
		assertEquals(aceptado, desafioUsuario.getEstado());
	}

	@Test
	void testCompletarDesafio() throws Exception {
		/*desafioUsuario.aceptarDesafioDeUsuario();
		desafioUsuario.completarDesafioDeUsuario(1);
		assertEquals(fechaEsperada,desafioUsuario.getFechaCompletado());
		assertEquals(estadoCompletadoEsperado, desafioUsuario.getEstado());*/
		
		Completado estadoEsperado = new Completado();
		
		when(desafioUsuario.porcentajeDeCompletitud()).thenReturn(100);
		this.aceptado.actualizarEstado(desafioUsuario);
		
		when(desafioUsuario.getEstado()).thenReturn(estadoEsperado);
		
		verify(desafioUsuario).setFechaCompletado();
		verify(desafioUsuario).porcentajeDeCompletitud();
		
		
	}
	
	/*Corresponde a test del valorador de desafios.
	@Test
	void testEmiteVoto() {
		desafio.setCantidadObjetivoDeMuestras(1);
		usuario.aceptarDesafioDeUsuario(desafioUsuario);
		usuario.recolectarMuestra(muestra, proyecto);
		usuario.completarDesafioDeUsuario(desafioUsuario, 1);
		assertEquals(1,desafioUsuario.getVoto());
	
	}*/
	
}