/**
 * Prueba unitaria para los algoritmos de ordenamiento
 */
package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Ordenamiento;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioHombre;

/**
 * @author Andres.Martinez
 *
 */
public class OrdenamientoTestCase {
	private static Ordenamiento order;
	private static ArrayList<Usuario> lista;
	private static final double DELTA = 1e-15;
	private static Usuario usuario1;
	private static Usuario usuario2;
	private static Usuario usuario3;
	private static Usuario usuario4;
	private static Usuario usuario5;
	private static Usuario usuario6;
	private static Usuario usuario7;
	private static Usuario usuario8;
	private static Usuario usuario9;
	private static Usuario usuario10;
	private static Usuario usuario11;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void innit() throws Exception {
		order = new Ordenamiento();
		lista = new ArrayList<>();
		usuario1 = new UsuarioHombre("Belisario", "Hernandez", "Apellido2", "H", "mmartinezg", "Test123*",
				"test@test.com", "31/05/1996", 26, 0, true, 30);
		usuario2 = new UsuarioHombre("Andres", "Caceres", "Apellido2", "H", "andros", "Test123*", "test@test.com",
				"31/05/1996", 40, 0, true, 70);
		usuario3 = new UsuarioHombre("Camilo", "Yepes", "Apellido2", "H", "Tester", "Test123*", "test@test.com",
				"31/05/1996", 18, 0, true, 500);
		usuario4 = new UsuarioHombre("Jorge", "Serrano", "Apellido2", "H", "jdserrano", "Test123*", "test@test.com",
				"31/05/1996", 26, 0, true, 50);
		usuario5 = new UsuarioHombre("Pedro", "Sanchez", "Apellido2", "H", "psanchez", "Test123*", "test@test.com",
				"31/05/1996", 41, 0, true, 550);
		usuario6 = new UsuarioHombre("Luis", "Diaz", "Apellido2", "H", "ldiaz", "Test123*", "test@test.com",
				"31/05/1996", 17, 0, true, 100);
		usuario7 = new UsuarioHombre("Mario", "Zapata", "Apellido2", "H", "rocka", "Test123*", "test@test.com",
				"31/05/1996", 26, 0, true, 244.85);
		usuario8 = new UsuarioHombre("Miguel", "Fernandez", "Apellido2", "H", "mfernandez", "Test123*", "test@test.com",
				"31/05/1996", 30, 0, true, 10);
		usuario9 = new UsuarioHombre("Fernando", "Rodriguez", "Apellido2", "H", "frodriguez", "Test123*",
				"test@test.com", "31/05/1996", 20, 0, true, 0);
		usuario10 = new UsuarioHombre("Carlos", "Murcia", "Apellido2", "H", "cmurcia", "Test123*", "test@test.com",
				"31/05/1996", 21, 0, true, 70000);
		usuario11 = new UsuarioHombre("Ezequiel", "Gonzalez", "Apellido2", "H", "egonzalez", "Test123*",
				"test@test.com", "31/05/1996", 27, 0, true, 80000);

		usuario1.setLikesRecibidos(2);
		usuario2.setLikesRecibidos(34);
		usuario3.setLikesRecibidos(2000);
		usuario4.setLikesRecibidos(50);
		usuario5.setLikesRecibidos(8);
		usuario6.setLikesRecibidos(45);
		usuario7.setLikesRecibidos(3);
		usuario8.setLikesRecibidos(17);
		usuario9.setLikesRecibidos(64);
		usuario10.setLikesRecibidos(70000);
		usuario11.setLikesRecibidos(5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		lista.add(usuario1);
		lista.add(usuario2);
		lista.add(usuario3);
		lista.add(usuario4);
		lista.add(usuario5);
		lista.add(usuario6);
		lista.add(usuario7);
		lista.add(usuario8);
		lista.add(usuario9);
		lista.add(usuario10);
		lista.add(usuario11);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		lista.clear();
	}

	@Test
	public void testOrdenarUsuariosPorNombreAsc() {
		order.ordenarPorNombreAsc(lista);
		assertEquals("El primer usuario por nombre debe ser Andres.", "Andres", lista.get(0).getNombre());
		assertEquals("El segundo usuario por nombre debe ser Belisario.", "Belisario", lista.get(1).getNombre());
		assertEquals("El tercer usuario por nombre debe ser Camilo.", "Camilo", lista.get(2).getNombre());
	}

	@Test
	public void testOrdenarUsuariosPorNombreDesc() {
		order.ordenarPorNombreDesc(lista);
		assertEquals("El primer usuario por nombre debe ser Pedro.", "Pedro", lista.get(0).getNombre());
		assertEquals("El segundo usuario por nombre debe ser Miguel.", "Miguel", lista.get(1).getNombre());
		assertEquals("El tercer usuario por nombre debe ser Mario.", "Mario", lista.get(2).getNombre());
	}

	@Test
	public void testOrdenarUsuariosPorApellidoAsc() {
		order.ordenarPorApellidoAsc(lista);
		assertEquals("El primer usuario por apellido debe ser Caceres.", "Caceres", lista.get(0).getApellido1());
		assertEquals("El segundo usuario por apellido debe ser Diaz.", "Diaz", lista.get(1).getApellido1());
		assertEquals("El tercer usuario por apellido debe ser Fernandez.", "Fernandez", lista.get(2).getApellido1());
	}

	@Test
	public void testOrdenarUsuariosPorApellidoDesc() {
		order.ordenarPorApellidoDesc(lista);
		assertEquals("El primer usuario por apellido debe ser Zapata.", "Zapata", lista.get(0).getApellido1());
		assertEquals("El segundo usuario por apellido debe ser Yepes.", "Yepes", lista.get(1).getApellido1());
		assertEquals("El tercer usuario por apellido debe ser Serrano.", "Serrano", lista.get(2).getApellido1());
	}

	@Test
	public void testOrdenarUsuariosPorAliasAsc() {
		order.ordenarPorAliasAsc(lista);
		assertEquals("El primer usuario por alias debe ser andros.", "andros", lista.get(0).getUsuario());
		assertEquals("El segundo usuario por alias debe ser cmurcia.", "cmurcia", lista.get(1).getUsuario());
		assertEquals("El tercer usuario por alias debe ser egonzalez.", "egonzalez", lista.get(2).getUsuario());
	}

	@Test
	public void testOrdenarUsuariosPorAliasDesc() {
		order.ordenarPorAliasDesc(lista);
		assertEquals("El primer usuario por alias debe ser Tester.", "Tester", lista.get(0).getUsuario());
		assertEquals("El segundo usuario por alias debe ser rocka.", "rocka", lista.get(1).getUsuario());
		assertEquals("El tercer usuario por alias debe ser psanchez.", "psanchez", lista.get(2).getUsuario());
	}

	@Test
	public void testOrdenarUsuariosPorEdadAsc() {
		order.ordenarPorEdadAsc(lista);
		assertEquals("El primer usuario por edad debe ser 17.", 17, lista.get(0).getEdad());
		assertEquals("El segundo usuario por edad debe ser 18.", 18, lista.get(1).getEdad());
		assertEquals("El tercer usuario por edad debe ser 20.", 20, lista.get(2).getEdad());
	}

	@Test
	public void testOrdenarUsuariosPorEdadDesc() {
		order.ordenarPorEdadDesc(lista);
		assertEquals("El primer usuario por edad debe ser 41.", 41, lista.get(0).getEdad());
		assertEquals("El segundo usuario por edad debe ser 40.", 40, lista.get(1).getEdad());
		assertEquals("El tercer usuario por edad debe ser 30.", 30, lista.get(2).getEdad());
	}

	@Test
	public void testOrdenarUsuariosPorLikesAsc() {
		order.ordenarPorLikesAsc(lista);
		assertEquals("El primer usuario por likes recibidos debe ser 2.", 2, lista.get(0).getLikesRecibidos());
		assertEquals("El segundo usuario por likes recibidos debe ser 3.", 3, lista.get(1).getLikesRecibidos());
		assertEquals("El tercer usuario por likes recibidosdebe ser 5.", 5, lista.get(2).getLikesRecibidos());
	}

	@Test
	public void testOrdenarUsuariosPorLikesDesc() {
		order.ordenarPorLikesDesc(lista);
		assertEquals("El primer usuario por likes recibidos debe ser 70000.", 70000, lista.get(0).getLikesRecibidos());
		assertEquals("El segundo usuario por likes recibidos debe ser 2000.", 2000, lista.get(1).getLikesRecibidos());
		assertEquals("El tercer usuario por likes recibidos debe ser 64.", 64, lista.get(2).getLikesRecibidos());
	}

	@Test
	public void testFiltrarUsuariosPorLikes() {
		ArrayList<Usuario> listaPorLikes = order.filtradoPorLikes(lista);
		assertEquals("El primer usuario por likes recibidos debe ser 70000.", 70000,
				listaPorLikes.get(0).getLikesRecibidos());
		assertEquals("El el tamaño de la lista debe ser 10.", 10, listaPorLikes.size());
	}

	@Test
	public void testFiltrarUsuariosPorIngresos() {
		ArrayList<UsuarioHombre> listaPorIngresos = order.filtradoPorIngresos(lista);
		
		assertEquals("El primer usuario por ingresos debe ser 80000.", 80000.0,
				listaPorIngresos.get(0).getIngresosMensuales(), DELTA);
		assertEquals("El ultimo usuario por ingresos debe ser 244.85.", 244.85,
				listaPorIngresos.get(listaPorIngresos.size() - 1).getIngresosMensuales(), DELTA);
	}
}
