/**
* Controlador principal de la aplicacion
 */
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.swing.JPanel;

import co.edu.unbosque.model.EnvioCorreo;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDAO_Impl;
import co.edu.unbosque.model.UsuarioHombre;
import co.edu.unbosque.model.UsuarioMujer;
//import co.edu.unbosque.model.UsuarioHombre;
//import co.edu.unbosque.model.UsuarioMujer;
import co.edu.unbosque.model.persistence.ArchivoBinario;
import co.edu.unbosque.model.persistence.LectorCSV;
import co.edu.unbosque.view.*;

/**
 * @author Dayana Serrano, Mario Martínez, Daniela Murcia, Miguel Sánchez
 *
 */
public class MainController implements ActionListener, ItemListener {

	final static String RUTA_CSV = "datos/datos.csv";
	private MainView mainView;
	private IndexView indexView;
	private LoginView loginView;
	private HomeView homeView;
	private AdminView adminView;
	private RegisterView registerView;
	private UsuarioDAO_Impl dao;
	private ArrayList<Usuario> lista;
	private LectorCSV lector;
	private ArchivoBinario archivo;
	private EnvioCorreo correo;
	private int i;

	public MainController() {

		ejecutar();
	}

	public void initializeViews() {
		adminView = new AdminView();
		mainView = new MainView();
		indexView = new IndexView();
		registerView = new RegisterView();
		loginView = new LoginView();
		homeView = new HomeView();
	}

	private void initializeUtils() {
		lista = new ArrayList<>();
		lector = new LectorCSV();
		archivo = new ArchivoBinario();
		dao = new UsuarioDAO_Impl();
		correo = new EnvioCorreo();
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
			if (archivo.getArchivoUsuarios().length() == 0) {
				archivo.escribirEnArchivoUsuarios(lista);
			} else {
				System.out.println("El binario de usuarios ya tiene datos creados");
				System.out.println("Se carga la lista del archivo binario");
				lista = archivo.leerArchivoUsuarios();
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
		mainView.getRegisterView().getGenderField().addItemListener(this);
	}

	public void loginViewListeners() {
		mainView.getLoginView().getRegisterBtn().addActionListener(this);
		mainView.getLoginView().getLoginBtn().addActionListener(this);
		mainView.getLoginView().getBackBtn().addActionListener(this);
	}

	public void homeViewListernes() {

		mainView.getHomeView().getBackBtn().addActionListener(this);
		mainView.getHomeView().getLikeBtn().addActionListener(this);
		mainView.getHomeView().getDeclineBtn().addActionListener(this);

	}

	public void adminViewListeners() {
		mainView.getAdminView().getBackBtn().addActionListener(this);
		mainView.getAdminView().getToPdfBtn().addActionListener(this);
		mainView.getAdminView().getToStatsBtn().addActionListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String command = (String) e.getItem();

		switch (command) {
		case "Masculino":
			mainView.getRegisterView().getChangedLbl().setText("Salario");
			mainView.getRegisterView().getGenderG().setVisible(false);
			mainView.getRegisterView().getSalaryField().setVisible(true);

			break;
		case "Femenino":

			mainView.getRegisterView().getChangedLbl().setText("Divorciada");
			mainView.getRegisterView().getGenderG().setVisible(true);
			mainView.getRegisterView().getSalaryField().setVisible(false);
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		String command = e.getActionCommand();
		switch (command) {

		case "home-like":
			i++;
			cargarUsuarios(lista, i);
			break;
		case "home-refuse":
			i++;
			cargarUsuarios(lista, i);
			break;

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
			closePanels(mainView.getHomeView(), mainView.getLoginView(), mainView.getRegisterView(),
					mainView.getAdminView());
			break;

		case "valid-access":

			String nombre = mainView.getRegisterView().getNameField().getText();
			String alias = mainView.getRegisterView().getUserField().getText();
			String contrasena = "loginVudu1234*";
			int edad = 20;
			int estatura;
			String correo = mainView.getRegisterView().getEmailField().getText();
			String fechaNacimiento = mainView.getRegisterView().getBornDate().getText();
			String genero = ((String) mainView.getRegisterView().getGenderField().getSelectedItem()).equals("Masculino")
					? "H"
					: "M";
			boolean divorcios;
			boolean aliasRep = false;
			Double salario;

			for (Usuario usuario : lista) {
				if (compararAlias(alias, usuario.getUsuario())) {
					aliasRep = true;
					break;
				}
			}
			if (aliasRep) {
				mainView.showMsgError("El alias ingresado ya se encuentra registrado.");
			} else if (validarFormatoCorreo(correo) == false) {
				mainView.showMsgError("Formato de correo no valido.");
			} else if (!validarFormatoFecha(fechaNacimiento)) {
				mainView.showMsgError("Formato de fecha no valido (Debe ser dd/MM/yyyy).");
			} else if (!validarEdad(fechaNacimiento)) {
				mainView.showMsgError("Debe ser mayor de 18 a�os para registrarse.");
			} else {
				if (genero.equals("M")) {
					if (mainView.getRegisterView().getHeightField().getText().equals("")) {
						estatura = 0;
						divorcios = ((String) mainView.getRegisterView().getGenderG().getSelectedItem()).equals("Si")
								? true
								: false;
						UsuarioMujer usuarioMujer = new UsuarioMujer(nombre, nombre, nombre, genero, alias, contrasena,
								correo, fechaNacimiento, edad, estatura, true, divorcios);
						dao.insertarUsuario(lista, usuarioMujer);
						if (archivo.escribirEnArchivoUsuarios(lista)) {
							mainView.showMsgInfo(
									"Usuario creado correctamente. Valide el correo para consultar sus credenciales.");
						} else {
							mainView.showMsgError("Error al crear usuario. Consulte al administrador.");
						}
					} else {

						try {
							estatura = Integer.parseInt(mainView.getRegisterView().getHeightField().getText());
							divorcios = ((String) mainView.getRegisterView().getGenderG().getSelectedItem())
									.equals("Si") ? true : false;
							UsuarioMujer usuarioMujer = new UsuarioMujer(nombre, nombre, nombre, genero, alias,
									contrasena, correo, fechaNacimiento, edad, estatura, true, divorcios);
							dao.insertarUsuario(lista, usuarioMujer);
							if (archivo.escribirEnArchivoUsuarios(lista)) {
								mainView.showMsgInfo(
										"Usuario creado correctamente. Valide el correo para consultar sus credenciales.");
							} else {
								mainView.showMsgError("Error al crear usuario. Consulte al administrador.");
							}
						} catch (NumberFormatException NFe) {
							NFe.printStackTrace();
						}
					}

					if (!this.correo.enviarCorreo(correo, alias, contrasena)) {
						mainView.showMsgError("No fue posible realizar el envio del correo.");
					}

					mainView.getLoginView().setVisible(false);
					mainView.getRegisterView().setVisible(false);
					mainView.getRegisterView().limpiarCampos();
					mainView.getHomeView().setVisible(true);

				} else {
					if (mainView.getRegisterView().getHeightField().getText().equals("")) {
						mainView.showMsgError("Para genero masculino debe agregar su estatura");
					} else {
						estatura = Integer.parseInt(mainView.getRegisterView().getHeightField().getText());
						try {
							salario = Double.parseDouble(mainView.getRegisterView().getSalaryField().getText());
							UsuarioHombre usuarioHombre = new UsuarioHombre(nombre, nombre, nombre, genero, alias,
									contrasena, correo, fechaNacimiento, edad, estatura, true, salario);
							dao.insertarUsuario(lista, usuarioHombre);
							if (archivo.escribirEnArchivoUsuarios(lista)) {
								mainView.showMsgInfo(
										"Usuario creado correctamente. Valide el correo para consultar sus credenciales.");
							} else {
								mainView.showMsgError("Error al crear usuario. Consulte al administrador.");
							}
						} catch (NumberFormatException ex) {
							mainView.showMsgError(
									"El salario ingresado no tiene un formato valido (decimales separados por .).");
							ex.printStackTrace();
						}

						if (!this.correo.enviarCorreo(correo, alias, contrasena)) {
							mainView.showMsgError("No fue posible realizar el envio del correo.");
						}

						mainView.getLoginView().setVisible(false);
						mainView.getRegisterView().setVisible(false);
						mainView.getRegisterView().limpiarCampos();
						mainView.getHomeView().setVisible(true);
					}
				}

			}

			cargarUsuarios(lista, 0);

			break;

		case "access":
			String usuarioAdmin = mainView.getLoginView().getUserField().getText();
			String contrasenaAdmin = mainView.getLoginView().getPassField().getText();

			Usuario user = dao.consultarUsuario(lista, usuarioAdmin);
			if (user != null && user.getContrasena().equals(contrasenaAdmin)) {
				System.out.println("Usuario se puede loguear");

				if (usuarioAdmin.equals("admin") && contrasenaAdmin.equals("testpass")) {
					System.out.println("Entra como usuario admin");
					mainView.getLoginView().setVisible(false);
					mainView.getRegisterView().setVisible(false);
					mainView.getHomeView().setVisible(false);
					mainView.getAdminView().setVisible(true);
				} else {
					mainView.getLoginView().setVisible(false);
					mainView.getRegisterView().setVisible(false);
					mainView.getHomeView().setVisible(true);
					mainView.getAdminView().setVisible(false);
				}
			} else {
				mainView.showMsgError("El usuario ingresado no se encuentra registrado");
			}

			cargarUsuarios(lista, 0);
			break;

		}
	}

	private void cargarUsuarios(ArrayList<Usuario> lista2, int i) {

		ArrayList<Usuario> listaActivos = new ArrayList<>();

		for (Usuario usuario : lista) {
			if (usuario.isEstado()) {
				listaActivos.add(usuario);
			}
		}

		Usuario usuario = listaActivos.get(i);

		mainView.getHomeView().getNameLbl().setText(usuario.getNombre() + ", " + usuario.getEdad());
		mainView.getHomeView().getDescriptionLbl()
				.setText("Fecha de nacimiento: " + usuario.getFechaNacimiento() + ", Edad: " + usuario.getEdad());
		if (usuario.getGenero().equals("H")) {
			UsuarioHombre userH = (UsuarioHombre) usuario;
			mainView.getHomeView().getMarriageLbl().setText("");
			mainView.getHomeView().getSalaryLbl().setText("Salario: " + userH.getIngresosMensuales());
		} else {
			UsuarioMujer userM = (UsuarioMujer) usuario;
			String divorcio = (userM.isDivorcios() == true) ? "Si" : "No";
			mainView.getHomeView().getSalaryLbl().setText("");
			mainView.getHomeView().getMarriageLbl().setText("Divorciada: " + divorcio);
		}

		i = (i == listaActivos.size()) ? 0 : i++;

	}

	private void closePanels(JPanel home, JPanel login, JPanel register, JPanel admin) {
		if (home.isVisible()) {
			home.setVisible(false);
			mainView.getIndexView().setVisible(true);
		} else if (login.isVisible()) {
			login.setVisible(false);
			mainView.getIndexView().setVisible(true);
		} else if (register.isVisible()) {
			register.setVisible(false);
			mainView.getIndexView().setVisible(true);
		} else if (admin.isVisible()) {
			admin.setVisible(false);
			mainView.getIndexView().setVisible(true);
		}

	}

	private boolean validarFormatoCorreo(String correo) {
		String regExCorreo = "^(.+)@(\\S+)$";
		return Pattern.compile(regExCorreo).matcher(correo).matches();
	}

	private boolean validarFormatoFecha(String fecha) {
		String format = "dd/MM/yyyy";
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(fecha);
			if (!fecha.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return date != null;
	}

	/**
	 * Metodo para validar alias unico
	 * 
	 * @param alias1 - Primer alias a comparar
	 * @param alias2 - Segundo alias a comparar
	 */

	private boolean compararAlias(String alias1, String alias2) {
		boolean resultado = (alias1.equals(alias2)) ? true : false;
		return resultado;
	}

	/**
	 * Metodo para validar que la edad del usuario sea mayor a 18 a�os
	 * 
	 * @param fechaNacimiento - Fecha de nacimiento del usuario en formato
	 *                        DD/MM/YYYY
	 */
	private boolean validarEdad(String fechaNacimiento) {
		boolean resultado;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);
		Period edad = Period.between(fecha, LocalDate.now());

		if (edad.getYears() >= 18 && edad.getMonths() >= 0 && edad.getDays() >= 0) {
			resultado = true;
		} else {
			resultado = false;
		}

		return resultado;
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
	 * @return the adminView
	 */
	public AdminView getAdminView() {
		return adminView;
	}

	/**
	 * @param adminView the adminView to set
	 */
	public void setAdminView(AdminView adminView) {
		this.adminView = adminView;
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
