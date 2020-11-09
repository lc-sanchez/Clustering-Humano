package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import logic.Clustering;
import models.Persona;

public class NuevaPersonaView extends JFrame{

	private static final long serialVersionUID = 1L;
	public Clustering cluster;
	
	public NuevaPersonaView(Clustering cluster) {
		//Se establecen las caracteristicas de la ventana agregarPersona
		this.setBounds(500, 50, 500, 600);
		this.setTitle("Nueva Persona");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(20, 20, 70, 25);
		this.getContentPane().add(lblNewLabel);
		
		JTextArea areaParaCompletar = new JTextArea();
		areaParaCompletar.setTabSize(8);
		areaParaCompletar.setLineWrap(true);
		areaParaCompletar.setBounds(100, 22, 153, 23);
		this.getContentPane().add(areaParaCompletar);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione el nivel de interes (del 1 al 5) de la persona por los:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 50, 402, 37);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDeportes = new JLabel("Deportes:");
		lblDeportes.setBounds(25, 120, 60, 14);
		this.getContentPane().add(lblDeportes);
		
		JLabel lblDeportes_1 = new JLabel("Musica");
		lblDeportes_1.setBounds(25, 190, 60, 14);
		this.getContentPane().add(lblDeportes_1);
		
		JLabel lblDeportes_2 = new JLabel("Espectaculo:");
		lblDeportes_2.setBounds(25, 260, 80, 14);
		this.getContentPane().add(lblDeportes_2);
		
		JLabel lblDeportes_3 = new JLabel("Ciencia:");
		lblDeportes_3.setBounds(25, 330, 60, 14);
		this.getContentPane().add(lblDeportes_3);
		
		JButton main = new JButton("Enviar Formulario");
		main.setBounds(150, 450, 200, 50);
		this.getContentPane().add(main);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120 , 110, 235, 33);
		comboBox.setModel(new DefaultComboBoxModel(new String[]
		{"1", "2", "3", "4", "5"}));
		this.getContentPane().add(comboBox);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(120 , 180, 235, 33);
		comboBox2.setModel(new DefaultComboBoxModel(new String[]
		{"1", "2", "3", "4", "5"}));
		this.getContentPane().add(comboBox2);
		
		JComboBox comboBox3 = new JComboBox();
		comboBox3.setBounds(120 , 250, 235, 33);
		comboBox3.setModel(new DefaultComboBoxModel(new String[]
		{"1", "2", "3", "4", "5"}));
		this.getContentPane().add(comboBox3);
		
		JComboBox comboBox4 = new JComboBox();
		comboBox4.setBounds(120 , 320, 235, 33);
		comboBox4.setModel(new DefaultComboBoxModel(new String[]
		{"1", "2", "3", "4", "5"}));
		this.getContentPane().add(comboBox4);
		
		//Se agrega boton para enviar y volver
		main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String area = areaParaCompletar.getText();
				if(cluster.existeNombreEnPersonas(area)) {
					JOptionPane.showMessageDialog(getFrame(), "Nombre ya usado, utilice otro.");
				}
				else {
					int interesDeportes = comboBox.getSelectedIndex();
					
					int interesMusica = comboBox.getSelectedIndex();
					
					int interesEspectaculo = comboBox.getSelectedIndex();
					
					int interesCiencia = comboBox.getSelectedIndex();	
					
					Persona nuevaPersona = new Persona(area, interesDeportes, interesMusica, interesEspectaculo, interesCiencia);
					cluster.agregarPersona(nuevaPersona);
					dispose();
				}
			}
		});
	}
	
	private JFrame getFrame(){
	    return this;
	}
	

}
