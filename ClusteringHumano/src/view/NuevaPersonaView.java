package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class NuevaPersonaView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	
	public NuevaPersonaView() {
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
		
		JTextArea txtrMartinGarcia = new JTextArea();
		txtrMartinGarcia.setTabSize(8);
		txtrMartinGarcia.setLineWrap(true);
		txtrMartinGarcia.setBounds(100, 22, 153, 23);
		this.getContentPane().add(txtrMartinGarcia);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione el nivel de interes (del 1 al 5) de la persona por los:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 50, 402, 37);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDeportes = new JLabel("Deportes:");
		lblDeportes.setBounds(10, 104, 48, 14);
		this.getContentPane().add(lblDeportes);
		
		JLabel lblDeportes_1 = new JLabel("Musica");
		lblDeportes_1.setBounds(10, 129, 48, 14);
		this.getContentPane().add(lblDeportes_1);
		
		JLabel lblDeportes_2 = new JLabel("Espectaculo:");
		lblDeportes_2.setBounds(10, 164, 48, 14);
		this.getContentPane().add(lblDeportes_2);
		
		JLabel lblDeportes_3 = new JLabel("Deportes:");
		lblDeportes_3.setBounds(10, 195, 48, 14);
		this.getContentPane().add(lblDeportes_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(64, 100, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(104, 100, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(157, 100, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(216, 100, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("5");
		buttonGroup.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setBounds(273, 100, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("1");
		buttonGroup_1.add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.setBounds(64, 129, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("2");
		buttonGroup_1.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBounds(104, 129, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("3");
		buttonGroup_1.add(rdbtnNewRadioButton_2_1);
		rdbtnNewRadioButton_2_1.setBounds(157, 129, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_2_1);
		
		JRadioButton rdbtnNewRadioButton_3_1 = new JRadioButton("4");
		buttonGroup_1.add(rdbtnNewRadioButton_3_1);
		rdbtnNewRadioButton_3_1.setBounds(216, 129, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_3_1);
		
		JRadioButton rdbtnNewRadioButton_4_1 = new JRadioButton("5");
		buttonGroup_1.add(rdbtnNewRadioButton_4_1);
		rdbtnNewRadioButton_4_1.setBounds(273, 129, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_4_1);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("1");
		buttonGroup_2.add(rdbtnNewRadioButton_6);
		rdbtnNewRadioButton_6.setBounds(64, 164, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("2");
		buttonGroup_2.add(rdbtnNewRadioButton_1_2);
		rdbtnNewRadioButton_1_2.setBounds(104, 164, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_1_2);
		
		JRadioButton rdbtnNewRadioButton_2_2 = new JRadioButton("3");
		buttonGroup_2.add(rdbtnNewRadioButton_2_2);
		rdbtnNewRadioButton_2_2.setBounds(157, 164, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_2_2);
		
		JRadioButton rdbtnNewRadioButton_3_2 = new JRadioButton("4");
		buttonGroup_2.add(rdbtnNewRadioButton_3_2);
		rdbtnNewRadioButton_3_2.setBounds(216, 164, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_3_2);
		
		JRadioButton rdbtnNewRadioButton_4_2 = new JRadioButton("5");
		buttonGroup_2.add(rdbtnNewRadioButton_4_2);
		rdbtnNewRadioButton_4_2.setBounds(273, 164, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_4_2);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("1");
		buttonGroup_3.add(rdbtnNewRadioButton_7);
		rdbtnNewRadioButton_7.setBounds(64, 195, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_7);
		
		JRadioButton rdbtnNewRadioButton_1_3 = new JRadioButton("2");
		buttonGroup_3.add(rdbtnNewRadioButton_1_3);
		rdbtnNewRadioButton_1_3.setBounds(104, 195, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_1_3);
		
		JRadioButton rdbtnNewRadioButton_2_3 = new JRadioButton("3");
		buttonGroup_3.add(rdbtnNewRadioButton_2_3);
		rdbtnNewRadioButton_2_3.setBounds(157, 195, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_2_3);
		
		JRadioButton rdbtnNewRadioButton_3_3 = new JRadioButton("4");
		buttonGroup_3.add(rdbtnNewRadioButton_3_3);
		rdbtnNewRadioButton_3_3.setBounds(216, 195, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_3_3);
		
		JRadioButton rdbtnNewRadioButton_4_3 = new JRadioButton("5");
		buttonGroup_3.add(rdbtnNewRadioButton_4_3);
		rdbtnNewRadioButton_4_3.setBounds(273, 195, 38, 23);
		this.getContentPane().add(rdbtnNewRadioButton_4_3);
		
		JButton main = new JButton("Enviar Formulario");
		main.setBounds(150, 450, 200, 50);
		this.getContentPane().add(main);
		
		//Se agrega boton para enviar y volver
		main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
