package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class AdminView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel statsPanel, pdfPanel, usersPanel;
	private JButton toStatsBtn, toPdfBtn, backBtn;
	private JLabel statsLbl, pdfLbl;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	Color colorbg = new Color(244, 236, 224);

	public AdminView() {

		setBackground(Color.white);
		initializeComponents();

	}

	public void initializeComponents() {
		
		addStatsPanel();
		addPdfPanel();
		toStatsBtn = new JButton("Estadísticas");
		toStatsBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		toStatsBtn.setBackground(new Color(30, 55, 92));
		toStatsBtn.setBounds(5, 20, 300, 40);
		toStatsBtn.setForeground(new Color(230, 230, 230));
		toStatsBtn.setActionCommand("admin_stats");
		toStatsBtn.setBorder(emptyBorder);
		add(toStatsBtn);

		toPdfBtn = new JButton("Ver PDF");
		toPdfBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		toPdfBtn.setBackground(new Color(30, 55, 92));
		toPdfBtn.setBounds(5, 70, 300, 40);
		toPdfBtn.setForeground(new Color(230, 230, 230));
		toPdfBtn.setActionCommand("admin_pdf");
		toPdfBtn.setBorder(emptyBorder);
		add(toPdfBtn);

		backBtn = new JButton("<");
		backBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		backBtn.setBackground(new Color(30, 55, 92));
		backBtn.setBounds(5, 70, 300, 40);
		backBtn.setForeground(new Color(230, 230, 230));
		backBtn.setActionCommand("back");
		backBtn.setBorder(emptyBorder);
		add(backBtn);

	}

	public void addStatsPanel() {
		statsPanel = new JPanel();
		statsPanel.setBackground(new Color(212, 208, 199));
		statsPanel.setBounds(0, 0, 1200, 600);

		statsPanel.setVisible(true);
		add(statsPanel);

	}

	public void addPdfPanel() {
		pdfPanel = new JPanel();
		pdfPanel.setBackground(new Color(212, 208, 199));
		pdfPanel.setBounds(0, 0, 1200, 600);

		pdfPanel.setVisible(false);
		add(pdfPanel);
	}

	public void addUsersPanel() {
		usersPanel = new JPanel();
		usersPanel.setBackground(new Color(212, 208, 199));
		usersPanel.setBounds(0, 0, 1200, 600);
	}

	public void addCompUsersPanel() {

	}

	/**
	 * @return the statsPanel
	 */
	public JPanel getStatsPanel() {
		return statsPanel;
	}

	/**
	 * @param statsPanel the statsPanel to set
	 */
	public void setStatsPanel(JPanel statsPanel) {
		this.statsPanel = statsPanel;
	}

	/**
	 * @return the pdfPanel
	 */
	public JPanel getPdfPanel() {
		return pdfPanel;
	}

	/**
	 * @param pdfPanel the pdfPanel to set
	 */
	public void setPdfPanel(JPanel pdfPanel) {
		this.pdfPanel = pdfPanel;
	}

	/**
	 * @return the toStatsBtn
	 */
	public JButton getToStatsBtn() {
		return toStatsBtn;
	}

	/**
	 * @param toStatsBtn the toStatsBtn to set
	 */
	public void setToStatsBtn(JButton toStatsBtn) {
		this.toStatsBtn = toStatsBtn;
	}

	/**
	 * @return the toPdfBtn
	 */
	public JButton getToPdfBtn() {
		return toPdfBtn;
	}

	/**
	 * @param toPdfBtn the toPdfBtn to set
	 */
	public void setToPdfBtn(JButton toPdfBtn) {
		this.toPdfBtn = toPdfBtn;
	}

	/**
	 * @return the backBtn
	 */
	public JButton getBackBtn() {
		return backBtn;
	}

	/**
	 * @param backBtn the backBtn to set
	 */
	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	/**
	 * @return the statsLbl
	 */
	public JLabel getStatsLbl() {
		return statsLbl;
	}

	/**
	 * @param statsLbl the statsLbl to set
	 */
	public void setStatsLbl(JLabel statsLbl) {
		this.statsLbl = statsLbl;
	}

	/**
	 * @return the pdfLbl
	 */
	public JLabel getPdfLbl() {
		return pdfLbl;
	}

	/**
	 * @param pdfLbl the pdfLbl to set
	 */
	public void setPdfLbl(JLabel pdfLbl) {
		this.pdfLbl = pdfLbl;
	}

}
