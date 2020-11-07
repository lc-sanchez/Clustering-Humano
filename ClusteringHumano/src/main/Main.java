package main;

import java.awt.EventQueue;

import logic.Clustering;
import view.MainView;

public class Main {
	public static void main(String[] args) {
		Clustering cluster = new Clustering();
		EventQueue.invokeLater(new Runnable() {
	        MainView view = new MainView(cluster);	                
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
