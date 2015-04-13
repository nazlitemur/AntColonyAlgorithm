package main.gui;

import javax.swing.JFrame;





public class Colonization {
	
	
	public static void main(String[] args) {

		Board colonization = new Board();
		colonization.setTitle("Colonization Board!");
		colonization.setSize(550, 550);

		colonization.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colonization.setLocationRelativeTo(null);
		colonization.setVisible(true);
		colonization.setResizable(false);
	}

}
