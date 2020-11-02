package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NuevaPersonaView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NuevaPersonaView() {
		//Se establecen las caracteristicas de la ventana agregarPersona
		this.setBounds(600, 50, 500, 600);
		this.setTitle("Nueva Persona");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton main = new JButton("Enviar Formulario");
		main.setBounds(20, 50, 200, 50);
		this.getContentPane().add(main);
		
		//Se agrega boton para enviar y volver
		main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
