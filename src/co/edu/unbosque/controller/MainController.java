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
 * @author Dayana Serrano, Mario Mart√≠nez, Daniela Murcia, Miguel S√°nchez
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
	// private UsuarioHombre userHombre;
	// private UsuarioMujer userMujer;
	private ArrayList<Usuario> lista;
	private LectorCSV lector;
	private ArchivoBinario archivo;
	private EnvioCorreo correo;

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
		mainView.getRegisterView().getGenderField().addItemListener(this);
	}

	public void loginViewListeners() {
		mainView.getLoginView().getRegisterBtn().addActionListener(this);
		mainView.getLoginView().getLoginBtn().addActionListener(this);
		mainView.getLoginView().getBackBtn().addActionListener(this);
	}

	public void homeViewListernes() {

		mainView.getHomeView().getBackBtn().addActionListener(this);
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

			mainView.getRegisterView().getGenderG().setVisible(false);
			mainView.getRegisterView().getSalaryField().setVisible(true);

			break;
		case "Femenino":

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
			/**
			 * A LA VISTA DEL REGISTRO LE FALTA: ALIAS EDAD ESTATURA - OPCIONAL PARA MUJERES
			 * / OBLIGATORIA PARA HOMBRES CONTRASE—A
			 */

			String nombre = mainView.getRegisterView().getNameField().getText();
			System.out.println("Nombre registro: " + nombre);
			String alias = "creacion";
			String contrasena = "test123*";
			int edad = 20;
			int estatura = 170;
			String correo = mainView.getRegisterView().getEmailField().getText();
			String fechaNacimiento = mainView.getRegisterView().getBornDate().getText();
			System.out.println("Fecha registro: " + fechaNacimiento);
			String genero = ((String) mainView.getRegisterView().getGenderField().getSelectedItem()).equals("Masculino")
					? "H"
					: "M";
			System.out.println("Genero : " + (String) mainView.getRegisterView().getGenderField().getSelectedItem());
			System.out.println("Genero real: " + genero);
			boolean divorcios;
			Double salario;

			if (validarFormatoCorreo(correo) == false) {
				mainView.showMsgError("Formato de correo no valido.");
			} else if (!validarFormatoFecha(fechaNacimiento)) {
				mainView.showMsgError("Formato de fecha no valido (Debe ser dd/MM/yyyy).");
			} else if (!validarEdad(fechaNacimiento)) {
				mainView.showMsgError("Debe ser mayor de 18 aÒos para registrarse.");
			} else {
				if (genero.equals("M")) {
					divorcios = ((String) mainView.getRegisterView().getGenderG().getSelectedItem()).equals("Si") ? true
							: false;
					System.out.println("Divorcios : " + (String) mainView.getRegisterView().getGenderG().getSelectedItem());
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
						salario = Double.parseDouble(mainView.getRegisterView().getSalaryField().getText());
						System.out.println("Salario: " + salario);
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
				}

				if (!this.correo.enviarCorreo(correo, alias, contrasena)) {
					mainView.showMsgError("No fue posible realizar el envio del correo.");
				}

				mainView.getLoginView().setVisible(false);
				mainView.getRegisterView().setVisible(false);
				mainView.getRegisterView().limpiarCampos();
				mainView.getHomeView().setVisible(true);
			}

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

		}
	}

	public void closePanels(JPanel home, JPanel login, JPanel register, JPanel admin) {
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
		System.out.println("Correo a validar: " + correo);
		System.out.println("Resultado validacion correo: " + Pattern.compile(regExCorreo).matcher(correo).matches());
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
		System.out.println("Resultado validacion fecha: " + date != null);
		return date != null;
	}

	/**
	 * Metodo para validar alias unico
	 * 
	 * @param alias1 - Primer alias a comparar
	 * @param alias2 - Segundo alias a comparar
	 */

	private boolean compararAlias(String alias1, String alias2) {
		/**
		 * Comparacion usando operador ternario resultado = (condicion)?valor1:valor2;
		 * Si la condicion evalua a verdadero, retorna valor1; de lo contrario, retorna
		 * valor2
		 */
		boolean resultado = (alias1.equals(alias2)) ? true : false;
		return resultado;
	}

	/**
	 * Metodo para validar correo unico
	 * 
	 * @param correo1 - Primer correo a comparar
	 * @param correo2 - Segundo correo a comparar
	 */

	private boolean compararCorreo(String correo1, String correo2) {
		/**
		 * Comparacion usando operador ternario resultado = (condicion)?valor1:valor2;
		 * Si la condicion evalua a verdadero, retorna valor1; de lo contrario, retorna
		 * valor2
		 */
		boolean resultado = (correo1.equals(correo2)) ? true : false;
		return resultado;
	}

	/**
	 * Metodo para validar que la edad del usuario sea mayor a 18 aÒos
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
