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
import co.edu.unbosque.model.UsuarioDAO_Impl;
import co.edu.unbosque.model.UsuarioHombre;
import co.edu.unbosque.model.UsuarioMujer;
import co.edu.unbosque.model.persistence.ArchivoBinario;
import co.edu.unbosque.model.persistence.LectorCSV;
import co.edu.unbosque.view.*;

/**
 * @author Dayana Serrano, Mario Martínez, Daniela Murcia, Miguel Sánchez
 *
 */
public class MainController implements ActionListener {

	final static String RUTA_CSV = "datos/datos.csv";
	private MainView mainView;
	private IndexView indexView;
	private LoginView loginView;
	private HomeView homeView;
	private RegisterView registerView;
	private UsuarioDAO_Impl dao;
	private UsuarioHombre userHombre;
	private UsuarioMujer userMujer;
	private ArrayList<Usuario> lista;
	private LectorCSV lector;
	private ArchivoBinario archivo;

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
		dao = new UsuarioDAO_Impl();
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
			if (archivo.getArchivoUsuarios().length() == 0) {
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
		
		case "access":
			String usuario = mainView.getLoginView().getUserField().getText();
			String contrasena = mainView.getLoginView().getPassField().getText();
			
			Usuario user = dao.consultarUsuario(lista, usuario);
			if(user != null && user.getContrasena().equals(contrasena)) {
				System.out.println("Usuario se puede loguear");
				
				mainView.getLoginView().getUserField().setText("Usuario");
				mainView.getLoginView().getPassField().setText("Contrase�a");
				mainView.getLoginView().setVisible(false);
				mainView.getRegisterView().setVisible(false);
				mainView.getHomeView().setVisible(true);
			} else {
				mainView.showMsgError("El usuario ingresado no se encuentra registrado");
			}

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

	/**
	 * @return the dao
	 */
	public UsuarioDAO_Impl getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(UsuarioDAO_Impl dao) {
		this.dao = dao;
	}

}
