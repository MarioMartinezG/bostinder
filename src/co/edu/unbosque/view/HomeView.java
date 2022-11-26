package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class HomeView extends JPanel{
	private JPanel userImg ,img ;
	private JLabel titleLbl, nameLbl, descriptionLbl;
	private JButton backBtn, likeBtn, declineBtn;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	
	
		public HomeView() {
			
	setBackground(Color.white);
	initializeComponents();
}

public void initializeComponents() {
	// Panel size: 1260x590

	img = new JPanel();
	img.setBackground(Color.lightGray);
	img.setBounds(60, 30, 70, 70);
	add(img);
	
	titleLbl = new JLabel("Bienvenido/a, estos son los perfiles");
	titleLbl.setFont(new Font("Roboto", Font.BOLD, 20));
	titleLbl.setBounds(140, 30, 300, 50);
	add(titleLbl);
	
	backBtn = new JButton("<");
	backBtn.setFont(new Font("Roboto", Font.BOLD, 12));
	backBtn.setBackground(Color.white);
	backBtn.setBounds(10, 10, 50, 50);
	backBtn.setActionCommand("back");
	backBtn.setBorder(emptyBorder);
	add(backBtn);
	
}

public JPanel getUserImg() {
	return userImg;
}

public void setUserImg(JPanel userImg) {
	this.userImg = userImg;
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
