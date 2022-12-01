/**
 * Inteface que define los metodos del CRUD
 */
package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * @author Andres.Martinez
 *
 */
public interface UsuarioDAO {
	boolean insertarUsuario(ArrayList<Usuario> lista, Usuario u);
	Usuario consultarUsuario(ArrayList<Usuario> lista, String nombre);
	String leerUsuarios(ArrayList<Usuario> lista);
	boolean eliminarUsuario(ArrayList<Usuario> lista, Usuario u);
	boolean eliminarUsuarioPorNombre(ArrayList<Usuario> lista, String nombre);
	boolean modificarUsuario(ArrayList<Usuario> lista, Usuario u);
}
