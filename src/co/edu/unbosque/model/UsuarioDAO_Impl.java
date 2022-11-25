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

	@Override
	public void insertarUsuario(ArrayList<Usuario> lista, Usuario u) {
		lista.add(u);
	}

	@Override
	public Usuario consultarUsuario(ArrayList<Usuario> lista, String nombre) {
		Usuario x = null;
		for (Usuario usuario : lista) {
			if (usuario.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				x = usuario;
			}
		}
		return x;
	}

	@Override
	public String leerUsuarios(ArrayList<Usuario> lista) {
		String datos = "";
		for (Usuario usuario : lista) {
			datos += usuario.toString() + "\n" + "\n";
		}
		return datos;
	}

	@Override
	public void eliminarUsuario(ArrayList<Usuario> lista, Usuario u) {
		lista.remove(u);
	}

	@Override
	public boolean eliminarUsuarioPorNombre(ArrayList<Usuario> lista, String nombre) {
		for (Usuario usuario: lista) {
			if (usuario.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				lista.remove(usuario);
				return true;
			}
		}
		return false;
	}

	@Override
	public void modificarUsuario(ArrayList<Usuario> lista, Usuario u) {
		Usuario u_buscar= consultarUsuario(lista, u.getNombre().toLowerCase());
		if(u_buscar != null) {
			eliminarUsuario(lista, u_buscar);
			insertarUsuario(lista, u);
		}

	}

}