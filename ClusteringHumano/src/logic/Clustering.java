package logic;

import java.util.ArrayList;

import models.Persona;
import models.Camino;
import models.GrafoDePersonas;

public class Clustering {
	//Clase que interacciona con la view
	public ArrayList<Persona> listaPersonas;	
	
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
		GrafoDePersonas grafo= new GrafoDePersonas(listaPersonas);
		
		//Generamos el arbol generador minimo utilizando el algoritmo de Prim
		ArbolGeneradorMinimo arbolMinimo= new ArbolGeneradorMinimo(grafo);
		
		//Buscamos la arista mas pesada en el arbol y la guardamos
		caminoMasPesado=caminoMasPesado(arbolMinimo.getCaminos());
		
		if(caminoMasPesado.getSimilaridad()==0) {
			//Por default se agregan todos al grupo1
			grupoPersonas1.add(caminoMasPesado.getPersona1());
			engrupar(arbolMinimo);
		}
		
		else {
			//Sea agregan las personas de los vertices de ese camino a grupos distintos
			//Es para tener una referencia a los vertices y separar los grupos
			grupoPersonas1.add(caminoMasPesado.getPersona1());
			grupoPersonas2.add(caminoMasPesado.getPersona2());
			
			//sacamos el camino mas pesado
			arbolMinimo.eliminarCaminoMasPesado(caminoMasPesado);
			
			//Ejecutamos clustering
			engrupar(arbolMinimo);
		}
		
	}
	
	private void engrupar(ArbolGeneradorMinimo arbolMinimo) {
		//Setup
		ArrayList<Camino> caminosArbolMinimo=arbolMinimo.getCaminos();
		ArrayList<Camino> caminosDisponibles= new ArrayList<Camino>(); 
		
		//EMPEZAMOS CON EL PRIMER GRUPO
		if(grupoPersonas1.size()!=0) {
			caminosDisponibles=arbolMinimo.agregarCaminosDisponibles(grupoPersonas1, caminosArbolMinimo); //Empezamos con el primer grupo
			
			while(grupoPersonas1.size()<arbolMinimo.getPersonas().size() && caminosDisponibles.size()>0) {			
				caminosGrupo1.add(caminosDisponibles.get(0)); //Se agrega al camino(solo hay uno porque es el camino minimo)
				grupoPersonas1=arbolMinimo.agregarPersonas(grupoPersonas1,caminosDisponibles.get(0)); //A las personas del camino
				caminosDisponibles=arbolMinimo.agregarCaminosDisponibles(grupoPersonas1, caminosArbolMinimo); //Se busca el camino que sigue la otra persona			
			}
		}
		//SIGUE GRUPO 2
		if(grupoPersonas2.size()!=0) {
			
			caminosDisponibles=arbolMinimo.agregarCaminosDisponibles(grupoPersonas2, caminosArbolMinimo);
			while(grupoPersonas2.size()<arbolMinimo.getPersonas().size() && caminosDisponibles.size()>0) {			
				caminosGrupo2.add(caminosDisponibles.get(0));
				grupoPersonas2=arbolMinimo.agregarPersonas(grupoPersonas2,caminosDisponibles.get(0));
				caminosDisponibles=arbolMinimo.agregarCaminosDisponibles(grupoPersonas2, caminosArbolMinimo); 			
			}	
		}
		
		
		
	}
		
	private Camino caminoMasPesado(ArrayList<Camino> caminos) {
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
	
	public boolean existeNombreEnPersonas(String nombre) {
		boolean existe=false;
		for(int i=0;i<getCantPersonas();i++) {
			if(listaPersonas.get(i).getNombre()==nombre) {
				existe=true;
				break;
			}
		}
		return existe;
	}
	//-----------------------------Getters y Setters---------------------------------
	public int getCantPersonas() {return cantPersonas;}
	
	public ArrayList<Persona> getPersonas(){return this.listaPersonas;}
	
	public ArrayList<Persona> getGrupoPersonas1(){return grupoPersonas1;}
	public ArrayList<Persona> getGrupoPersonas2(){return grupoPersonas2;}
	
	public ArrayList<Camino> getCaminosGrupo1(){return caminosGrupo1;}
	public ArrayList<Camino> getCaminosGrupo2(){return caminosGrupo2;}
	
	public static void main(String[] args) {
		Persona p1= new Persona("Maria",1,1,1,1);
		Persona p2= new Persona("Juan",1,1,1,1);
		Persona p3= new Persona("Kia",1,1,1,1);
		Persona p4=new Persona("Mia",2,3,4,5);
		
		Clustering cluster=new Clustering();
		cluster.agregarPersona(p1);
		cluster.agregarPersona(p2);
		cluster.agregarPersona(p3);
		cluster.agregarPersona(p4);
		
		cluster.ejecutarClustering();
		
		System.out.println(cluster.getGrupoPersonas1());
		System.out.println(cluster.getGrupoPersonas2());
	
	}
	
}
