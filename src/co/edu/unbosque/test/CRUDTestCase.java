/**
 * Prueba unitaria para las funcionalidades del CRUD
 */
package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDAO_Impl;
import co.edu.unbosque.model.UsuarioHombre;

/**
 * @author Andres.Martinez
 *
 */
public class CRUDTestCase {
	private UsuarioDAO_Impl dao;
	private Usuario usuarioTest;
	private ArrayList<Usuario> lista;

	@Before
	public void setUp() throws Exception {
		dao = new UsuarioDAO_Impl();
		usuarioTest = new UsuarioHombre("Usuario test", "Apellido1", "Apellido2", "H", "TestUser", "Test123*",
				"test@test.com", "31/05/1996", 26, 150, true, 500);
		lista = new ArrayList<>();
	}

	@After
	public void resetTestCase() {
		lista.clear();
	}

	@Test
	public void testInsertarUsuario() {
		boolean insertaUsuario = dao.insertarUsuario(lista, usuarioTest);
		assertEquals("Debe insertar el usuario a la lista", true, insertaUsuario);

	}

	@Test
	public void testConsultarUsuario() {
		lista.add(usuarioTest);
		Usuario usuarioEncontrado = dao.consultarUsuario(lista, "Usuario test");
		assertEquals("Debe encontrar el usuario en la lista por su nombre.", usuarioTest, usuarioEncontrado);

	}

	@Test
	public void testLeerUsuario() {
		int tamanoLista = lista.size();
		assertEquals("El tamaño de la lista vacía debe ser 0.", 0, tamanoLista);
		lista.add(usuarioTest);
		tamanoLista = lista.size();
		assertEquals("Debe encontrar el usuario en la lista por su nombre.", 1, tamanoLista);

	}

	@Test
	public void testEliminarUsuario() {
		lista.add(usuarioTest);
		boolean eliminaUsuario = dao.eliminarUsuario(lista, usuarioTest);
		assertEquals("Debe eliminar el usuario respectivo.", true, eliminaUsuario);

	}

	@Test
	public void testEliminarUsuarioPorNombre() {
		lista.add(usuarioTest);
		boolean eliminaUsuario = dao.eliminarUsuarioPorNombre(lista, "Usuario test");
		assertEquals("Debe eliminar el usuario respectivo por nombre.", true, eliminaUsuario);

	}

	@Test
	public void testModificarUsuario() {
		Usuario usuario1 = new UsuarioHombre("Usuario test", "Apellido1", "Apellido2", "H", "TestUser", "Test123*",
				"cambiocorreo@test.com", "31/05/1996", 26, 170, true, 500);
		lista.add(usuarioTest);
		boolean modificaUsuario = dao.modificarUsuario(lista, usuario1);
		assertEquals("Debe modificar el usuario respectivo por nombre.", true, modificaUsuario);

	}
}
