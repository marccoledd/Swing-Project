package com.xiar.decision;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.xiar.decision.GUI.MainWindow;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MainWindow("Swing Project");
				frame.setSize(500, 400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}
