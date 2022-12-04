package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class IndexView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static String LOGO_PATH = "datos/vudu.png";
	private JLabel img;
	private JLabel titleLbl;
	private JButton registerBtn, loginBtn;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	Color colorbg = new Color(244, 236, 224);

	public IndexView() {

		initializeComponents();

		setBackground(colorbg);

	}

	public void initializeComponents() {
		// Panel size: 1260x590

		img = new JLabel();
		img.setBackground(colorbg);
		img.setBounds(455, 30, 350, 350);
		img.setIcon(createLogo());
		add(img);

		titleLbl = new JLabel("Bienvenido");
		titleLbl.setFont(new Font("Roboto", Font.BOLD, 24));
		titleLbl.setBounds(560, 380, 170, 50);
		add(titleLbl);

		registerBtn = new JButton("Reg�strate");
		registerBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		registerBtn.setBackground(new Color(30, 55, 92));
		registerBtn.setBounds(480, 480, 300, 40);
		registerBtn.setForeground(new Color(230, 230, 230));
		registerBtn.setActionCommand("register");
		registerBtn.setBorder(emptyBorder);
		add(registerBtn);

		loginBtn = new JButton("�Ya tienes una cuenta? Inicia sesi�n");
		loginBtn.setFont(new Font("Roboto", Font.BOLD, 12));
		loginBtn.setBackground(Color.white);
		loginBtn.setBounds(480, 530, 300, 30);
		loginBtn.setActionCommand("login");
		loginBtn.setBorder(emptyBorder);
		add(loginBtn);

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
