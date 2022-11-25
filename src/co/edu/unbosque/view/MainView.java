package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	RegisterView registerView;
	IndexView indexView;
	LoginView loginView;
	HomeView homeView;

	public MainView() {

		setTitle("Pantalla Principal | AppName");
		setSize(1300, 650);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		intializeComponents();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void intializeComponents() {
		addIndexPanel();
		addRegisterPanel();
		addLoginPanel();
		addHomePanel();
	}
	
	public void addIndexPanel() {
		indexView = new IndexView();
		indexView.setBounds(0, 0, 1290, 650);
		indexView.setLayout(null);
		getContentPane().add(indexView);
		indexView.setVisible(false);
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
		homeView.setVisible(true);
	}

}
