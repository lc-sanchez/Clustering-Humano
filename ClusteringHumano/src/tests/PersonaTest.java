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
		Persona p2= new Persona("Kia",2,3,4,5);
		assertFalse(p1.equals(p2));
	}
}
