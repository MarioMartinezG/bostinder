package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class RegisterView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static String LOGO_PATH = "datos/logo.png";
	private JLabel img;
	private JLabel titleLbl;
	private JTextField emailField, nameField, bornDate, salaryField, marriageField ;
	private JComboBox<String> genderField, genderG;
	private JButton registerBtn, loginBtn, backBtn;
	final static String opciones[] = { "Masculino", "Femenino" };
	final static String opcionesD[] = { "Si", "No" };
	Border emptyBorder = BorderFactory.createEmptyBorder();
	Color colorbg = new Color(244, 236, 224);

	public RegisterView() {

		setBackground(colorbg);
		initializeComponents();
	}

	public void initializeComponents() {
		// Panel size: 1260x590

		img = new JLabel();
		img.setBackground(Color.lightGray);
		img.setBounds(60, 10, 70, 70);
		img.setIcon(createLogo());
		add(img);

		titleLbl = new JLabel("Bienvenido/a, reg�strate");
		titleLbl.setFont(new Font("Roboto", Font.BOLD, 20));
		titleLbl.setBounds(140, 15, 300, 50);
		add(titleLbl);

		nameField = new JTextField("Nombre");
		nameField.setBackground(new Color(230, 230, 230));
		nameField.setFont(new Font("Roboto", Font.BOLD, 12));
		nameField.setBorder(emptyBorder);
		nameField.setBounds(430, 255, 400, 35);
		add(nameField);

		emailField = new JTextField("Correo electr�nico");
		emailField.setFont(new Font("Roboto", Font.BOLD, 12));
		emailField.setBackground(new Color(230, 230, 230));
		emailField.setBorder(emptyBorder);
		emailField.setBounds(430, 300, 400, 35);
		add(emailField);

		bornDate = new JTextField("Fecha de nacimiento");
		bornDate.setFont(new Font("Roboto", Font.BOLD, 12));
		bornDate.setBackground(new Color(230, 230, 230));
		bornDate.setBorder(emptyBorder);
		bornDate.setBounds(430, 345, 400, 35);
		add(bornDate);

		genderField = new JComboBox<String>(opciones);
		genderField.setFont(new Font("Roboto", Font.BOLD, 12));
		genderField.setBackground(new Color(230, 230, 230));
		genderField.setBorder(emptyBorder);
		genderField.setActionCommand("gender");
		genderField.setBounds(430, 390, 400, 35);
		add(genderField);
		
		emailField = new JTextField("Correo electr�nico");
		emailField.setFont(new Font("Roboto", Font.BOLD, 12));
		emailField.setBackground(new Color(230, 230, 230));
		emailField.setBorder(emptyBorder);
		emailField.setBounds(430, 300, 400, 35);
		add(emailField);
		
		salaryField = new JTextField("Salario");
		salaryField.setBackground(new Color(230, 230, 230));
		salaryField.setFont(new Font("Roboto", Font.BOLD, 12));
		salaryField.setBorder(emptyBorder);
		salaryField.setBounds(430, 435, 400, 35);
		salaryField.setVisible(true);
		add(salaryField);

		genderG = new JComboBox<String>(opcionesD);
		genderG.setFont(new Font("Roboto", Font.BOLD, 12));
		genderG.setBackground(new Color(230, 230, 230));
		genderG.setBorder(emptyBorder);
		genderG.setActionCommand("marriage");
		genderG.setVisible(false);
		genderG.setBounds(430, 435, 400, 35);
		add(genderG);

		registerBtn = new JButton("Reg�strate");
		registerBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		registerBtn.setBackground(new Color(30, 55, 92));
		registerBtn.setBounds(480, 480, 300, 40);
		registerBtn.setForeground(new Color(230, 230, 230));
		registerBtn.setActionCommand("valid-access");
		registerBtn.setBorder(emptyBorder);
		add(registerBtn);

		loginBtn = new JButton("�Ya tienes una cuenta? Inicia sesi�n");
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

	private ImageIcon createLogo() {
		ImageIcon logo = null;
		try {
			BufferedImage img = ImageIO.read(new File(LOGO_PATH));
			Image rImg = img.getScaledInstance(this.img.getWidth(), this.img.getHeight(), Image.SCALE_SMOOTH);
			logo = new ImageIcon(rImg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logo;
	}

	public JLabel getImg() {
		return img;
	}

	public void setImg(JLabel img) {
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

	/**
	 * @return the salaryField
	 */
	public JTextField getSalaryField() {
		return salaryField;
	}

	/**
	 * @param salaryField the salaryField to set
	 */
	public void setSalaryField(JTextField salaryField) {
		this.salaryField = salaryField;
	}

	/**
	 * @return the marriageField
	 */
	public JTextField getMarriageField() {
		return marriageField;
	}

	/**
	 * @param marriageField the marriageField to set
	 */
	public void setMarriageField(JTextField marriageField) {
		this.marriageField = marriageField;
	}

	/**
	 * @return the genderG
	 */
	public JComboBox<String> getGenderG() {
		return genderG;
	}

	/**
	 * @param genderG the genderG to set
	 */
	public void setGenderG(JComboBox<String> genderG) {
		this.genderG = genderG;
	}

}
