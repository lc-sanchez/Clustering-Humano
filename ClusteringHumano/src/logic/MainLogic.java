package logic;

import java.util.ArrayList;
import java.util.HashMap;


import models.Persona;

public class MainLogic {
	
	//Representacion del grafo por lista de vecinos
	//Los vertices son personas
	//Las aristas son valores dados por el indice de similaritud
	
	private ArrayList<Persona> listaPersonas;
	private ArrayList<HashMap<Persona,Integer>> grafoPersonas;
	private int cantPersonas;
	
	public MainLogic() {
		listaPersonas=new ArrayList<Persona>();
	}
	
	public void agregarPersona(Persona persona) {
		listaPersonas.add(persona);
		cantPersonas++;
	}
	
	public void armarGrafoPersonas() {
		//-------------> Persona -> Persona, similaridad/ Persona, similaridad
		grafoPersonas=new ArrayList<HashMap<Persona,Integer>>(cantPersonas);
		
		for(int i=0;i<cantPersonas;i++) {
			grafoPersonas.add(new HashMap<Persona,Integer>());
		}
	}
	
	public void agregarSimilaridad(Persona p1, Persona p2) {
		for(int i=0;i<cantPersonas;i++) {

		}
		
	}
	
	
	
	
}
