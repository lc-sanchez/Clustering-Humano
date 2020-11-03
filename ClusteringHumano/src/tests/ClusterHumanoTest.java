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
		ClusterHumano cluster= new ClusterHumano();
		
		cluster.agregarPersona(p1);//Execute
		assertEquals(1,cluster.cantPersonas()); 
	}
	
	@Test
	public void agregarVecinosTest(){
		//Setup
		ClusterHumano cluster=new ClusterHumano();
		Persona p1= new Persona("Maria",1,2,3,4);
		Persona p2=new Persona("Kia",1,2,3,5);
		
		//Execute
		cluster.agregarPersona(p1);
		cluster.agregarPersona(p2);
			
		HashMap<Persona,Integer> obtenido=cluster.agregarVecinos(p1);
		//Verify
		assertTrue(obtenido.containsKey(p2));	
	}
	
	@Test
	public void armarClusterTest() {
		//Setup
		ClusterHumano cluster=new ClusterHumano();
		Persona p1= new Persona("Maria",1,2,3,4);
		Persona p2=new Persona("Kia",1,2,3,4);
		//Similaridad=0
		
		//Execute
		cluster.agregarPersona(p1);
		cluster.agregarPersona(p2);
		
		cluster.armarCluster();
		HashMap<Persona,Integer> esperado= cluster.agregarVecinos(p1);
		
		assertEquals(esperado,cluster.clusterHumano.get(p1));
		
				
	}
}