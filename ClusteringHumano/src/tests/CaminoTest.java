package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import models.Camino;
import models.Persona;

public class CaminoTest {

	Camino camino1;
	Camino camino2;
	Camino camino3;
	ArrayList<Camino> caminos;
	
	@Before
	public void inicializar() {
		Persona p1= new Persona("Maria",1,1,1,1);
		Persona p2= new Persona("Juan",2,3,4,5);
		Persona p3= new Persona("Mia",1,1,1,1);
		
		camino1= new Camino(p1,p3);
		camino2= new Camino(p3,p2);
		camino3= new Camino(p3,p1);
		caminos = new ArrayList<Camino>();
	}
	
	@Test
	public void equalsDeCaminosTest() {
		boolean resultado= camino1.equalsDeCaminos(camino1);
		assertTrue(resultado); 
	}
	
	@Test
	public void mejorCaminoTest() {
		caminos.add(camino1);
		caminos.add(camino2);
		assertEquals(camino1,Camino.mejorCamino(caminos));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void mejorCaminoArrayVacioTest() {
		Camino.mejorCamino(caminos);
	}

}
