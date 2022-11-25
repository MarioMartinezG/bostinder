/**
 * Clase principal de la aplicacion - Ejecuta el metodo main
 */
package co.edu.unbosque.controller;

import co.edu.unbosque.view.*;

/**
 * @author Dayana Serrano
 *
 */
public class AplMain {
	MainController controller;
	
	MainView mainView;
	HomeView homeView;
	IndexView indexView;

	public static void main(String[] args) {
		new AplMain().start();
	}
	public void start() {
		System.out.println("Aplicación iniciada");
		initializeControllers();
	}

	public void initializeControllers() {
		controller = new MainController();
	}
}