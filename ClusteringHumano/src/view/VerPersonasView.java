package view;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.Clustering;
import models.Camino;
import models.Persona;


public class VerPersonasView extends JPanel {

	private static final long serialVersionUID = 1L;
	public Clustering cluster;
	private ArrayList<Integer> coordenadasXUsadas = new ArrayList<Integer>();
	private ArrayList<Integer> coordenadasYUsadas = new ArrayList<Integer>();
	public JFrame frame;
	
	public VerPersonasView(Clustering clusterPasado) {
		cluster=clusterPasado;
	}

	public void inicializarVerPersonasView() {
		//Se establecen las caracteristicas de la ventana verPersonas
		frame = new JFrame("Ver Personas");
        frame.getContentPane().add(new VerPersonasView(cluster));
        //A ver ahora
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(450, 630, 80, 20);
		frame.getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public void paint(Graphics g){
		if(cluster.getCantPersonas()==0) {
			return;
		}
		pintarVertices(g);
		if(cluster.getCantPersonas()>1) {
			pintarAristas(g);
		}
    }
	
	private void pintarVertices(Graphics g) {
	    for (int i = 0 ; i < cluster.getCantPersonas() ; i++) {
	      g.setColor(Color.BLUE);
	      numRandomX();
	      numRandomY();
	      g.fillOval(coordenadasXUsadas.get(i), coordenadasYUsadas.get(i), 40, 40);
	      g.setColor(Color.BLACK);
	      g.drawString(obtenerPersona(i), coordenadasXUsadas.get(i)+15, coordenadasYUsadas.get(i)-5);
	    }
	  }
	
	private String obtenerPersona(int i) {
		return cluster.listaPersonas.get(i).getNombre();
	}

	private void pintarAristas(Graphics g) {
		for (int i = 0 ; i < cluster.getCantPersonas()-1; i++) {
			for(int j = i ; j < cluster.getCantPersonas()-1; j++) {
				g.setColor(Color.RED);
				g.drawLine(coordenadasXUsadas.get(i)+20,coordenadasYUsadas.get(i)+20, 
						coordenadasXUsadas.get(j+1)+20,coordenadasYUsadas.get(j+1)+20);
				
				g.setColor(Color.BLACK);
				g.drawString(obtenerPeso(cluster.listaPersonas.get(i),cluster.listaPersonas.get(j+1)),
						obtenerCoordenada(coordenadasXUsadas.get(i),coordenadasXUsadas.get(j+1)),
						obtenerCoordenada(coordenadasYUsadas.get(i),coordenadasYUsadas.get(j+1)));
			}
		}
	}

	private int obtenerCoordenada(Integer integer, Integer integer2) {
		int ret = ((integer+integer2)/2)+20;
		return ret;
	}

	private String obtenerPeso(Persona persona1, Persona persona2) {
		return Integer.toString(cluster.getSimiliaridad(persona1, persona2));
	}

	private void numRandomX() {
		int num = 0;
		int i = 0;
		while(i==0) {
		num = (int) (Math.random() * (900 - 100) + 100);
		if(!estaEnCoordenadasX(num)) {
			coordenadasXUsadas.add(num);
			i=1;
			}
		}
	}

	private boolean estaEnCoordenadasX(int num) {
		if(coordenadasXUsadas.size()==0) {
			return false;
		}
		else {
			for (int i = 0; i < coordenadasXUsadas.size(); i++) {
				if(coordenadasXUsadas.get(i)==num) {
					return true;
				}
			}
			return false;
		}
	}
	
	private boolean estaEnCoordenadasY(int num) {
		if(coordenadasYUsadas.size()==0) {
			return false;
		}
		else {
			for (int i = 0; i < coordenadasYUsadas.size(); i++) {
				if(coordenadasYUsadas.get(i)==num) {
					return true;
				}
			}
			return false;
		}
	}
	
	private void numRandomY() {
		int num = 0;
		int i = 0;
		while(i==0) {
			num = (int) (Math.random() * (600 - 100) + 100);
			if(!estaEnCoordenadasY(num)) {
				coordenadasYUsadas.add(num);
				i=1;
			}
		}
	}

	public void dispose() {
	}
}
