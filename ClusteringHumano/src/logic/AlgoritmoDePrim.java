package logic;

import java.util.ArrayList;
import java.util.HashMap;

import models.Persona;

public class AlgoritmoDePrim {
	
	private ClusterHumano cluster;
	private ArrayList<Persona> personasVisitadas;
	private ClusterHumano clusterMinimo;
	
	public AlgoritmoDePrim(ClusterHumano cluster) {
		this.cluster=cluster;
		clusterMinimo=new ClusterHumano(); 
	}
	//clase ClusterHumano
	public void ejecutar() {
		ArrayList<Persona> listaPersonas=cluster.getPersonas();
		//Persona personaInicio=listaPersonas.get(0);
		//personasVisitadas.add(personaInicio);
		//cluster-> 1, 2, 3 -> PersonaInicio=1-> vecinos= {(2,4),(3,5)} 
		//HashMap<Persona,Integer> vecinos=cluster.getVecinosDe(personaInicio);
		
		for(int i=0;i<cluster.cantPersonas();i++) {
			Persona persona=listaPersonas.get(i); //vecino=2
			if(!personasVisitadas.contains(persona)) {
				agregarAristaMasPequeña(persona);
				personasVisitadas.add(persona);
			}
		}
				
	}
	//cluster-> p1, p2, p3 -> PersonaInicio=1-> vecinos= {(p2,4),(p3,5)} 
	public void agregarAristaMasPequeña(Persona persona) {
		HashMap<Persona,Integer> vecinos=cluster.getVecinosDe(persona);//-> vecinos= {(p2,4),(p3,5)} 
		ArrayList<Integer> similaridades=cluster.obtenerSimilaridadConVecinos(persona);
		//->{4,5}
		int contador=1;
		Integer min=similaridades.get(0);
		for(Persona p: vecinos.keySet()) {
			//
		}
		
	}
	
	
}
