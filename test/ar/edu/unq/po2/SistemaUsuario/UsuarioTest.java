package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.Desafios.RestriccionDeEntreFechasSimple;
import ar.edu.unq.po2.Proyecto.AreaGeografica;
import ar.edu.unq.po2.Proyecto.Categoria;
import ar.edu.unq.po2.Proyecto.Muestra;
import ar.edu.unq.po2.Proyecto.Proyecto;
import ar.edu.unq.po2.Proyecto.Ubicacion;


class UsuarioTest {
	
	private Usuario usuario;
	private DesafioDeUsuario desafioDeUsuario;
	private DesafioDeUsuario desafioDeUsuario2;
	private Desafio desafio;
	private Desafio desafio2;
	private Proyecto proyecto;
	private ArrayList<Categoria> listaDeCategorias;
	private Categoria categoria;
	private Muestra muestra;
	private Muestra muestra2;
	private Ubicacion geocoordenada;
	private RestriccionDeEntreFechasSimple restriccionEntreFechas;
	private AreaGeografica area;
	
	
	@BeforeEach
	public void setUp() {
		restriccionEntreFechas = mock(RestriccionDeEntreFechasSimple.class);
		area = mock(AreaGeografica.class);
		desafio = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafioDeUsuario = mock(DesafioDeUsuario.class);
		desafioDeUsuario2 = mock(DesafioDeUsuario.class);
		usuario = new Usuario("nombreUsuario");
		geocoordenada = mock(Ubicacion.class);;
		muestra = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		listaDeCategorias = new ArrayList<Categoria>();
		categoria = mock(Categoria.class);
		listaDeCategorias.add(categoria);
		proyecto = new Proyecto("a", "a", listaDeCategorias);
	}
	
	
	
	@Test
	void cuandoElUsuarioRecolectaUnaMuestraLaMismaFormaParteDelProyecto() {
		List<Muestra> muestras = Arrays.asList(muestra);
		
		usuario.recolectarMuestra(muestra, proyecto);
		//when(proyecto.getMuestras()).thenReturn(muestras);
		
		assertTrue(proyecto.getMuestras().contains(muestra));
		//verify(proyecto).agregarMuestra(muestra);

	}
	
	@Test
	void cuandoElUsuarioCambiaA5LaPreferenciaDeMuestrasARecolectarSeSeteaElCambioEnSusPreferencias() {
		usuario.cambiarPreferenciaDeCantidadDeMuestrasARecolectar(5);
		int resultadoActual = usuario.getPreferenciaUsuario().getCantidadDeMuestrasARecolectar();
		int resultadoEsperado = 5;
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
	@Test
	void cuandoElUsuarioCambiaA3LaDificultadSeSeteaElCambioEnSusPreferencias() {
		usuario.cambiarPreferenciaDeDificultadPreferida(3);
		int resultadoActual = usuario.getPreferenciaUsuario().getDificultadPreferida();
		int resultadoEsperado = 3;
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
	@Test
	void cuandoElUsuarioCambiaA2000LaPreferenciaDeRecompensaSeSeteaElCambioEnSusPreferencias() {
		usuario.cambiarPreferenciaDeRecompensaPreferida(2000);
		double resultadoActual = usuario.getPreferenciaUsuario().getRecompensaPreferida();
		double resultadoEsperado = 2000;
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
	@Test
	void cuandoElUsuarioSeRegistraSuNombreEsUsuarioNombre() {
		String resultadoActual = usuario.getNombre();
		String resultadoEsperado = "nombreUsuario";
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
	@Test
	void testDesafiosDeProyectosDelUsuario() {
		proyecto.agregarDesafio(desafio);
		proyecto.agregarDesafio(desafio2);
		proyecto.agregarParticipante(usuario);
		
		List<Desafio> desafios = Arrays.asList(desafio, desafio2);
		List<Usuario> usuarios = Arrays.asList(usuario);
		//when(proyecto.getDesafios()).thenReturn(desafios);
		//when(proyecto.getParticipantesActivos()).thenReturn(usuarios);
		
		List<Desafio> resultadoEsperado = Arrays.asList(desafio, desafio2);
		List<Desafio> resultadoActual = usuario.desafiosDeMisProyectos();
		
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
	@Test
	void testSetterRecomendadorDeLudificacion() {
		RecomendadorDeLudificacion recomendador = new RecomendadorDeLudificacion(null, null, null);
		usuario.setRecomendadorDeLudificacion();
		assertEquals(recomendador.getClass() , usuario.getRecomendador().getClass());
	}
	
}
