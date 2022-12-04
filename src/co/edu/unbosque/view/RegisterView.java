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

	final static String LOGO_PATH = "datos/logo.png";
	private JLabel img;
	private JLabel userLbl, titleLbl, nameLbl, emailLbl, bornLbl, genderLbl, salaryLbl, changedLbl, heightLbl ;
	private JTextField userField, emailField, nameField, bornDate, salaryField, heightField;
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
		
		userLbl = new JLabel("Usuario:");
		userLbl.setFont(new Font("Roboto", Font.BOLD, 12));
		userLbl.setBounds(290, 175, 270, 50);
		add(userLbl);
		
		userField = new JTextField();
		userField.setBackground(new Color(230, 230, 230));
		userField.setFont(new Font("Roboto", Font.BOLD, 12));
		userField.setBorder(emptyBorder);
		userField.setBounds(430, 175, 370, 35);
		add(userField);

		nameLbl = new JLabel("Nombre:");
		nameLbl.setFont(new Font("Roboto", Font.BOLD, 12));
		nameLbl.setBounds(290, 220, 270, 50);
		add(nameLbl);

		nameField = new JTextField();
		nameField.setBackground(new Color(230, 230, 230));
		nameField.setFont(new Font("Roboto", Font.BOLD, 12));
		nameField.setBorder(emptyBorder);
		nameField.setBounds(430, 220, 370, 35);
		add(nameField);
		
		emailLbl = new JLabel("Email:");
		emailLbl.setFont(new Font("Roboto", Font.BOLD, 12));
		emailLbl.setBounds(290, 265, 270, 50);
		add(emailLbl);

		emailField = new JTextField("");
		emailField.setFont(new Font("Roboto", Font.BOLD, 12));
		emailField.setBackground(new Color(230, 230, 230));
		emailField.setBorder(emptyBorder);
		emailField.setBounds(430, 265, 370, 35);
		add(emailField);
		
		bornLbl = new JLabel("Fecha de Nacimiento:");
		bornLbl.setFont(new Font("Roboto", Font.BOLD, 12));
		bornLbl.setBounds(290, 310, 270, 50);
		add(bornLbl);

		bornDate = new JTextField("");
		bornDate.setFont(new Font("Roboto", Font.BOLD, 12));
		bornDate.setBackground(new Color(230, 230, 230));
		bornDate.setBorder(emptyBorder);
		bornDate.setBounds(430, 310, 370, 35);
		add(bornDate);

		genderLbl = new JLabel("Genero:");
		genderLbl.setFont(new Font("Roboto", Font.BOLD, 12));
		genderLbl.setBounds(290, 350, 270, 50);
		add(genderLbl);

		genderField = new JComboBox<String>(opciones);
		genderField.setFont(new Font("Roboto", Font.BOLD, 12));
		genderField.setBackground(new Color(230, 230, 230));
		genderField.setBorder(emptyBorder);
		genderField.setActionCommand("gender");
		genderField.setBounds(430, 350, 370, 35);
		add(genderField);
		
		changedLbl = new JLabel("Salario:");
		changedLbl.setFont(new Font("Roboto", Font.BOLD, 12));
		changedLbl.setBounds(290, 385, 270, 50);
		add(changedLbl);
		
		salaryField = new JTextField("");
		salaryField.setBackground(new Color(230, 230, 230));
		salaryField.setFont(new Font("Roboto", Font.BOLD, 12));
		salaryField.setBorder(emptyBorder);
		salaryField.setBounds(430, 385, 370, 35);
		salaryField.setVisible(true);
		add(salaryField);

		genderG = new JComboBox<String>(opcionesD);
		genderG.setFont(new Font("Roboto", Font.BOLD, 12));
		genderG.setBackground(new Color(230, 230, 230));
		genderG.setBorder(emptyBorder);
		genderG.setActionCommand("marriage");
		genderG.setVisible(false);
		genderG.setBounds(430, 385, 370, 35);
		add(genderG);

		heightLbl = new JLabel("Estatura:");
		heightLbl.setFont(new Font("Roboto", Font.BOLD, 12));
		heightLbl.setBounds(290, 430, 410, 50);
		add(heightLbl);

		heightField = new JTextField("");
		heightField.setBackground(new Color(230, 230, 230));
		heightField.setFont(new Font("Roboto", Font.BOLD, 12));
		heightField.setBorder(emptyBorder);
		heightField.setBounds(430, 430, 370, 35);
		heightField.setVisible(true);
		add(heightField);

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
	
	public void limpiarCampos() {
		userField.setText("");
		heightField.setText("");
		emailField.setText("");
		nameField.setText("");
		bornDate.setText("");
		salaryField.setText("");
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

	/**
	 * @return the userField
	 */
	public JTextField getUserField() {
		return userField;
	}

	/**
	 * @param userField the userField to set
	 */
	public void setUserField(JTextField userField) {
		this.userField = userField;
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

	/**
	 * @return the nameLbl
	 */
	public JLabel getNameLbl() {
		return nameLbl;
	}

	/**
	 * @param nameLbl the nameLbl to set
	 */
	public void setNameLbl(JLabel nameLbl) {
		this.nameLbl = nameLbl;
	}

	/**
	 * @return the emailLbl
	 */
	public JLabel getEmailLbl() {
		return emailLbl;
	}

	/**
	 * @param emailLbl the emailLbl to set
	 */
	public void setEmailLbl(JLabel emailLbl) {
		this.emailLbl = emailLbl;
	}

	/**
	 * @return the bornLbl
	 */
	public JLabel getBornLbl() {
		return bornLbl;
	}

	/**
	 * @param bornLbl the bornLbl to set
	 */
	public void setBornLbl(JLabel bornLbl) {
		this.bornLbl = bornLbl;
	}

	/**
	 * @return the genderLbl
	 */
	public JLabel getGenderLbl() {
		return genderLbl;
	}

	/**
	 * @param genderLbl the genderLbl to set
	 */
	public void setGenderLbl(JLabel genderLbl) {
		this.genderLbl = genderLbl;
	}

	/**
	 * @return the salaryLbl
	 */
	public JLabel getSalaryLbl() {
		return salaryLbl;
	}

	/**
	 * @param salaryLbl the salaryLbl to set
	 */
	public void setSalaryLbl(JLabel salaryLbl) {
		this.salaryLbl = salaryLbl;
	}

	/**
	 * @return the changedLbl
	 */
	public JLabel getChangedLbl() {
		return changedLbl;
	}

	/**
	 * @param changedLbl the changedLbl to set
	 */
	public void setChangedLbl(JLabel changedLbl) {
		this.changedLbl = changedLbl;
	}

	/**
	 * @return the heightField
	 */
	public JTextField getHeightField() {
		return heightField;
	}

	/**
	 * @param heightField the heightField to set
	 */
	public void setHeightField(JTextField heightField) {
		this.heightField = heightField;
	}
	

}
