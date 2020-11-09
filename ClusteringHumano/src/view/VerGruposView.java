package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.Clustering;

public class VerGruposView extends JPanel{

	private static final long serialVersionUID = 1L;
	public Clustering cluster;
	private ArrayList<Integer> coordenadasXUsadas = new ArrayList<Integer>();
	private ArrayList<Integer> coordenadasYUsadas = new ArrayList<Integer>();
	
	public HashMap<String, ArrayList<Integer>> personas = new HashMap<String, ArrayList<Integer>>();
	public JFrame frame;
	
	public VerGruposView(Clustering clusterPasado) {
		cluster=clusterPasado;
	}
	
	public void inicializarVerGruposView() {
		//Se establecen las caracteristicas de la ventana verGrupos
		frame = new JFrame("Ver Grupos");
        frame.getContentPane().add(new VerGruposView(cluster));
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(350, 720, 80, 20);
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
		pintarAristasGrupo1(g);
		pintarAristasGrupo2(g);
    }
	
	private void pintarVertices(Graphics g) {
	    for (int i = 0 ; i < cluster.getCantPersonas() ; i++) {
	      g.setColor(Color.BLUE);
	      numRandomX();
	      numRandomY();
	      g.fillOval(coordenadasXUsadas.get(i), coordenadasYUsadas.get(i), 40, 40);
	      g.setColor(Color.BLACK);
	      g.drawString(obtenerPersona(i), coordenadasXUsadas.get(i)+15, coordenadasYUsadas.get(i)-5);
	      agregarPersona(obtenerPersona(i),coordenadasXUsadas.get(i), coordenadasYUsadas.get(i));
	    }
	  }
	
	private void agregarPersona(String nombre, Integer coord1, Integer coord2) {
		ArrayList<Integer> coordenadas = new ArrayList<Integer>();
		coordenadas.add(coord1);
		coordenadas.add(coord2);
		personas.put(nombre,coordenadas);
		
	}

	private String obtenerPersona(int i) {
		return cluster.listaPersonas.get(i).getNombre();
	}

	private void pintarAristasGrupo1(Graphics g) {
		g.setColor(Color.RED);
		String key = "";
		if(cluster.getCaminosGrupo1().size()!=0) {
			for (int i = 0 ; i < cluster.getCaminosGrupo1().size(); i++) {
				
				ArrayList<Integer> coordenadas = new ArrayList<Integer>();
				
				for ( Entry<String, ArrayList<Integer>> e : personas.entrySet() ) {
				    key = e.getKey();
				    
				    if(key==cluster.getCaminosGrupo1().get(i).getPersona1().getNombre()
				    	|| key==cluster.getCaminosGrupo1().get(i).getPersona2().getNombre()) {
				    	
				    	coordenadas.add(e.getValue().get(0));
				    	coordenadas.add(e.getValue().get(1));
				    }
				}
				g.drawLine(coordenadas.get(0)+15,coordenadas.get(1)+25, 
						coordenadas.get(2)+15,coordenadas.get(3)+25);
			}
		}
		
	}
	
	private void pintarAristasGrupo2(Graphics g) {
		g.setColor(Color.RED);
		String key = "";
		if(cluster.getCaminosGrupo2().size()!=0) {
			for (int i = 0 ; i < cluster.getCaminosGrupo2().size(); i++) {
				
				ArrayList<Integer> coordenadas = new ArrayList<Integer>();
				
				for ( Entry<String, ArrayList<Integer>> e : personas.entrySet() ) {
				    key = e.getKey();
				    
				    if(key==cluster.getCaminosGrupo2().get(i).getPersona1().getNombre()
				    	|| key==cluster.getCaminosGrupo2().get(i).getPersona2().getNombre()) {
				    	
				    	coordenadas.add(e.getValue().get(0));
				    	coordenadas.add(e.getValue().get(1));
				    }
				}
				g.drawLine(coordenadas.get(0)+15,coordenadas.get(1)+25, 
						coordenadas.get(2)+15,coordenadas.get(3)+25);
			}
		}
		
	}
	
	private void numRandomX() {
		int num = 0;
		int i = 0;
		while(i==0) {
		num = (int) (Math.random() * (700 - 100) + 100);
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
			num = (int) (Math.random() * (700 - 100) + 100);
			if(!estaEnCoordenadasY(num)) {
				coordenadasYUsadas.add(num);
				i=1;
			}
		}
	}

	public void dispose() {
	}

}
