package logic2;

import java.util.ArrayList;

import models.Persona;
import models.Camino;
import models.GrafoDePersonas;

public class Clustering {
	//Clase que interacciona con la view
	private ArrayList<Persona> listaPersonas;
	private static ArrayList<Camino> arbolGeneradorMinimo;
	private int cantPersonas;
	
	public Clustering() {
		listaPersonas=new ArrayList<Persona>();
	}
	
	public void agregarPersona(Persona persona) {
		//Para el boton de formulario
		listaPersonas.add(persona);
		cantPersonas++;
		//armarCluster();
	}
	
	public void ejecutarClustering() {
		GrafoDePersonas grafo= new GrafoDePersonas(listaPersonas);
		ArbolGeneradorMinimo arbolMinimo= new ArbolGeneradorMinimo(grafo);
		arbolGeneradorMinimo=arbolMinimo.generarArbolMinimo();
		
		
	}
	
	
	
	
	
	
	//-----------------------------Getters y Setters---------------------------------
	public int getCantPersonas() {
		return cantPersonas; 
	}
	
	public ArrayList<Persona> getPersonas(){return this.listaPersonas;}
	
	
}
