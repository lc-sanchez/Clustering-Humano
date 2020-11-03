package tests;

import static org.junit.Assert.*;

import java.util.HashMap;

//import java.util.ArrayList;


import org.junit.Test;
import logic.ClusterHumano;
import models.Persona;

public class ClusterHumanoTest {
	 
	
	@Test
	public void agregarPersonaTest() {
		//Setup
		Persona p1= new Persona("Maria",1,2,3,4);
		ClusterHumano mainLogic= new ClusterHumano();
		
		mainLogic.agregarPersona(p1);//Execute
		assertEquals(1,mainLogic.cantPersonas());
	}
	
	@Test
	public void agregarVecinosTest(){
		//Setup
		ClusterHumano cluster=new ClusterHumano();
		Persona p1= new Persona("Maria",1,2,3,4);
		Persona p2=new Persona("Kia",1,2,3,5);
		
		cluster.agregarPersona(p1);
		cluster.agregarPersona(p2);
			
		HashMap<Persona,Integer> obtenido=cluster.agregarVecinos(p1);
		assertTrue(obtenido.containsKey(p2));	
	}
}