/**
 * Clase que se encarga de leer el CSV
 */
package co.edu.unbosque.model.persistence;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioHombre;
import co.edu.unbosque.model.UsuarioMujer;

/**
 * @author Andres.Martinez
 *
 */
public class LectorCSV {
	private final char SEPARADOR = ';';
	private final String COMILLA = "\"";

	/**
	 * Metodo para leer datos de un archivo CSV
	 * 
	 * @param filePath - Ruta del CSV a cargar
	 * @throws ParseException
	 */
	public ArrayList<Usuario> leerArchivoCSV(String filePath) throws IOException, ParseException {
		ArrayList<Usuario> lista = new ArrayList<>();
		CSVReader reader = null;

		try {
			CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(SEPARADOR).build();
			reader = new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(conPuntoYComa).build();
			String[] fields = null;

			while ((fields = reader.readNext()) != null) {
				fields = removeTrailingQuotes(fields);

				if (!fields[0].equals("Id")) {

					String nombre = fields[1];
					String apellido1 = fields[2];
					String apellido2 = fields[3];
					String genero = fields[4];
					String usuario = fields[5];
					String contrasena = fields[6];
					String correo = fields[7];
					String fechaNacimiento = fields[8];
					int edad = Integer.parseInt(fields[9]);
					double ingresos = 0;
					if (fields[10] == null) {
						ingresos = Double.parseDouble(fields[10].replace(",", "."));
					}
					boolean divorcios;
					if (fields[11].equals("SI")) {
						divorcios = true;
					} else {
						divorcios = false;
					}
					int likesRecibidos = Integer.parseInt(fields[12]);
					int likesOtorgados = Integer.parseInt(fields[13]);
					int cantidadMatches = Integer.parseInt(fields[14]);
					boolean estado;
					if (fields[15].equals("Disponible")) {
						estado = true;
					} else {
						estado = false;
					}

					if (fields[4].equals("H")) {
						Usuario u = new UsuarioHombre(nombre, apellido1, apellido2, genero, usuario, contrasena, correo,
								fechaNacimiento, edad, estado, ingresos);
						u.setLikesRecibidos(likesRecibidos);
						u.setLikesOtorgados(likesOtorgados);
						u.setCantidadMatches(cantidadMatches);

						lista.add(u);
					} else if (fields[4].equals("M")) {
						Usuario u = new UsuarioMujer(nombre, apellido1, apellido2, genero, usuario, contrasena, correo,
								fechaNacimiento, edad, estado, divorcios);
						u.setLikesRecibidos(likesRecibidos);
						u.setLikesOtorgados(likesOtorgados);
						u.setCantidadMatches(cantidadMatches);

						lista.add(u);
					} else {
						System.out.println("Error creando usuario. No presenta genero.");
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return lista;
	}

	private String[] removeTrailingQuotes(String[] fields) {

		String result[] = new String[fields.length];

		for (int i = 0; i < result.length; i++) {
			result[i] = fields[i].replaceAll("^" + COMILLA, "").replaceAll(COMILLA + "$", "");
		}
		return result;
	}
}
