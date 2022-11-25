package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class LoginView extends JPanel {

	private JPanel img;
	private JLabel titleLbl;
	private JTextField emailField, passField;
	private JButton loginBtn, backBtn, registerBtn;
	Border emptyBorder = BorderFactory.createEmptyBorder();

	public LoginView() {

		setBackground(Color.white);
		initializeComponents();
	}

	public void initializeComponents() {
		// Panel size: 1260x590

		img = new JPanel();
		img.setBackground(Color.lightGray);
		img.setBounds(60, 30, 70, 70);
		add(img);

		titleLbl = new JLabel("Bienvenido/a, inicia sesion");
		titleLbl.setFont(new Font("Roboto", Font.BOLD, 20));
		titleLbl.setBounds(140, 30, 300, 50);
		add(titleLbl);

		emailField = new JTextField("Correo electrónico");
		emailField.setFont(new Font("Roboto", Font.BOLD, 12));
		emailField.setBackground(new Color(230, 230, 230));
		emailField.setBorder(emptyBorder);
		emailField.setBounds(430, 330, 400, 35);
		add(emailField);

		passField = new JTextField("Nombre");
		passField.setBackground(new Color(230, 230, 230));
		passField.setFont(new Font("Roboto", Font.BOLD, 12));
		passField.setBorder(emptyBorder);
		passField.setBounds(430, 375, 400, 35);
		add(passField);

		registerBtn = new JButton("Iniciar sesión");
		registerBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		registerBtn.setBackground(new Color(30, 55, 92));
		registerBtn.setBounds(480, 480, 300, 40);
		registerBtn.setForeground(new Color(230, 230, 230));
		registerBtn.setBorder(emptyBorder);
		add(registerBtn);

		loginBtn = new JButton("¿Aún no tienes una cuenta? Registrate");
		loginBtn.setFont(new Font("Roboto", Font.BOLD, 12));
		loginBtn.setBackground(Color.white);
		loginBtn.setBounds(480, 530, 300, 30);
		loginBtn.setBorder(emptyBorder);
		add(loginBtn);

		backBtn = new JButton("<");
		backBtn.setFont(new Font("Roboto", Font.BOLD, 12));
		backBtn.setBackground(Color.white);
		backBtn.setBounds(10, 10, 50, 50);
		backBtn.setBorder(emptyBorder);
		add(backBtn);
	}

	public JPanel getImg() {
		return img;
	}

	public void setImg(JPanel img) {
		this.img = img;
	}

	public JLabel getTitleLbl() {
		return titleLbl;
	}

	public void setTitleLbl(JLabel titleLbl) {
		this.titleLbl = titleLbl;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	public JTextField getPassField() {
		return passField;
	}

	public void setPassField(JTextField passField) {
		this.passField = passField;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	public JButton getRegisterBtn() {
		return registerBtn;
	}

	public void setRegisterBtn(JButton registerBtn) {
		this.registerBtn = registerBtn;
	}
	
}
