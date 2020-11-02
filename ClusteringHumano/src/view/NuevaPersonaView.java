package view;

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
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.getContentPane().setLayout(null);
	}

}
