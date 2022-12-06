package co.edu.unbosque.view;

import java.util.Locale;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	RegisterView registerView;
	IndexView indexView;
	LoginView loginView;
	HomeView homeView;
	AdminView adminView;

	public MainView() {

		setTitle("Pantalla Principal | VUDU");
		setSize(1300, 650);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		intializeComponents();
	}

	public void intializeComponents() {
		addIndexPanel();
		addRegisterPanel();
		addLoginPanel();
		addHomePanel();
		addAdminPanel();
	}

	public void addIndexPanel() {
		indexView = new IndexView();
		indexView.setBounds(0, 0, 1290, 650);
		indexView.setLayout(null);
		getContentPane().add(indexView);
		indexView.setVisible(true);
	}

	public void addRegisterPanel() {
		registerView = new RegisterView();
		registerView.setBounds(0, 0, 1290, 650);
		registerView.setLayout(null);
		getContentPane().add(registerView);
		registerView.setVisible(false);

	}

	public void addLoginPanel() {
		loginView = new LoginView();
		loginView.setBounds(0, 0, 1290, 650);
		loginView.setLayout(null);
		getContentPane().add(loginView);
		loginView.setVisible(false);
	}

	public void addHomePanel() {
		homeView = new HomeView();
		homeView.setBounds(0, 0, 1290, 650);
		homeView.setLayout(null);
		getContentPane().add(homeView);
		homeView.setVisible(false);

	}
	public void addAdminPanel() {
		adminView = new AdminView();;
		adminView.setBounds(0, 0, 1290, 650);
		adminView.setLayout(null);
		getContentPane().add(adminView);
		adminView.setVisible(false);
		
	}
	
	public void showMsgError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showMsgInfo(String message) {
		JOptionPane.showMessageDialog(null, message, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
	}

	public RegisterView getRegisterView() {
		return registerView;
	}

	public void setRegisterView(RegisterView registerView) {
		this.registerView = registerView;
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
	

}
