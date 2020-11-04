package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import models.Persona;

public class PersonaTest {

	@Test
	public void equalsTest() {
		Persona p1= new Persona("Maria",2,3,4,5);
		assertTrue(p1.equals(p1));
	}

	@Test 
	public void equalsTest2() {
		Persona p1= new Persona("Maria",2,3,4,5);
		Persona p2= new Persona("Kia",1,2,3,4);
		assertFalse(p1.equals(p2));
	}
	
	@Test (expected=RuntimeException.class)
	public void setNombreTest() {
		Persona p1= new Persona(null,2,3,4,5);
	}
	
	@Test(expected=RuntimeException.class)
	public void setInteresesTest() {
		Persona p1= new Persona("Maria",-1,-2,6,8);
	}
	
	
	@Test
	public void calcularSimilaridadTest(){
		Persona p1= new Persona("Maria",2,3,4,5);
		Persona p2= new Persona("Kia",2,3,4,5);
		Integer similaridad= p1.calcularSimilaridad(p2);
		Integer esperado=0;
		assertEquals(esperado,similaridad);
	}
}
