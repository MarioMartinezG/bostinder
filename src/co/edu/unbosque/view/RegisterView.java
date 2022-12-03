package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class RegisterView extends JPanel {

	private JPanel img;
	private JLabel titleLbl;
	private JTextField emailField, nameField, bornDate;
	private JComboBox<String> genderField;
	private JButton registerBtn, loginBtn, backBtn;
	final static String opciones[] = { "Masculino", "Femenino" };
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

		nameField = new JTextField("Nombre");
		nameField.setBackground(new Color(230, 230, 230));
		nameField.setFont(new Font("Roboto", Font.BOLD, 12));
		nameField.setBorder(emptyBorder);
		nameField.setBounds(430, 295, 400, 35);
		add(nameField);

		emailField = new JTextField("Correo electrónico");
		emailField.setFont(new Font("Roboto", Font.BOLD, 12));
		emailField.setBackground(new Color(230, 230, 230));
		emailField.setBorder(emptyBorder);
		emailField.setBounds(430, 340, 400, 35);
		add(emailField);

		bornDate = new JTextField("Fecha de nacimiento");
		bornDate.setFont(new Font("Roboto", Font.BOLD, 12));
		bornDate.setBackground(new Color(230, 230, 230));
		bornDate.setBorder(emptyBorder);
		bornDate.setBounds(430, 385, 400, 35);
		add(bornDate);

		genderField = new JComboBox<String>(opciones);
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
		registerBtn.setActionCommand("valid-access");
		registerBtn.setBorder(emptyBorder);
		add(registerBtn);

		loginBtn = new JButton("¿Ya tienes una cuenta? Inicia sesión");
		loginBtn.setFont(new Font("Roboto", Font.BOLD, 12));
		loginBtn.setBackground(Color.white);
		loginBtn.setBounds(480, 530, 300, 30);
		loginBtn.setActionCommand("login");
		loginBtn.setBorder(emptyBorder);
		add(loginBtn);

		backBtn = new JButton("<");
		backBtn.setFont(new Font("Roboto", Font.BOLD, 12));
		backBtn.setBackground(Color.white);
		backBtn.setBounds(10, 10, 50, 50);
		backBtn.setActionCommand("back");
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

	public JComboBox<String> getGenderField() {
		return genderField;
	}

	public void setGenderField(JComboBox<String> genderField) {
		this.genderField = genderField;
	}

	public JTextField getBornDate() {
		return bornDate;
	}

	public void setBornDate(JTextField bornDate) {
		this.bornDate = bornDate;
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
