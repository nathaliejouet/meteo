package com.test.application;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Application {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {

			MainFrame mainFrame = new MainFrame("Station Météo");
			mainFrame.setResizable(false);
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setLocationRelativeTo(null);
			mainFrame.pack();
			mainFrame.setVisible(true);

		});
	}
}