package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import models.GrafoDePersonas;
import models.Persona;
import models.Camino;



public class GrafoDePersonasTest {

	GrafoDePersonas grafo;
	ArrayList<Persona> personas;
	
	@Before 
	public void inicializar(){
		personas = new ArrayList<Persona>();
		personas.add(new Persona("Maria",1,1,1,1));
		personas.add(new Persona("Juan",2,2,2,2));
		personas.add(new Persona("Kia",1,1,1,1));
		grafo = new GrafoDePersonas(personas);
	}
	
	@Test
	public void crearCaminosTest(){
		ArrayList<Camino> copia = new ArrayList<Camino>();
		Persona p1= new Persona("Maria",1,1,1,1);
		Persona p2= new Persona("Juan",2,2,2,2);
		Persona p3= new Persona("Kia",1,1,1,1);
		
		copia.add(new Camino(p1,p2)); 
		copia.add(new Camino(p1,p3));
		copia.add(new Camino(p2,p3));
		
		boolean sonIguales=true;
		for(int i=0;i<copia.size();i++){
			if(!copia.get(i).equalsDeCaminos(grafo.getCaminos().get(i))){
				sonIguales=false;
				break;
			}
		}
		assertEquals(true,sonIguales);	
	}
	
	
	
}
