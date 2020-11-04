package models;

import java.util.ArrayList;


public class Grafo {
	private ArrayList<Persona> personas;
	private ArrayList<Camino> caminos;
	private int cantVertices;
	private int cantAristas;
	
	Grafo(ArrayList<Persona> vertices){
		if(vertices.equals(null)) { 
			throw new IllegalArgumentException("Array vacio.");
		}
		this.personas=vertices;
		cantVertices=personas.size();
		caminos=new ArrayList<Camino>();
		crearCaminos();
	}
	
	private void crearCaminos() {
		for(int i=0;i<getCantVertices();i++) {
			for(int j=0;j<getCantVertices();j++) {
				Camino camino=new Camino(personas.get(i),personas.get(j));
				if(i!=j && !existeEseCamino(camino)) {
					caminos.add(camino);
					cantAristas++;
				}
			}
		}
	}
	
	private boolean existeEseCamino(Camino camino) {
		for(int i=0;i<cantAristas;i++) {
			//Comparar si son los mismos vertices en el camino
			if(caminos.get(i).getPersona1().equals(camino.getPersona1())
			&& 	caminos.get(i).getPersona2().equals(camino.getPersona2())) {
				return true;
			}
			if(caminos.get(i).getPersona1().equals(camino.getPersona2())
			&& caminos.get(i).getPersona2().equals(camino.getPersona1())) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Persona> getVertices(){
		return this.personas;
	}
	
	public ArrayList<Camino> getAristas(){
		return this.caminos;
	}
	
	private int getCantCaminos() {
		return this.cantAristas;
	}
	private int getCantVertices() {
		return this.cantVertices;
	}
	
}
