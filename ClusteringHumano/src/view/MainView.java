package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

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
		this.setBounds(200, 50, 300, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		//************** SE AGREGAN LOS BOTONES *********************************//
		
		//Se agrega boton para agregar persona nueva
		JButton agregarNuevaPersonaBoton = new JButton("Agregar nueva persona");
		agregarNuevaPersonaBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaPersonaView agregarPersona = new NuevaPersonaView();
				agregarPersona.setVisible(true);
				
				
			}
		});
		agregarNuevaPersonaBoton.setBounds(50, 100, 200, 50);
		this.getContentPane().add(agregarNuevaPersonaBoton);
		
		//Se agrega boton para ver las personas
		JButton verPersonasBoton = new JButton("Ver personas");
		verPersonasBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerPersonasView verPersonas = new VerPersonasView();
				verPersonas.setVisible(true);
				
				
			}
		});
		verPersonasBoton.setBounds(50, 170, 200, 50);
		this.getContentPane().add(verPersonasBoton);
		
		//Se agrega boton para ver los grupos
		JButton verGruposBoton = new JButton("Ver grupos");
		verGruposBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerGruposView verGrupos = new VerGruposView();
				verGrupos.setVisible(true);
				
			}
		});
		verGruposBoton.setBounds(50, 240, 200, 50);
		this.getContentPane().add(verGruposBoton);
		
		//Se agrega boton para armar los grupos/correr el algoritmo
		JButton armarGruposBoton = new JButton("Armar grupos");
		armarGruposBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aca se llamaria al algoritmo del camino minimo
				
			}
		});
		armarGruposBoton.setBounds(50, 310, 200, 50);
		this.getContentPane().add(armarGruposBoton);
		
		this.setVisible(true);
					
	}

}
