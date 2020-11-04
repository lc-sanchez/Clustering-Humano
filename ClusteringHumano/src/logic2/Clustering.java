package logic2;

import java.util.ArrayList;

import models.Persona;

public class Clustering {
	//Clase que interacciona con la view
	private ArrayList<Persona> listaPersonas;
	private int cantPersonas;
	
	public Clustering() {
		listaPersonas=new ArrayList<Persona>();
	}
	
	public void agregarPersona(Persona persona) {
		listaPersonas.add(persona);
		cantPersonas++;
		//armarCluster();
	}
	
	
	
	
	
	//-----------------------------Getters y Setters---------------------------------
	public int getCantPersonas() {
		return cantPersonas; 
	}
	
	public ArrayList<Persona> getPersonas(){return this.listaPersonas;}
	
	
}
