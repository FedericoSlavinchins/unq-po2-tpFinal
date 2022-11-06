package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.BloqueSemanal;
import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
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
	private BloqueSemanal restriccionBloqueSemanal;
	private AreaGeografica area;
	
	
	@BeforeEach
	public void setUp() {
		restriccionBloqueSemanal = new BloqueSemanal(true);
		area = new AreaGeografica(500, 500, 500);
		desafio = new Desafio(area, 1, 1, restriccionBloqueSemanal, 20000);
		desafio2 = new Desafio(area, 1, 1, restriccionBloqueSemanal, 20000);
		desafioDeUsuario = new DesafioDeUsuario(desafio);
		desafioDeUsuario2 = new DesafioDeUsuario(desafio2);
		usuario = new Usuario("nombreUsuario");
		geocoordenada = new Ubicacion(0, 0);
		muestra = new Muestra(usuario, geocoordenada);
		muestra2 = new Muestra(usuario, geocoordenada);
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
	void cuandoElUsuarioAceptaUnDesafioDeUsuarioElMismoSeGuardaEnSuListaDeDesafiosAceptados() {
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		assertTrue(usuario.getDesafiosAceptados().contains(desafioDeUsuario));
		assertFalse(usuario.getDesafiosDisponibles().contains(desafioDeUsuario));
	}
	
	@Test
	void cuandoElUsuarioCompletaUnDesafioDeUsuarioElMismoSeGuardaEnSuListaDeDesafiosCompletadosYDesapareceDeAceptados() {
		desafio.setCantidadObjetivoDeMuestras(1);
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		usuario.recolectarMuestra(muestra, proyecto);
		usuario.completarDesafioDeUsuario(desafioDeUsuario, 5);
		assertTrue(usuario.getDesafiosCompletados().contains(desafioDeUsuario));
		assertFalse(usuario.getDesafiosAceptados().contains(desafioDeUsuario));
	}
	
	@Test
	void cuandoElUsuarioCompletaUnDesafioDeUsuarioElMismoVotaAlUsuario() {
		desafio.setCantidadObjetivoDeMuestras(1);
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		usuario.recolectarMuestra(muestra, proyecto);
		usuario.completarDesafioDeUsuario(desafioDeUsuario, 5);
		boolean resultadoActual = desafioDeUsuario.getVoto() == 5;
		assertTrue(resultadoActual);
	}
	
	@Test
	void cuandoElUsuarioRecolectaUnaMuestraLaMismaFormaParteDelProyecto() {
		usuario.recolectarMuestra(muestra, proyecto);
		assertTrue(proyecto.getMuestras().contains(muestra));
	}
	
	@Test
	void cuandoElUsuarioCambiaA5LaPreferenciaDeMuestrasARecolectarSeSeteaElCambioEnSusPreferencias() {
		usuario.cambiarPreferenciaDeCantidadDeMuestrasARecolectar(5);
		int resultadoActual = usuario.getPreferenciaUsuario().getCantidadDeMestrasARecolectar();
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
	void siElPorcentajeDeCompletitudGeneralEs100CompletoElDesafio() {
		desafio.setCantidadObjetivoDeMuestras(1);
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		usuario.recolectarMuestra(muestra, proyecto);
		boolean usuarioCompletoDesafio = usuario.completoDesafio(desafioDeUsuario);
		assertTrue(usuarioCompletoDesafio);
	}
	
	@Test
	void siElUsuarioRecolectoLaMitadDeLasMuestrasDelDesafioElPorcentajeDeCompletitudEs50() {
		desafio.setCantidadObjetivoDeMuestras(2);
		usuario.aceptarDesafioDeUsuario(desafioDeUsuario);
		usuario.recolectarMuestra(muestra, proyecto);
		int resultadoActual = desafioDeUsuario.porcentajeDeCompletitud();
		int resultadoEsperado = 50;
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
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
	}
	
	@Test
	void cuandoElUsuarioSeRegistraSuNombreEsUsuarioNombre() {
		String resultadoActual = usuario.getNombre();
		String resultadoEsperado = "nombreUsuario";
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
}
