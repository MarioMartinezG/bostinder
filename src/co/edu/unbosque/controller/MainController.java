/**
 * Controlador principal de la aplicacion
 */
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.*;

/**
 * @author Dayana Serrano, Mario Martínez, Daniela Murcia, Miguel Sánchez
 *
 */
public class MainController implements ActionListener {
	
	MainView mainView;
	IndexView indexView;
	LoginView loginView;
	HomeView homeView;
	RegisterView registerView;

	public MainController() {
		ejecutar();
	}

	private void ejecutar() {
		indexView = new IndexView();
		listeners();
	}
	public void listeners() {
		indexViewListeners();
	}
	public void indexViewListeners() {
		indexView.getRegisterBtn().addActionListener(this);
		indexView.getLoginBtn().addActionListener(this);
	}
	public void mainViewListeners() {
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		System.out.println(event);
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
