package logic;

import java.util.ArrayList;
import java.util.HashMap;


import models.Persona;

public class MainLogic {
	
	//Representacion del grafo por lista de vecinos
	//Los vertices son personas
	//Las aristas son valores dados por el indice de similaritud
	
	private ArrayList<Persona> listaPersonas;
	private HashMap<Persona,HashMap<Persona,Integer>> grafoPersonas;
	private int cantPersonas;
	
	public MainLogic() {
		listaPersonas=new ArrayList<Persona>();
	}
	
	public void agregarPersona(Persona persona) {
		listaPersonas.add(persona);
		cantPersonas++;
	}
	
	public void armarGrafoPersonas() {
		//-------------> Persona,vecinos -> Persona, similaridad/ Persona, similaridad
		grafoPersonas=new HashMap<Persona,HashMap<Persona,Integer>>(cantPersonas);
		
		for(int i=0;i<cantPersonas;i++) {
			Persona p= listaPersonas.get(i);
			grafoPersonas.put(p,agregarVecinos(p));
		}
	}
	
	
	
	public HashMap<Persona,Integer> agregarVecinos(Persona p) {
		HashMap<Persona,Integer> vecinos=new HashMap<Persona,Integer>();
		for(int i=0;i<cantPersonas;i++) {
			Persona vecino= listaPersonas.get(i);
			if(!vecino.equals(p)) {
				vecinos.put(vecino,p.calcularSimilaridad(vecino));
			}
		}
		return vecinos;
	}
	
	
	
}
