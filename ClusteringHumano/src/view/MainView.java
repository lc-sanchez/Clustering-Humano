package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MainView() {
		inicializar();
	}
	
	public void inicializar() {
		//Se establecen las caracteristicas de la ventana principal
		this.setBounds(200, 50, 250, 400);
		this.setTitle("Clustering Humano");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		//************** SE AGREGAN LOS BOTONES *********************************//
		
		//Creamos todos los botones
		JButton agregarNuevaPersonaBoton = new JButton("Agregar nueva persona");
		JButton verPersonasBoton = new JButton("Ver personas");
		JButton verGruposBoton = new JButton("Ver grupos");
		JButton armarGruposBoton = new JButton("Armar grupos");
		
		//Se agrega boton para agregar persona nueva
		agregarNuevaPersonaBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaPersonaView agregarPersona = new NuevaPersonaView();
				agregarPersona.setVisible(true);
				
			}
		});
		agregarNuevaPersonaBoton.setBounds(20, 50, 200, 50);
		this.getContentPane().add(agregarNuevaPersonaBoton);
		
		//Se agrega boton para ver las personas
		verPersonasBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerPersonasView verPersonas = new VerPersonasView();
				verPersonas.setVisible(true);

			}
		});
		verPersonasBoton.setBounds(20, 120, 200, 50);
		this.getContentPane().add(verPersonasBoton);
		
		//Se agrega boton para ver los grupos
		verGruposBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerGruposView verGrupos = new VerGruposView();
				verGrupos.setVisible(true);
				
			}
		});
		verGruposBoton.setBounds(20, 190, 200, 50);
		this.getContentPane().add(verGruposBoton);
		
		//Se agrega boton para armar los grupos/correr el algoritmo
		armarGruposBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aca se llamaria al algoritmo del camino minimo			
			}
		});
		armarGruposBoton.setBounds(20, 260, 200, 50);
		this.getContentPane().add(armarGruposBoton);
		
		this.setVisible(true);
					
	}
	
	
	

}
