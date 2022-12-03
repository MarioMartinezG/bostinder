/**
 * Clase que implementa la interface UsuarioDAO
 */
package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * @author Andres.Martinez
 *
 */
public class UsuarioDAO_Impl implements UsuarioDAO {

	/**
	 * Metodo para insertar el usuario al objeto serializable
	 * 
	 * @param lista - ArrayList con los Usuarios
	 * @param u     - Usuario a insertar
	 */
	@Override
	public boolean insertarUsuario(ArrayList<Usuario> lista, Usuario u) {
		try {
			lista.add(u);
			return true;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo para consultar un usuario
	 * 
	 * @param lista         - ArrayList con los Usuarios
	 * @param nombreUsuario - Alias del usuario a buscar
	 */
	@Override
	public Usuario consultarUsuario(ArrayList<Usuario> lista, String nombreUsuario) {
		Usuario x = null;
		for (Usuario usuario : lista) {
			if (usuario.getUsuario().equals(nombreUsuario)) {
				x = usuario;
			}
		}
		return x;
	}

	/**
	 * Metodo para leer Usuarios del ArrayList
	 * 
	 * @param lista - ArrayList con los Usuarios
	 */
	@Override
	public String leerUsuarios(ArrayList<Usuario> lista) {
		String datos = "";
		for (Usuario usuario : lista) {
			datos += usuario.toString() + "\n" + "\n";
		}
		return datos;
	}

	/**
	 * Metodo para eliminar un usuario
	 * 
	 * @param lista - ArrayList con los Usuarios
	 * @param u     - Usuario a eliminar
	 */
	@Override
	public boolean eliminarUsuario(ArrayList<Usuario> lista, Usuario u) {
		try {
			lista.remove(u);
			return true;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo para consultar un usuario
	 * 
	 * @param lista  - ArrayList con los Usuarios
	 * @param nombre - Nombre del usuario a eliminar
	 */
	@Override
	public boolean eliminarUsuarioPorNombre(ArrayList<Usuario> lista, String nombre) {
		for (Usuario usuario : lista) {
			if (usuario.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				lista.remove(usuario);
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo para modificar un usuario
	 * 
	 * @param lista - ArrayList con los Usuarios
	 * @param u     - Usuario a buscar
	 */
	@Override
	public boolean modificarUsuario(ArrayList<Usuario> lista, Usuario u) {
		Usuario u_buscar = consultarUsuario(lista, u.getNombre().toLowerCase());
		if (u_buscar != null) {
			eliminarUsuario(lista, u_buscar);
			insertarUsuario(lista, u);
			return true;
		} else {
			return false;
		}

	}

}