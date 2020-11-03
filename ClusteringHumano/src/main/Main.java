package main;

import java.awt.EventQueue;

import view.MainView;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	        MainView view = new MainView();	                
			public void run() {
				try {
					view.inicializar();	
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
	}


}
