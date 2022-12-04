package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class HomeView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static String LOGO_PATH = "datos/logo.png";
	private JPanel userImg;
	private JLabel img;
	private JLabel titleLbl, nameLbl, descriptionLbl, salaryLbl, marriageLbl;
	private JButton backBtn, likeBtn, declineBtn;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	Color colorbg = new Color(244, 236, 224);

	public HomeView() {

		setBackground(colorbg);
		initializeComponents();
	}

	public void initializeComponents() {
		// Panel size: 1260x590

		img = new JLabel();
		img.setBackground(Color.lightGray);
		img.setBounds(60, 20, 70, 70);
		img.setIcon(createLogo());
		add(img);

		titleLbl = new JLabel("Bienvenido/a, estos son los perfiles");
		titleLbl.setFont(new Font("Roboto", Font.BOLD, 20));
		titleLbl.setBounds(140, 30, 400, 50);
		add(titleLbl);

		nameLbl = new JLabel("AQUI VA EL NOMBRE, EDAD");
		nameLbl.setFont(new Font("Roboto", Font.BOLD, 20));
		nameLbl.setBounds(480, 130, 400, 50);
		add(nameLbl);
		
		descriptionLbl = new JLabel("DESCRIPCION");
		descriptionLbl.setFont(new Font("Roboto", Font.BOLD, 14));
		descriptionLbl.setBounds(480, 190, 400, 50);
		add(descriptionLbl);
		
		salaryLbl = new JLabel("Salario");
		salaryLbl.setFont(new Font("Roboto", Font.BOLD, 14));
		salaryLbl.setBounds(480, 250, 400, 50);
		add(salaryLbl);
		salaryLbl.setVisible(true);
		
		marriageLbl = new JLabel("Divorciada \n" + " Si/No");
		marriageLbl.setFont(new Font("Roboto", Font.BOLD, 14));
		marriageLbl.setBounds(480, 250, 400, 50);
		add(marriageLbl);
		marriageLbl.setVisible(false);
		
		likeBtn = new JButton("LIKE");
		likeBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		likeBtn.setBackground(Color.GREEN);
		likeBtn.setBounds(480, 430, 300, 40);
		likeBtn.setForeground(colorbg);
		likeBtn.setActionCommand("home-like");
		likeBtn.setBorder(emptyBorder);
		add(likeBtn);

		userImg = new JPanel();
		userImg.setBackground(Color.lightGray);
		userImg.setBounds(70, 120, 400, 450);
		add(userImg);

		declineBtn = new JButton("PASO");
		declineBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		declineBtn.setBackground(Color.red);
		declineBtn.setBounds(480, 490, 300, 40);
		declineBtn.setForeground(colorbg);
		declineBtn.setActionCommand("home-refuse");
		declineBtn.setBorder(emptyBorder);
		add(declineBtn);

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

	public JPanel getUserImg() {
		return userImg;
	}

	public void setUserImg(JPanel userImg) {
		this.userImg = userImg;
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

	public JLabel getNameLbl() {
		return nameLbl;
	}

	public void setNameLbl(JLabel nameLbl) {
		this.nameLbl = nameLbl;
	}

	public JLabel getDescriptionLbl() {
		return descriptionLbl;
	}

	public void setDescriptionLbl(JLabel descriptionLbl) {
		this.descriptionLbl = descriptionLbl;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	public JButton getLikeBtn() {
		return likeBtn;
	}

	public void setLikeBtn(JButton likeBtn) {
		this.likeBtn = likeBtn;
	}

	public JButton getDeclineBtn() {
		return declineBtn;
	}

	public void setDeclineBtn(JButton declineBtn) {
		this.declineBtn = declineBtn;
	}

}
