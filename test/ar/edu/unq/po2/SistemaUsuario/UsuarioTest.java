package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;
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
		restriccionEntreFechas = new RestriccionDeEntreFechasSimple(LocalDate.of(2022, 10, 10), LocalDate.of(2023, 10, 10));
		area = new AreaGeografica(500, 500, 500);
		desafio = new Desafio(area, 1, 1, restriccionEntreFechas, 20000);
		desafio2 = new Desafio(area, 1, 1, restriccionEntreFechas, 20000);
		desafioDeUsuario = new DesafioDeUsuario(desafio, usuario);
		desafioDeUsuario2 = new DesafioDeUsuario(desafio2, usuario);
		usuario = new Usuario("nombreUsuario");
		geocoordenada = new Ubicacion(500, 500);
		muestra = new Muestra(usuario, geocoordenada);
		muestra2 = new Muestra(usuario, geocoordenada);
		listaDeCategorias = new ArrayList<Categoria>();
		categoria = new Categoria("Biología");
		listaDeCategorias.add(categoria);
		proyecto = new Proyecto("proyecto", "descripcion", listaDeCategorias);
	}
	
	/* BORRAR TEST
	@Test
	void cuandoElUsuarioAceptaUnDesafioDeUsuarioElMismoSeGuardaEnSuListaDeDesafiosAceptados() {
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		assertTrue(usuario.getDesafiosAceptados().contains(desafioDeUsuario));
		assertFalse(usuario.getDesafiosDisponibles().contains(desafioDeUsuario));
	}*/
	
	/* BORRAR TEST
	@Test
	void cuandoElUsuarioCompletaUnDesafioDeUsuarioElMismoSeGuardaEnSuListaDeDesafiosCompletadosYDesapareceDeAceptados() {
		desafio.setCantidadObjetivoDeMuestras(1);
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		usuario.recolectarMuestra(muestra, proyecto);
		usuario.completarDesafioDeUsuario(desafioDeUsuario, 5);
		assertTrue(usuario.getDesafiosCompletados().contains(desafioDeUsuario));
		assertFalse(usuario.getDesafiosAceptados().contains(desafioDeUsuario));
	}*/
	
	/* BORRAR TEST
	@Test
	void cuandoElUsuarioCompletaUnDesafioDeUsuarioElMismoVotaAlUsuario() {
		desafio.setCantidadObjetivoDeMuestras(1);
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		usuario.recolectarMuestra(muestra, proyecto);
		usuario.completarDesafioDeUsuario(desafioDeUsuario, 5);
		boolean resultadoActual = (desafioDeUsuario.getVoto() == 5);
		assertTrue(resultadoActual);
	}*/
	
	@Test
	void cuandoElUsuarioRecolectaUnaMuestraLaMismaFormaParteDelProyecto() {
		usuario.recolectarMuestra(muestra, proyecto);
		assertTrue(proyecto.getMuestras().contains(muestra));
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
		
		List<Desafio> resultadoEsperado = Arrays.asList(desafio, desafio2);
		List<Desafio> resultadoActual = usuario.desafiosDeMisProyectos();
		
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
	
	
	
	/* BORRAR TEST
	@Test
	void siElPorcentajeDeCompletitudGeneralEs100CompletoElDesafio() {
		desafio.setCantidadObjetivoDeMuestras(1);
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		usuario.recolectarMuestra(muestra, proyecto);
		boolean usuarioCompletoDesafio = usuario.completoDesafio(desafioDeUsuario);
		assertTrue(usuarioCompletoDesafio);
	}*/
	
	/* BORRAR TEST
	@Test
	void siElUsuarioRecolectoLaMitadDeLasMuestrasDelDesafioElPorcentajeDeCompletitudEs50() {
		desafio.setCantidadObjetivoDeMuestras(2);
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		usuario.recolectarMuestra(muestra, proyecto);
		int resultadoActual = desafioDeUsuario.porcentajeDeCompletitud();
		int resultadoEsperado = 50;
		assertEquals(resultadoEsperado, resultadoActual);
	}*/
	
	
	/* BORRAR TEST
	@Test
	void siElUsuarioRecolectoLaMitadDeLasMuestrasDeDosDesafiosElPorcentajeDeCompletitudGeneralEs50() {
		desafio.setCantidadObjetivoDeMuestras(2);
		desafio2.setCantidadObjetivoDeMuestras(2);
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario2);
		usuario.recolectarMuestra(muestra, proyecto);
		int resultadoActual = usuario.porcentajeDeCompletitudGeneral();
		int resultadoEsperado = 50;
		assertEquals(resultadoEsperado, resultadoActual);
	}*/
	
	
	
}
