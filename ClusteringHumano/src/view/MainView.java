package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import View.VentanaSecundaria;

public class MainView {
	private JFrame frame;
	
	public MainView() {
		inicializar();
	}
	
	public void inicializar() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Abrir Ventana secundaria");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VentanaSecundaria ventana = new VentanaSecundaria();
				//ventana.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(213, 193, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
