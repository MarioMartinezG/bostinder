/**
 * Clase que contiene los metodos de ordenamiento y las funciones de filtrado
 */
package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Andres.Martinez
 *
 */
public class Ordenamiento {

	/**
	 * Metodo de ordenamiento ascendente por nombre de usuario (burbuja)
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public void ordenarPorNombreAsc(ArrayList<Usuario> lista) {
		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = 0; j < lista.size() - 1; j++) {
				if (lista.get(j).getNombre().compareToIgnoreCase(lista.get(j + 1).getNombre()) > 0) {
					Usuario aux = lista.get(j);
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, aux);
				}
			}
		}
	}

	/**
	 * Metodo de ordenamiento descendente por nombre de usuario (burbuja)
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public void ordenarPorNombreDesc(ArrayList<Usuario> lista) {
		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = 0; j < lista.size() - 1; j++) {
				if (lista.get(j).getNombre().compareToIgnoreCase(lista.get(j + 1).getNombre()) < 0) {
					Usuario aux = lista.get(j);
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, aux);
				}
			}
		}
	}

	/**
	 * Metodo de ordenamiento ascendente por apellido de usuario (seleccion)
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public void ordenarPorApellidoAsc(ArrayList<Usuario> lista) {
		int i, j, pos;
		Usuario menor, tmp;
		for (i = 0; i < lista.size() - 1; i++) {
			menor = lista.get(i);
			pos = i;
			for (j = i + 1; j < lista.size(); j++) {
				if (lista.get(j).getApellido1().compareToIgnoreCase(menor.getApellido1()) < 0) {
					menor = lista.get(j);
					pos = j;
				}
			}
			if (pos != i) {
				tmp = lista.get(i);
				lista.set(i, lista.get(pos));
				lista.set(pos, tmp);
			}
		}
	}

	/**
	 * Metodo de ordenamiento descendente por apellido de usuario (seleccion)
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public void ordenarPorApellidoDesc(ArrayList<Usuario> lista) {
		int i, j, pos;
		Usuario menor, tmp;
		for (i = 0; i < lista.size() - 1; i++) {
			menor = lista.get(i);
			pos = i;
			for (j = i + 1; j < lista.size(); j++) {
				if (lista.get(j).getApellido1().compareToIgnoreCase(menor.getApellido1()) > 0) {
					menor = lista.get(j);
					pos = j;
				}
			}
			if (pos != i) {
				tmp = lista.get(i);
				lista.set(i, lista.get(pos));
				lista.set(pos, tmp);
			}
		}
	}

	/**
	 * Metodo de ordenamiento ascendente por alias de usuario (burbuja)
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public void ordenarPorAliasAsc(ArrayList<Usuario> lista) {
		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = 0; j < lista.size() - 1; j++) {
				if (lista.get(j).getUsuario().toLowerCase()
						.compareToIgnoreCase(lista.get(j + 1).getUsuario().toLowerCase()) > 0) {
					Usuario aux = lista.get(j);
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, aux);
				}
			}
		}
	}

	/**
	 * Metodo de ordenamiento descendente por alias de usuario (burbuja)
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public void ordenarPorAliasDesc(ArrayList<Usuario> lista) {
		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = 0; j < lista.size() - 1; j++) {
				if (lista.get(j).getUsuario().toLowerCase()
						.compareToIgnoreCase(lista.get(j + 1).getUsuario().toLowerCase()) < 0) {
					Usuario aux = lista.get(j);
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, aux);
				}
			}
		}
	}

	/**
	 * Metodo de ordenamiento ascendente por edad de usuario (burbuja)
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public void ordenarPorEdadAsc(ArrayList<Usuario> lista) {
		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = 0; j < lista.size() - 1; j++) {
				if (lista.get(j).getEdad() > lista.get(j + 1).getEdad()) {
					Usuario aux = lista.get(j);
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, aux);
				}
			}
		}
	}

	/**
	 * Metodo de ordenamiento descendente por edad de usuario (burbuja)
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public void ordenarPorEdadDesc(ArrayList<Usuario> lista) {
		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = 0; j < lista.size() - 1; j++) {
				if (lista.get(j).getEdad() < lista.get(j + 1).getEdad()) {
					Usuario aux = lista.get(j);
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, aux);
				}
			}
		}
	}

	/**
	 * Metodo de ordenamiento ascendente por # de likes de usuario (burbuja)
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public void ordenarPorLikesAsc(ArrayList<Usuario> lista) {
		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = 0; j < lista.size() - 1; j++) {
				if (lista.get(j).getLikesRecibidos() > lista.get(j + 1).getLikesRecibidos()) {
					Usuario aux = lista.get(j);
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, aux);
				}
			}
		}
	}

	/**
	 * Metodo de ordenamiento descendente por # de likes de usuario (burbuja)
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public void ordenarPorLikesDesc(ArrayList<Usuario> lista) {
		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = 0; j < lista.size() - 1; j++) {
				if (lista.get(j).getLikesRecibidos() < lista.get(j + 1).getLikesRecibidos()) {
					Usuario aux = lista.get(j);
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, aux);
				}
			}
		}
	}

	/**
	 * Metodo para ordenar usuarios por ingresos de forma descendente
	 * 
	 * @param listaHombres - Lista de usuarios hombres del sistema
	 *
	 */
	private void ordenarPorIngresosDesc(ArrayList<UsuarioHombre> listaHombres) {
		for (int i = 0; i < listaHombres.size() - 1; i++) {
			for (int j = 0; j < listaHombres.size() - 1; j++) {
				if (listaHombres.get(j).getIngresosMensuales() < listaHombres.get(j + 1).getIngresosMensuales()) {
					UsuarioHombre aux = listaHombres.get(j);
					listaHombres.set(j, listaHombres.get(j + 1));
					listaHombres.set(j + 1, aux);
				}
			}
		}
	}

	/**
	 * Metodo de filtrado para obtener top 10 usuarios con mas likes
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public ArrayList<Usuario> filtradoPorLikes(ArrayList<Usuario> lista) {
		ArrayList<Usuario> aux = lista;
		ordenarPorLikesDesc(aux);
		ArrayList<Usuario> listaPorLikes = new ArrayList<>(aux.subList(0, 10));
		return listaPorLikes;
	}

	/**
	 * Metodo de filtrado para obtener usuarios con ingresos superiores o iguales a
	 * 244.85 USD
	 * 
	 * @param lista - Lista de usuarios del sistema
	 *
	 */
	public ArrayList<UsuarioHombre> filtradoPorIngresos(ArrayList<Usuario> lista) {
		ArrayList<UsuarioHombre> aux = new ArrayList<>();
		ArrayList<UsuarioHombre> listaPorIngresos = new ArrayList<>();

		for (Usuario usuario : lista) {
			if (usuario.getGenero().equals("H")) {
				aux.add((UsuarioHombre) usuario);
			}
		}

		for (UsuarioHombre usuarioHombre : aux) {
			if (usuarioHombre.getIngresosMensuales() >= 244.85) {
				listaPorIngresos.add(usuarioHombre);
			}
		}

		ordenarPorIngresosDesc(listaPorIngresos);
		return listaPorIngresos;
	}

}
