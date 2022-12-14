package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logic.Clustering;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Clustering cluster;
	
	
	public MainView(Clustering clusterPasado) {
		cluster = clusterPasado;
		inicializar();
	} 
	
	public void inicializar() {
		//Se establecen las caracteristicas de la ventana principal
		this.setBounds(200, 50, 250, 400);
		this.setTitle("Clustering Humano");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		
		
		//************** SE AGREGAN LOS BOTONES *********************************//
		
		//Creamos todos los botones
		JButton agregarNuevaPersonaBoton = new JButton("Agregar nueva persona");
		JButton verPersonasBoton = new JButton("Ver personas");
		JButton verGruposBoton = new JButton("Ver grupos");
		verGruposBoton.setEnabled(false);
		JButton armarGruposBoton = new JButton("Armar grupos");
		armarGruposBoton.setEnabled(false);
		
		//Se agrega boton para agregar persona nueva
		agregarNuevaPersonaBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cluster.getCantPersonas()>=1) {
					armarGruposBoton.setEnabled(true);
				}
				@SuppressWarnings("serial")
				NuevaPersonaView agregarPersona = new NuevaPersonaView(cluster) {
					@Override
					public void dispose() {
						getFrame().setVisible(true);
						super.dispose();
					}
				};
				agregarPersona.setVisible(true);
				
				dispose();
			}
		});
		agregarNuevaPersonaBoton.setBounds(20, 50, 200, 50);
		this.getContentPane().add(agregarNuevaPersonaBoton);
		
		//Se agrega boton para ver las personas
		verPersonasBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("serial")
				VerPersonasView verPersonas = new VerPersonasView(cluster){
					@SuppressWarnings("unused")
					public void dispose() {
						getFrame().setVisible(true);
						super.frame.dispose();
					}
				};
				verPersonas.inicializarVerPersonasView();
				verPersonas.setVisible(true);
				dispose();
			}
		});
		verPersonasBoton.setBounds(20, 120, 200, 50);
		this.getContentPane().add(verPersonasBoton);
		 
		//Se agrega boton para ver los grupos
		verGruposBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("serial")
				VerGruposView verGrupos = new VerGruposView(cluster){
					@SuppressWarnings("unused")
					public void dispose() {
						getFrame().setVisible(true);
						super.frame.dispose();
					}
				};
				verGrupos.inicializarVerGruposView();
				dispose();
			}
		});
		verGruposBoton.setBounds(20, 190, 200, 50);
		this.getContentPane().add(verGruposBoton);
		
		//Se agrega boton para armar los grupos/correr el algoritmo
		armarGruposBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aca se llamaria al algoritmo del camino minimo
				cluster.ejecutarClustering();
				verGruposBoton.setEnabled(true);
				JOptionPane.showMessageDialog(getFrame(), "Se han armado los grupos satisfactoriamente");
			}
		});
		armarGruposBoton.setBounds(20, 260, 200, 50);
		this.getContentPane().add(armarGruposBoton);
		
		this.setVisible(true);
					
	}
	
	private JFrame getFrame(){
	    return this;
	}
	
	
	

}
