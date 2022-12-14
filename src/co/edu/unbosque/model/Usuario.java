/**
 * Clase padre que define la persona que interactua con la aplicacion
 */
package co.edu.unbosque.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Mario Martinez
 *
 */
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected String genero;
	protected String usuario;
	protected String contrasena;
	protected String correo;
	protected String fechaNacimiento;
	protected int edad;
	protected int estatura;
	protected int likesRecibidos;
	protected int likesOtorgados;
	protected int cantidadMatches;
	protected boolean estado;

	/**
	 * Constructor de la clase Usuario
	 * 
	 * @param nombre          - Nombre del usuario
	 * @param apellido1       - Primer apellido del usuario
	 * @param apellido2       - Segundo apellido del usuario
	 * @param genero          - Genero del usuario
	 * @param usuario         - Alias del usuario
	 * @param contrasena      - Contraseņa del usuario
	 * @param correo          - Correo del usuario
	 * @param fechaNacimiento - Fecha de Nacimiento del usuario en formato
	 *                        DD/MM/YYYY
	 * @param edad            - Edad del usuario
	 * @param estatura        - Estatura del usuario en cm
	 * @param estado          - Estado del usuario
	 */
	protected Usuario(String nombre, String apellido1, String apellido2, String genero, String usuario,
			String contrasena, String correo, String fechaNacimiento, int edad, int estatura, boolean estado) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.genero = genero;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.estatura = estatura;
		this.likesRecibidos = 0;
		this.likesOtorgados = 0;
		this.cantidadMatches = 0;
		this.estado = estado;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the estatura
	 */
	public int getEstatura() {
		return estatura;
	}

	/**
	 * @param estatura the estatura to set
	 */
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	/**
	 * @return the likesRecibidos
	 */
	public int getLikesRecibidos() {
		return likesRecibidos;
	}

	/**
	 * @param likesRecibidos the likesRecibidos to set
	 */
	public void setLikesRecibidos(int likesRecibidos) {
		this.likesRecibidos = likesRecibidos;
	}

	/**
	 * @return the likesOtorgados
	 */
	public int getLikesOtorgados() {
		return likesOtorgados;
	}

	/**
	 * @param likesOtorgados the likesOtorgados to set
	 */
	public void setLikesOtorgados(int likesOtorgados) {
		this.likesOtorgados = likesOtorgados;
	}

	/**
	 * @return the cantidadMatches
	 */
	public int getCantidadMatches() {
		return cantidadMatches;
	}

	/**
	 * @param cantidadMatches the cantidadMatches to set
	 */
	public void setCantidadMatches(int cantidadMatches) {
		this.cantidadMatches = cantidadMatches;
	}

	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", genero="
				+ genero + ", usuario=" + usuario + ", contrasena=" + contrasena + ", correo=" + correo
				+ ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + ", likesRecibidos=" + likesRecibidos
				+ ", likesOtorgados=" + likesOtorgados + ", cantidadMatches=" + cantidadMatches + ", estado=" + estado;
	}

}
