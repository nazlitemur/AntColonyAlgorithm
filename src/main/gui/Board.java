package main.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

// import java.awt.geom.Area;  check for this library 

public class Board extends JFrame {
	/*
	 * Creation of GRID Division of grid into AREAS Definition of Ant in terms
	 * of visual Definition of Resources in terms of visual Definition of
	 * Movement Capabilities in terms of visual
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Cell[][] cells = new Cell[10][10];
	// private final Areas[][] areas = new Areas[2][2];

	JButton jbtnExit = new JButton("Exit");

	public Board() {
		JPanel panel = new JPanel(new GridLayout(10, 10, 1, 1));
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				panel.add(cells[i][j] = new Cell());
			}
			/*
			 * for (int j = 0; j < 10; j++) { panel.add((areas[i][j] = new
			 * Areas()); }
			 */
		}

		panel.setBorder(new LineBorder(Color.BLACK, 1));
		panel.setBackground(Color.BLUE);

		add(panel, BorderLayout.CENTER);

		add(jbtnExit, BorderLayout.NORTH);

		jbtnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

	}

	public boolean isFull(char token) {
		for (int i = 0; i < 10; i++) {
			if ((cells[i][0].getToken() == token)
					&& (cells[i][1].getToken() == token)
					&& (cells[i][2].getToken() == token)) {
				return true;
			}
		}

		for (int j = 0; j < 10; j++) {
			if ((cells[0][j].getToken() == token)
					&& (cells[1][j].getToken() == token)
					&& (cells[2][j].getToken() == token)) {
				return true;
			}
		}
		if ((cells[0][0].getToken() == token)
				&& (cells[1][1].getToken() == token)
				&& (cells[2][2].getToken() == token)) {
			return true;
		}

		return (cells[0][2].getToken() == token)
				&& (cells[1][1].getToken() == token)
				&& (cells[2][0].getToken() == token);
	}

	public class Cell extends JPanel {

		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;
		private char token = ' ';

		public Cell() {
			setBorder(new LineBorder(Color.BLACK, 2));
			addMouseListener(new MyMouseListener());
		}

		public char getToken() {
			return token;
		}

		public void setToken(char c) {
			token = c;
			repaint();
		}

		/*
		 * public class Areas extends JPanel {
		 * 
		 * private static final long serialVersionUID = 1L; private char token =
		 * ' ';
		 * 
		 * public Areas() { setBorder(new LineBorder(Color.YELLOW, 2));
		 * addMouseListener(new MyMouseListener()); }
		 * 
		 * public char getToken() { return token; }
		 * 
		 * public void setToken(char c) { token = c; repaint(); }
		 * 
		 * }
		 */

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (token == ':') {

				g.setColor(Color.BLACK);
				g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
				g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);

			} else if (token == ' ') {
				g.setColor(Color.CYAN);
				g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
				g.fillOval(10, 10, getWidth() - 20, getHeight() - 20);

			}
		}

		private class MyMouseListener extends MouseAdapter {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

		}

	}

}
