package logic;

import java.util.ArrayList;
import java.util.HashMap;


import models.Persona;

public class ClusterHumano {
	
	//Representacion del grafo por hashmaps de hashmaps 
	//Los vertices son personas
	//Las aristas son valores dados por el indice de similaritud
	
	private ArrayList<Persona> listaPersonas;
	public HashMap<Persona,HashMap<Persona,Integer>> clusterHumano;
	private int cantPersonas;
	
	public ClusterHumano() { 
		listaPersonas=new ArrayList<Persona>();
	}
	
	public void agregarPersona(Persona persona) {
		listaPersonas.add(persona);
		cantPersonas++;
		armarCluster();
	}
	
	public int cantPersonas() {
		return cantPersonas; 
	}
	
	
	public ArrayList<Persona> getPersonas(){return this.listaPersonas;}
	
	
	
	public void armarCluster() {
		//-------> Persona,vecinos -> Persona, similaridad/ Persona, similaridad
		clusterHumano=new HashMap<Persona,HashMap<Persona,Integer>>(cantPersonas);	
		for(int i=0;i<cantPersonas;i++) {
			Persona p= listaPersonas.get(i);
			clusterHumano.put(p,getVecinosDe(p)); 
		}
	}
	
	public HashMap<Persona,Integer> getVecinosDe(Persona p) {
		HashMap<Persona,Integer> vecinos=new HashMap<Persona,Integer>();
		for(int i=0;i<cantPersonas;i++) {
			Persona vecino= listaPersonas.get(i);
			if(!vecino.equals(p)) {
				vecinos.put(vecino,p.calcularSimilaridad(vecino));
			}
		}
		return vecinos;
	}
	
	public ArrayList<Integer> obtenerSimilaridadConVecinos(Persona p){
		ArrayList<Integer> similaridadConVecinos= new ArrayList<Integer>();
		HashMap<Persona,Integer> vecinos=getVecinosDe(p);
		
		for(Integer similaridad : vecinos.values()) {
			similaridadConVecinos.add(similaridad);
		}
		return similaridadConVecinos;
	}
	
}
