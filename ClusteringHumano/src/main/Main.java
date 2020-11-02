package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import view.MainView;


public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			 //Create our view
			JFrame frame = new JFrame();
	       // MainView view = new MainView(frame);
	         
	       
			public void run() {
				try {
					//view.inicializar();
	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
