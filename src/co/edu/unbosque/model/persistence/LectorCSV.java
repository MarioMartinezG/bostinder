/**
 * Clase que se encarga de leer el CSV
 */
package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Andres.Martinez
 *
 */
public class LectorCSV {
	/**
	 * Metodo para leer datos de un archivo CSV
	 * 
	 * @param filePath - Ruta del CSV a cargar
	 */
	public void leerArchivoCSV(String filePath) throws IOException {
		final String SEPARADOR = ";";
		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();
			while (null != line) {
				String[] fields = line.split(SEPARADOR);
				System.out.println(Arrays.toString(fields));

				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				br.close();
			}
		}
	}

}
