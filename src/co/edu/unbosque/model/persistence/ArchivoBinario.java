/**
 * Clase que implementa la logica de interaccion con los archivos binarios
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import co.edu.unbosque.model.Usuario;

/**
 * @author Mario Martinez
 *
 */
public class ArchivoBinario {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivoUsuarios = new File("datos/usuarios.dat");

	/**
	 * Constructor de la clase ArchivoBinario
	 */
	public ArchivoBinario() {
		if (archivoUsuarios.exists()) {
			System.out.println("La base de datos ya existe");
		} else {
			try {
				archivoUsuarios.createNewFile();
				System.out.println("Se crea la base de datos");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo para leer usuarios del archivo binario usuarios.dat
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Usuario> leerArchivoUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		if (this.archivoUsuarios.length() != 0) {
			try {
				this.entrada = new ObjectInputStream(new FileInputStream(this.archivoUsuarios));
				usuarios = (ArrayList<Usuario>) entrada.readObject();
				this.entrada.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}

	/**
	 * Metodo para escribir usuarios del archivo binario usuarios.dat
	 * 
	 * @param listaUsuarios - Arreglo de usuarios deserializado de usuarios.dat
	 */
	public boolean escribirEnArchivoUsuarios(ArrayList<Usuario> listaUsuarios) {
		try {
			this.salida = new ObjectOutputStream(new FileOutputStream(this.archivoUsuarios));
			this.salida.writeObject(listaUsuarios);
			this.salida.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @return the archivoUsuarios
	 */
	public File getArchivoUsuarios() {
		return archivoUsuarios;
	}

	/**
	 * @param archivoUsuarios the archivoUsuarios to set
	 */
	public void setArchivoUsuarios(File archivoUsuarios) {
		this.archivoUsuarios = archivoUsuarios;
	}
}
