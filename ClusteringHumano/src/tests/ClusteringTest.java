package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import logic.Clustering;
import models.Persona;
import models.Camino;

public class ClusteringTest {
	
	Clustering cluster;
	ArrayList<Persona> grupo1;
	ArrayList<Persona> grupo2;
	ArrayList<Camino> caminosGrupo1;
	ArrayList<Camino> caminosGrupo2;
	

	@Test
	public void ejecutarClusterinTest() {
		//SETUP---------------------------------------------
		Persona p1= new Persona("Maria",2,3,5,1);
		Persona p2= new Persona("Juan",2,2,3,4);
		Persona p3= new Persona("Kia",3,4,2,3);
		Persona p4= new Persona("Lian",1,1,1,1);
		Persona p5=new Persona("Lila",2,3,5,4);
		Persona p6=new Persona("Rei",3,3,3,3);
		Clustering cluster=new Clustering();
		cluster.agregarPersona(p1);
		cluster.agregarPersona(p2);
		cluster.agregarPersona(p3);
		cluster.agregarPersona(p4);
		cluster.agregarPersona(p5);
		cluster.agregarPersona(p6);
		
		grupo1= new ArrayList<Persona>();
		grupo2= new ArrayList<Persona>();
		caminosGrupo1=new ArrayList<Camino>();
		caminosGrupo2=new ArrayList<Camino>();
			
		grupo1.add(p1);
		grupo1.add(p5);
		grupo1.add(p2);
		grupo1.add(p6);
		grupo1.add(p3);
		
		boolean grupo1Iguales=true;
		
		grupo2.add(p4);
		
		boolean grupo2Iguales=true;
		
		Camino c1= new Camino(p1,p5);
		Camino c2= new Camino(p2,p5);
		Camino c3= new Camino(p2,p6);
		Camino c4= new Camino(p3,p6);
		
		caminosGrupo1.add(c1);
		caminosGrupo1.add(c2);
		caminosGrupo1.add(c3);
		caminosGrupo1.add(c4);
		
		
		
		//EXECUTE------------------------------------------
		cluster.ejecutarClustering();
		
		//Verificamos si son las mismas personas en el grupo 1
		for(int i=0;i<grupo1.size();i++) {
			Persona persona= cluster.getGrupoPersonas1().get(i);
			if(!grupo1.get(i).equals(persona)) {
				grupo1Iguales=false;
				break; 
			}
		} 
		
		//Verificamos si son las mismas personas para el grupo 2
		for(int i=0;i<grupo2.size();i++) {
			Persona persona= cluster.getGrupoPersonas2().get(i);
			if(!grupo2.get(i).equals(persona)) {
				grupo1Iguales=false;
				break; 
			}
		} 
		
		boolean caminosIgualesGrupo1=true;
		
		for(int i=0;i<caminosGrupo1.size();i++) {
			Camino camino= cluster.getCaminosGrupo1().get(i);
			if(!caminosGrupo1.get(i).equalsDeCaminos(camino)) {
				caminosIgualesGrupo1=false;
				break; 
			}
		} 
		
		boolean caminosIgualesGrupo2=(cluster.getCaminosGrupo2()).size()==0;
		
		//VERIFICY-------------------------------------------------
		boolean sonIguales=grupo1Iguales&&grupo2Iguales&&caminosIgualesGrupo1&&caminosIgualesGrupo2;
		
		assertEquals(true,sonIguales);
	}

}
