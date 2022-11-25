/**
 * Clase que define la implementacion de un usuario hombre
 */
package co.edu.unbosque.model;

import java.util.Date;

/**
 * @author Andres.Martinez
 *
 */
@SuppressWarnings("serial")
public class UsuarioHombre extends Usuario {

	private long ingresosMensuales;

	/**
	 * Constructor de la clase UsuarioHombre
	 * 
	 * @param nombre            - Nombre del usuario
	 * @param apellido1         - Primer apellido del usuario
	 * @param apellido2         - Segundo apellido del usuario
	 * @param genero            - Genero del usuario
	 * @param usuario           - Alias del usuario
	 * @param contrasena        - Contraseña del usuario
	 * @param correo            - Correo del usuario
	 * @param fechaNacimiento   - Fecha de Nacimiento del usuario en formato
	 *                          DD/MM/YYYY
	 * @param edad              - Edad del usuario
	 * @param estado            - Estado del usuario
	 * @param ingresosMensuales - Ingresos del Usuario Hombre
	 */
	public UsuarioHombre(String nombre, String apellido1, String apellido2, char genero, String usuario,
			String contrasena, String correo, Date fechaNacimiento, int edad, boolean estado, long ingresosMensuales) {
		super(nombre, apellido1, apellido2, genero, usuario, contrasena, correo, fechaNacimiento, edad, estado);
		this.ingresosMensuales = ingresosMensuales;
	}

	/**
	 * @return the ingresosMensuales
	 */
	public long getIngresosMensuales() {
		return ingresosMensuales;
	}

	/**
	 * @param ingresosMensuales the ingresosMensuales to set
	 */
	public void setIngresosMensuales(long ingresosMensuales) {
		this.ingresosMensuales = ingresosMensuales;
	}

	@Override
	public String toString() {
		return super.toString() + ", ingresosMensuales=" + ingresosMensuales;
	}

}
