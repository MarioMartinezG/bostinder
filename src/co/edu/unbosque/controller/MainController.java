/**
* Controlador principal de la aplicacion
 */
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.ArchivoBinario;
import co.edu.unbosque.model.persistence.LectorCSV;
import co.edu.unbosque.view.*;

/**
 * @author Dayana Serrano, Mario Martínez, Daniela Murcia, Miguel Sánchez
 *
 */
public class MainController implements ActionListener {

	final static String RUTA_CSV = "datos/datos.csv";
	MainView mainView;
	IndexView indexView;
	LoginView loginView;
	HomeView homeView;
	RegisterView registerView;
	ArrayList<Usuario> lista;
	LectorCSV lector;
	ArchivoBinario archivo;


	public MainController() {

		ejecutar();
	}

	public void initializeViews() {
		mainView = new MainView();
		indexView = new IndexView();
		registerView = new RegisterView();
		loginView = new LoginView();
	}
	
	private void initializeUtils() {
		lista = new ArrayList<>();
		lector = new LectorCSV();
		archivo = new ArchivoBinario();
	}

	private void ejecutar() {
		
		initializeUtils();
		initializeViews();
		indexViewListeners();
		registerViewListeners();
		loginViewListeners();
		homeViewListernes();
		
		cargarUsuariosCSV();
	}
	
	private void cargarUsuariosCSV() {
		try {
			lista = lector.leerArchivoCSV(RUTA_CSV);
			System.out.println("Tamano lista usuarios CSV: " + lista.size());
			if(archivo.getArchivoUsuarios().length() == 0) {
				archivo.escribirEnArchivoUsuarios(lista);
			} else {
				System.out.println("El binario de usuarios ya tiene datos creados");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void indexViewListeners() {
		mainView.getIndexView().getRegisterBtn().addActionListener(this);
		mainView.getIndexView().getLoginBtn().addActionListener(this);
		mainView.getIndexView().getFileBtn().addActionListener(this);
	}

	public void registerViewListeners() {
		mainView.getRegisterView().getBackBtn().addActionListener(this);
		mainView.getRegisterView().getRegisterBtn().addActionListener(this);
		mainView.getRegisterView().getLoginBtn().addActionListener(this);
	}

	public void loginViewListeners() {
		mainView.getLoginView().getRegisterBtn().addActionListener(this);
		mainView.getLoginView().getLoginBtn().addActionListener(this);
		mainView.getLoginView().getBackBtn().addActionListener(this);
	}
	public void homeViewListernes() {

		mainView.getHomeView().getBackBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		String command = e.getActionCommand();
		switch (command) {
		case "file":
			break;

		case "login":
			mainView.getIndexView().setVisible(false);
			mainView.getRegisterView().setVisible(false);
			mainView.getLoginView().setVisible(true);
			break;

		case "register":
			mainView.getIndexView().setVisible(false);
			mainView.getRegisterView().setVisible(true);
			break;
		case "back":
			mainView.getIndexView().setVisible(true);
			mainView.getRegisterView().setVisible(false);
			mainView.getLoginView().setVisible(false);
			
		case "valid-access":
			mainView.getLoginView().setVisible(false);
			mainView.getRegisterView().setVisible(false);
			mainView.getHomeView().setVisible(true);
			break;
		}

	}

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}

	public IndexView getIndexView() {
		return indexView;
	}

	public void setIndexView(IndexView indexView) {
		this.indexView = indexView;
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}

	public HomeView getHomeView() {
		return homeView;
	}

	public void setHomeView(HomeView homeView) {
		this.homeView = homeView;
	}

	public RegisterView getRegisterView() {
		return registerView;
	}

	public void setRegisterView(RegisterView registerView) {
		this.registerView = registerView;
	}

}
