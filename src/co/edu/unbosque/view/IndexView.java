package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class IndexView extends JPanel {

	private JPanel img;
	private JLabel titleLbl;
	private JButton fileBtn, registerBtn, loginBtn;
	Border emptyBorder = BorderFactory.createEmptyBorder();

	public IndexView() {
		
		
		initializeComponents();
		
		setBackground(Color.white);

	}

	public void initializeComponents() {
		// Panel size: 1260x590
		
		img = new JPanel();
		img.setBackground(Color.lightGray);
		img.setBounds(455, 30, 350, 350);
		add(img);

		titleLbl = new JLabel("Bienvenido");
		titleLbl.setFont(new Font("Roboto", Font.BOLD, 24));
		titleLbl.setBounds(560, 380, 170, 50);
		add(titleLbl);

		fileBtn = new JButton("+ Buscar archivos de usuario");
		fileBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		fileBtn.setBackground(new Color(230, 230, 230));
		fileBtn.setForeground(new Color(30, 55, 92));
		fileBtn.setBounds(480, 435, 300, 40);
		fileBtn.setBorder(emptyBorder);
		add(fileBtn);

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

	public JButton getFileBtn() {
		return fileBtn;
	}

	public void setFileBtn(JButton fileBtn) {
		this.fileBtn = fileBtn;
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

}
