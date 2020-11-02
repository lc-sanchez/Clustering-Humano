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

import view.VerPersonasView;

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
		this.setBounds(200, 50, 500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		//Se agrega boton para ver las personas
		JButton verPersonasBoton = new JButton("Ver Personas");
		verPersonasBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerPersonasView verPersonas = new VerPersonasView();
				verPersonas.setVisible(true);
			}
		});
		verPersonasBoton.setBounds(213, 193, 89, 23);
		this.getContentPane().add(verPersonasBoton);
		this.setVisible(true);
	}

}
