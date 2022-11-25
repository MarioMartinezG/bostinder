package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeView extends JPanel{
	private JPanel userImg ,img ;
	private JLabel titleLbl;
	
	
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
	
	titleLbl = new JLabel("Bienvenido/a, regístrate");
	titleLbl.setFont(new Font("Roboto", Font.BOLD, 20));
	titleLbl.setBounds(140, 30, 300, 50);
	add(titleLbl);
	
}
}
