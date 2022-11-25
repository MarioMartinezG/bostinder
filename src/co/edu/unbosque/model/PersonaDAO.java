/**
 * Inteface que define los metodos del CRUD
 */
package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * @author Andres.Martinez
 *
 */
public interface PersonaDAO {
	void insertarPersona(ArrayList<Persona> lista, Persona c);
	Persona consultarPersona(ArrayList<Persona> lista, String nombre);
	String leerPersonas(ArrayList<Persona> lista);
	void eliminarPersona(ArrayList<Persona> lista, Persona c);
	boolean eliminarPersonaPorNombre(ArrayList<Persona> lista, String nombre);
	void modificarPersona(ArrayList<Persona> lista, Persona c);
}
