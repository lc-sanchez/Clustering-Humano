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
	private Camino caminoMasPesado;
	
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
		//Generamos el grafo a partir de la lista de personas
		GrafoDePersonas grafo= new GrafoDePersonas(listaPersonas);
		
		//Generamos el arbol generador minimo utilizando el algoritmo de Prim
		ArbolGeneradorMinimo arbolMinimo= new ArbolGeneradorMinimo(grafo);
		arbolGeneradorMinimo=arbolMinimo.generarArbolMinimo();
		
		//Buscamos la arista mas pesada en el arbol y la guardamos
		caminoMasPesado=caminoMasPesado(arbolGeneradorMinimo);
		
		
		
		
	}
	
	public static Camino caminoMasPesado(ArrayList<Camino> caminos) {
		//Devuelve el camino mas pesado del arbol
		if(caminos.size()==0){
			throw new IllegalArgumentException("Array vacio");
		}
		Camino masPesado=caminos.get(0);
		for(int i=1;i<caminos.size();i++) {
			if(caminos.get(i).getSimilaridad()>masPesado.getSimilaridad()) {
				masPesado=caminos.get(i);
			}
		}
		return masPesado;
	}
	
	
	
	
	
	//-----------------------------Getters y Setters---------------------------------
	public int getCantPersonas() {
		return cantPersonas; 
	}
	
	public ArrayList<Persona> getPersonas(){return this.listaPersonas;}
	
	
}
