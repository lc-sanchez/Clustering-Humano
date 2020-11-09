package logic;

import java.util.ArrayList;

import models.Camino;
import models.GrafoDePersonas;
import models.Persona;



public class ArbolGeneradorMinimo {
	
	//Se utiliza el Algoritmo de Prim para generar el arbol minimo
	public ArrayList<Persona> personas;
	public ArrayList<Camino> caminos;
	
	//private static ArrayList<Persona> personasMinimas;
	public ArrayList<Camino> caminosMinimos;
	
	
	public ArbolGeneradorMinimo(GrafoDePersonas g) {
		if(g.getCaminos().size()>1) {
			personas=g.getPersonas(); 
			caminos=g.getCaminos();
			caminosMinimos=generarArbolMinimo();
		}
		
	}
	
	public ArrayList<Camino> generarArbolMinimo(){
		ArrayList<Persona> personasVisitadas = new ArrayList<Persona>();
		personasVisitadas.add(personas.get(0));       //Tomamos un vertice del grafo como inicio
		ArrayList<Camino> caminosDisponibles = new ArrayList<Camino>();
		Camino mejorCamino = null;                    //El mejor camino es el camino con menor peso
		ArrayList<Camino> arbolGeneradorMinimo = new ArrayList<Camino>();
		
		while(personasVisitadas.size()<personas.size()){ //Mientras no haya visitado todos los vertices...
			
			 //Consigo los caminos que puedo usar con los vertices que tengo 
			caminosDisponibles = agregarCaminosDisponibles(personasVisitadas,caminos);
			
			//Segun la similaridad se elige el mas barato/menor peso en total
			//Se recorre el array de caminos disponibles y se elije al de menor peso
			mejorCamino = Camino.mejorCamino(caminosDisponibles); 
			
			//Guardamos el menor camino
			arbolGeneradorMinimo.add(mejorCamino);
			
			//Se agrega las personas visitadas, es decir, se marcan los vertices 
			personasVisitadas = agregarPersonas(personasVisitadas,mejorCamino);  
		}
		return arbolGeneradorMinimo;
	}

	public  ArrayList<Persona> agregarPersonas(ArrayList<Persona> personasVisitadas, Camino mejorCamino) {
		//Grafo-> Personas= {p1,p2,p3}
		//		  Caminos= {(p1,p2)(p1,p3)(p2,p3)}
		//Si la persona visitada solo es p1. Los caminos disponibles son: (p1,p2)->Peso=4 /(p1,p3)->Peso=0
		//El mejor camino es (p1,p3)
		//Entonces ->
		
		for(int i=0;i<personasVisitadas.size();i++){
			if(personasVisitadas.get(i).equals(mejorCamino.getPersona1())){ //p1==p1 de (p1,p3)?->Yes
				personasVisitadas.add(mejorCamino.getPersona2()); //Entonces agrega a p3 porque ya esta marcado.
				return personasVisitadas; //Devolveme los visitados
			}
			if(personasVisitadas.get(i).equals(mejorCamino.getPersona2())){ //p1==p3 de (p1,p3)?->No
				personasVisitadas.add(mejorCamino.getPersona1());
				return personasVisitadas;
			}//Luego personas visitadas tendra p1 y p3. 
		}
		return personasVisitadas;
	}

	public ArrayList<Camino> agregarCaminosDisponibles(ArrayList<Persona> personasVisitadas,ArrayList<Camino> caminos) {
		//Caminos que llego desde los vertices visitados
		//Grafo-> Personas= {p1,p2,p3}
		//		  Caminos= {(p1,p2)(p1,p3)(p2,p3)}
		//		  
		//Si el unico visitado es p1.(Todos los caminos que llego desde p1) Entonces caminos disponibles son->{(p1,p2)(p1,p3)}
		ArrayList<Camino> caminosDisponibles = new ArrayList<Camino>(); 
		for(int i=0;i<personasVisitadas.size();i++){
			for(int c=0;c<caminos.size();c++){
				if((caminos.get(c).getPersona1().equals(personasVisitadas.get(i)) &&!personasVisitadas.contains(caminos.get(c).getPersona2())) ||
				(caminos.get(c).getPersona2().equals(personasVisitadas.get(i)) && !personasVisitadas.contains(caminos.get(c).getPersona1()))){
					caminosDisponibles.add(caminos.get(c));
				}
			}
		}
		return caminosDisponibles;
	}
	
	public void eliminarCaminoMasPesado(Camino caminoMasPesado) {
		for(int i=0;i<caminosMinimos.size();i++) {
			if(caminosMinimos.get(i).equalsDeCaminos(caminoMasPesado)) {
				caminosMinimos.remove(i);
			}
		}
	}
	
	//------------------------------------Getters--------------------------------------------------
	public ArrayList<Persona> getPersonas(){
		return personas;
	}
	public ArrayList<Camino> getCaminos(){
		return caminosMinimos;
	}
	
	
}
