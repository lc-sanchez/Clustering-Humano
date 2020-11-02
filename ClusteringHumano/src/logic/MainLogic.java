package logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import models.Persona;

public class MainLogic {
	
	//Representacion del grafo por lista de vecinos
	//Los vertices son personas
	//Las aristas son valores dados por el indice de similaritud
	
	private ArrayList<Persona> listaPersonas;
	private ArrayList<Set<Persona>> grafoPersonas;
	private int cantPersonas;
	
	public MainLogic() {
		listaPersonas=new ArrayList<Persona>();
	}
	
	public void agregarPersona(Persona persona) {
		listaPersonas.add(persona);
		cantPersonas++;
	}
	
	public void armarGrafoPersonas() {
		grafoPersonas=new ArrayList<Set<Persona>>(cantPersonas);
		
		for(int i=0;i<cantPersonas;i++) {
			grafoPersonas.add(new HashSet<Persona>());
		}
	}
	
	
	
}
