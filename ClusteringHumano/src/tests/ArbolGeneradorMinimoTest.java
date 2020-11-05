package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import logic2.ArbolGeneradorMinimo;
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
	
	@Test 
	public void caminoMasPesadoTest() {
		//Setup
		ArrayList<Persona> personas= new ArrayList<Persona>();
		Persona p1= new Persona("Maria",2,3,5,1);
		Persona p2= new Persona("Juan",2,2,3,4);
		Persona p3= new Persona("Kia",3,4,2,3);
		Persona p4= new Persona("Lian",1,1,1,1);
		personas.add(p1);
		personas.add(p2);
		personas.add(p3);
		personas.add(p4);
		//Execute
		GrafoDePersonas g= new GrafoDePersonas(personas);
		ArbolGeneradorMinimo a= new ArbolGeneradorMinimo(g);
		Camino resultante= a.caminoMasPesado(a.getCaminos());
		Camino caminoMasPesadoEsperado=new Camino(p1,p4);
		//verify
		boolean esperado= resultante.equalsDeCaminos(caminoMasPesadoEsperado);
		assertEquals(true,esperado); 
		
	}

}
