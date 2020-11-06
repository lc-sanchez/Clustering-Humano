package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import logic.ArbolGeneradorMinimo;
import models.Camino;
import models.GrafoDePersonas;
import models.Persona;

public class ArbolGeneradorMinimoTest {

	ArbolGeneradorMinimo arbol;
	GrafoDePersonas grafo;
	ArrayList<Persona> personas;
	
	@Before
	public void inicializar() {
		personas= new ArrayList<Persona>();
		personas.add(new Persona("Maria",1,1,1,1));
		personas.add(new Persona("Juan",2,2,2,2));
		personas.add(new Persona("Kia",1,1,1,1));
		
		grafo= new GrafoDePersonas(personas);
		arbol= new ArbolGeneradorMinimo(grafo); 
	}

	@Test
	public void generarArbolMinimotest() {
		ArrayList<Camino> copia= new ArrayList<Camino>();
		Persona p1= new Persona("Maria",1,1,1,1);
		Persona p2= new Persona("Juan",2,2,2,2);
		Persona p3= new Persona("Kia",1,1,1,1);
		
		Camino camino1= new Camino(p1,p3);
		Camino camino2= new Camino(p1,p2);
		copia.add(camino1);
		copia.add(camino2);
		boolean sonIguales=true;
		
		for(int i=0;i<copia.size();i++) {
			Camino caminoMinimo= arbol.getCaminos().get(i);
			if(!copia.get(i).equalsDeCaminos(caminoMinimo)) {
				sonIguales=false;
				break; 
			}
		} 
		assertEquals(true,sonIguales); 
		
	}
	


}
