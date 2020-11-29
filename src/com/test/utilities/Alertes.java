package com.test.utilities;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Alertes {

	public static void error(Component parentComponent, String title, String message) {
		JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.ERROR_MESSAGE);
	}

	public static void error(Component parentComponent, String message) {
		error(parentComponent, "Erreur", message);
	}

	public static void info(Component parentComponent, String title, String message) {
		JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void info(Component parentComponent, String message) {
		error(parentComponent, "Information", message);
	}
	
	

	

}
