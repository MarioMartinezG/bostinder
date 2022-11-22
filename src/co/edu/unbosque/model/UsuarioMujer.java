/**
 * 
 */
package co.edu.unbosque.model;

import java.util.Date;

/**
 * @author Andres.Martinez
 *
 */
@SuppressWarnings("serial")
public class UsuarioMujer extends Usuario {

	private boolean divorcios;

	/**
	 * Constructor de la clase UsuarioMujer
	 * 
	 * @param nombre          - Nombre del usuario
	 * @param apellido1       - Primer apellido del usuario
	 * @param apellido2       - Segundo apellido del usuario
	 * @param genero          - Genero del usuario
	 * @param usuario         - Alias del usuario
	 * @param contrasena      - Contraseña del usuario
	 * @param correo          - Correo del usuario
	 * @param fechaNacimiento - Fecha de Nacimiento del usuario en formato
	 *                        DD/MM/YYYY
	 * @param edad            - Edad del usuario
	 * @param estado          - Estado del usuario (true: activo, false: inactivo)
	 * @param divorcios       - Indica si ha tenido divorcios (true: SI, false; no)
	 */
	public UsuarioMujer(String nombre, String apellido1, String apellido2, char genero, String usuario,
			String contrasena, String correo, Date fechaNacimiento, int edad, boolean estado, boolean divorcios) {
		super(nombre, apellido1, apellido2, genero, usuario, contrasena, correo, fechaNacimiento, edad, estado);
		this.divorcios = divorcios;
	}

	/**
	 * @return the divorcios
	 */
	public boolean isDivorcios() {
		return divorcios;
	}

	/**
	 * @param divorcios the divorcios to set
	 */
	public void setDivorcios(boolean divorcios) {
		this.divorcios = divorcios;
	}

}
