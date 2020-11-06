package logic;

import java.util.ArrayList;

import models.Persona;
import models.Camino;
import models.GrafoDePersonas;

public class Clustering {
	//Clase que interacciona con la view
	private ArrayList<Persona> listaPersonas;	
	
	private int cantPersonas;
	private Camino caminoMasPesado;
	

	private ArrayList<Persona> grupoPersonas1;
	private ArrayList<Persona> grupoPersonas2;
	private ArrayList<Camino> caminosGrupo1;
	private ArrayList<Camino> caminosGrupo2;
	
	
	public Clustering() {
		listaPersonas=new ArrayList<Persona>();
		grupoPersonas1=new ArrayList<Persona>();
		grupoPersonas2=new ArrayList<Persona>();
		caminosGrupo1= new ArrayList<Camino>();
		caminosGrupo2=new ArrayList<Camino>();
	}
	
	public void agregarPersona(Persona persona) {
		//Para el boton de formulario
		listaPersonas.add(persona);
		cantPersonas++;
	}
	
	public void ejecutarClustering() {
		//Generamos el grafo a partir de la lista de personas
		System.out.println("GRAFO");
		GrafoDePersonas grafo= new GrafoDePersonas(listaPersonas);
		System.out.println(grafo.getCaminos());
		System.out.println("-----------------------");
		
		//Generamos el arbol generador minimo utilizando el algoritmo de Prim
		System.out.println("AGM");
		ArbolGeneradorMinimo arbolMinimo= new ArbolGeneradorMinimo(grafo);
		//arbolGeneradorMinimo=arbolMinimo.generarArbolMinimo();
		System.out.println(arbolMinimo.getCaminos());
		System.out.println("-----------------------");
		
		//Buscamos la arista mas pesada en el arbol y la guardamos
		System.out.println("CaminoMasPesado");
		caminoMasPesado=caminoMasPesado(arbolMinimo.getCaminos());
		
		//Sea agregan las personas de los vertices de ese camino a grupos distintos
		grupoPersonas1.add(caminoMasPesado.getPersona1());
		grupoPersonas2.add(caminoMasPesado.getPersona2());
		System.out.println(caminoMasPesado);
		
		System.out.println("-----------------------");
		
		//sacamos el camino mas pesado
		arbolMinimo.eliminarCaminoMasPesado(caminoMasPesado);
		
		System.out.println("Nuevos caminos minimos");
		System.out.println(arbolMinimo.getCaminos());
		
		System.out.println("-------------------------------");
		System.out.println("GRUPO1------------------------");
		engrupar(arbolMinimo);
		System.out.println(caminosGrupo1);
		System.out.println(grupoPersonas1);
		System.out.println("-------------------------------");
		System.out.println("GRUPO2------------------------");
		System.out.println(caminosGrupo2);
		System.out.println(grupoPersonas2);
		
	}
	
	public void engrupar(ArbolGeneradorMinimo arbolMinimo) {
		//Setup
		ArrayList<Camino> caminosArbolMinimo=arbolMinimo.getCaminos();
		ArrayList<Camino> caminosDisponibles= new ArrayList<Camino>(); 
		
		//EMPEZAMOS CON EL PRIMER GRUPO
		caminosDisponibles=arbolMinimo.agregarCaminosDisponibles(grupoPersonas1, caminosArbolMinimo); //Empezamos con el primer grupo
		
		while(grupoPersonas1.size()<arbolMinimo.getPersonas().size() && caminosDisponibles.size()>0) {			
			caminosGrupo1.add(caminosDisponibles.get(0)); //Se agrega al camino(solo hay uno porque es el camino minimo)
			grupoPersonas1=arbolMinimo.agregarPersonas(grupoPersonas1,caminosDisponibles.get(0)); //A las personas del camino
			caminosDisponibles=arbolMinimo.agregarCaminosDisponibles(grupoPersonas1, caminosArbolMinimo); //Se busca el camino que sigue la otra persona			
		}
		
		//SIGUE GRUPO 2
		caminosDisponibles=arbolMinimo.agregarCaminosDisponibles(grupoPersonas2, caminosArbolMinimo);
		while(grupoPersonas2.size()<arbolMinimo.getPersonas().size() && caminosDisponibles.size()>0) {			
			caminosGrupo2.add(caminosDisponibles.get(0));
			grupoPersonas2=arbolMinimo.agregarPersonas(grupoPersonas2,caminosDisponibles.get(0));
			caminosDisponibles=arbolMinimo.agregarCaminosDisponibles(grupoPersonas2, caminosArbolMinimo); 			
		}
		
		
	}
		
	public  Camino caminoMasPesado(ArrayList<Camino> caminos) {
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
	
	public ArrayList<Persona> getGrupoPersonas1(){return grupoPersonas1;}
	public ArrayList<Persona> getGrupoPersonas2(){return grupoPersonas2;}
	
	public static void main(String[] args) {
	
		System.out.println("-------------------------------------------------------------------------");
		Persona p1= new Persona("Maria",2,3,5,1);
		Persona p2= new Persona("Juan",2,2,3,4);
		Persona p3= new Persona("Kia",3,4,2,3);
		Persona p4= new Persona("Lian",1,1,1,1);
		Persona p5=new Persona("Lila",2,3,5,4);
		Persona p6=new Persona("Rei",3,3,3,3);
		Clustering cluster=new Clustering();
		cluster.agregarPersona(p1);
		cluster.agregarPersona(p2);
		cluster.agregarPersona(p3);
		cluster.agregarPersona(p4);
		cluster.agregarPersona(p5);
		cluster.agregarPersona(p6);
		cluster.ejecutarClustering();
		
	}
	
}
