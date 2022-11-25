package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class RegisterView extends JPanel {

	private JPanel img;
	private JLabel titleLbl;
	private JTextField emailField, nameField, genderField, borndate;
	private JButton registerBtn, loginBtn, backBtn;
	Border emptyBorder = BorderFactory.createEmptyBorder();

	public RegisterView() {

		setBackground(Color.white);
		initializeComponents();
	}

	public void initializeComponents() {
		// Panel size: 1260x590

		img = new JPanel();
		img.setBackground(Color.lightGray);
		img.setBounds(60, 30, 70, 70);
		add(img);

		titleLbl = new JLabel("Bienvenido/a, regístrate");
		titleLbl.setFont(new Font("Roboto", Font.BOLD, 20));
		titleLbl.setBounds(140, 30, 300, 50);
		add(titleLbl);

		emailField = new JTextField("Correo electrónico");
		emailField.setFont(new Font("Roboto", Font.BOLD, 12));
		emailField.setBackground(new Color(230, 230, 230));
		emailField.setBorder(emptyBorder);
		emailField.setBounds(430, 295, 400, 35);
		add(emailField);

		nameField = new JTextField("Nombre");
		nameField.setBackground(new Color(230, 230, 230));
		nameField.setFont(new Font("Roboto", Font.BOLD, 12));
		nameField.setBorder(emptyBorder);
		nameField.setBounds(430, 340, 400, 35);
		add(nameField);

		borndate = new JTextField("Fecha de nacimiento");
		borndate.setFont(new Font("Roboto", Font.BOLD, 12));
		borndate.setBackground(new Color(230, 230, 230));
		borndate.setBorder(emptyBorder);
		borndate.setBounds(430, 385, 400, 35);
		add(borndate);

		genderField = new JTextField("Género");
		genderField.setFont(new Font("Roboto", Font.BOLD, 12));
		genderField.setBackground(new Color(230, 230, 230));
		genderField.setBorder(emptyBorder);
		genderField.setBounds(430, 430, 400, 35);
		add(genderField);

		registerBtn = new JButton("Regístrate");
		registerBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		registerBtn.setBackground(new Color(30, 55, 92));
		registerBtn.setBounds(480, 480, 300, 40);
		registerBtn.setForeground(new Color(230, 230, 230));
		registerBtn.setBorder(emptyBorder);
		add(registerBtn);

		loginBtn = new JButton("¿Ya tienes una cuenta? Inicia sesión");
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

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JTextField getGenderField() {
		return genderField;
	}

	public void setGenderField(JTextField genderField) {
		this.genderField = genderField;
	}

	public JTextField getBorndate() {
		return borndate;
	}

	public void setBorndate(JTextField borndate) {
		this.borndate = borndate;
	}

	public JButton getRegisterBtn() {
		return registerBtn;
	}

	public void setRegisterBtn(JButton registerBtn) {
		this.registerBtn = registerBtn;
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
	
}
