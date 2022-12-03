package ar.edu.unq.po2.EstadoDesafio;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.Desafios.OtorgadorDeRecompensa;
import ar.edu.unq.po2.Desafios.RestriccionDeDiasDeSemana;
import ar.edu.unq.po2.Proyecto.AreaGeografica;
import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.Proyecto.Proyecto;
import ar.edu.unq.po2.Proyecto.Ubicacion;
import ar.edu.unq.po2.SistemaUsuario.Usuario;
import net.bytebuddy.implementation.ExceptionMethod;

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
	private OtorgadorDeRecompensa otorgadorDeRecompensa;
	private Completado estadoCompletado;
	
	@BeforeEach
	void setUp() throws Exception {
		restriccionDeDiasDeSemana = new RestriccionDeDiasDeSemana();
		categoria = new Categoria("Biología");
		listaCategorias = new ArrayList<Categoria>();
		listaCategorias.add(categoria);
		area = new AreaGeografica(500, 500, 500);
		desafio = new Desafio(area, 1, 3, restriccionDeDiasDeSemana, 1000);
		//desafioUsuario = new DesafioDeUsuario(desafio, usuario);
		desafioUsuario = mock(DesafioDeUsuario.class);
		aceptado = new Aceptado();
		desafioUsuario.setEstado(aceptado);
		usuario = new Usuario("pepe");
		//usuario = mock(Usuario.class);
		//usuario.agregarDesafiosDisponibles(desafioUsuario);
		fechaEsperada = LocalDate.now();
		proyecto = new Proyecto("proyecto", "descripcion", listaCategorias);
		muestra = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		otorgadorDeRecompensa = mock(OtorgadorDeRecompensa.class);
		estadoCompletado = mock(Completado.class);
	}
	
	/*
	@Test // FS: VERIFICAR: Es necesario este test?
	void testComprobarQueElEstadoEsAceptado() {
		assertEquals(aceptado, desafioUsuario.getEstado());
	}
	 */
	@Test
	void testCompletarDesafio() throws Exception {
		
		when(desafioUsuario.getOtorgadorDeRecompensa()).thenReturn(otorgadorDeRecompensa);
		when(desafioUsuario.porcentajeDeCompletitud()).thenReturn(100);
		this.aceptado.actualizarEstado(desafioUsuario);
		
		
		
		verify(desafioUsuario).setFechaCompletado();
		verify(otorgadorDeRecompensa).otorgarRecompensa();
		verify(desafioUsuario).porcentajeDeCompletitud();
		
	}
	
	@Test
	void testNoEstaListoParaCompletarDesafio() throws Exception {
		
		String mensajeDeExceptionEsperado = "El desafio de usuario no está listo para ser completado. Aún te faltan recolectar muestras!";
		
		when(desafioUsuario.getOtorgadorDeRecompensa()).thenReturn(otorgadorDeRecompensa);
		
		verify(desafioUsuario, never()).setFechaCompletado();
		verify(otorgadorDeRecompensa, never()).otorgarRecompensa();
		
		Exception exception = assertThrows(Exception.class,
	            () -> {this.aceptado.actualizarEstado(desafioUsuario);} );
		
		assertEquals(mensajeDeExceptionEsperado, exception.getMessage());
		
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