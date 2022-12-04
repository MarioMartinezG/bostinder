/**
 * Clase que se encarga de generar graficos
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import co.edu.unbosque.model.Usuario;

/**
 * @author Andres.Martinez
 *
 */

public class GeneraGrafico {
	private final static String DIR = "datos/";

	/**
	 * Metodo para generar grafica circular de distribucion de generos
	 * 
	 * @param lista - Lista de usuarios del sistema
	 */
	public void graficarDistUsuariosPorGenero(ArrayList<Usuario> lista) {

		int cantHombres = calcularUsuariosHombre(lista);
		int cantMujeres = calcularUsuariosMujer(lista);
		int totalUsuarios = lista.size();

		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("Hombre", cantHombres);
		data.setValue("Mujer", cantMujeres);

		JFreeChart chart = ChartFactory.createPieChart("Relacion de hombres y mujeres en Vudu", data, true, true,
				false);

		try {
			ChartUtils.saveChartAsJPEG(new File(DIR + "pastel.jpg"), chart, 500, 500);
			System.out.println("Genera grafico en jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int calcularUsuariosHombre(ArrayList<Usuario> lista) {
		int totalUserHombres = 0;

		for (Usuario usuario : lista) {
			if (usuario.getGenero().equals("H")) {
				totalUserHombres++;
			}
		}
		return totalUserHombres;
	}

	private int calcularUsuariosMujer(ArrayList<Usuario> lista) {
		int totalUserMujeres = 0;

		for (Usuario usuario : lista) {
			if (usuario.getGenero().equals("M")) {
				totalUserMujeres++;
			}
		}
		return totalUserMujeres;
	}
}
