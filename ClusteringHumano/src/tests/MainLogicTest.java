package tests;

import static org.junit.Assert.*;

//import java.util.ArrayList;


import org.junit.Test;
import logic.MainLogic;
import models.Persona;

public class MainLogicTest {
	 
	
	@Test
	public void agregarPersonaTest() {
		//Setup
		Persona p1= new Persona("Maria",1,2,3,4);
		MainLogic mainLogic= new MainLogic();
		
		mainLogic.agregarPersona(p1);//Execute
		assertEquals(1,mainLogic.cantPersonas());
	}
}