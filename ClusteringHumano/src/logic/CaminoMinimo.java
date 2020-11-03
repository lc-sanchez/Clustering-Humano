package logic;


import java.util.HashMap;
import java.util.Set;

import models.Persona;

public class CaminoMinimo {
	
	public HashMap<Persona,HashMap<Persona,Integer>> cluster;
	public HashMap<Persona,HashMap<Persona,Integer>> clusterMinimo;
	private Set<Persona> personas;
	
	public CaminoMinimo(HashMap<Persona,HashMap<Persona,Integer>> clusterHumano) {
		this.cluster=clusterHumano;
		this.personas=clusterHumano.keySet();
	}
	
	
	public void setPersonas(Set<Persona> personas) {this.personas=personas;}
	public Set<Persona> getPersonas(){return this.personas;}
	
	
	
}
