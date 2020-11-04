package models;

import java.util.ArrayList;



public class Camino {
	private Persona persona1;
	private Persona persona2;

	private int similaridad;
	
	public Camino(Persona persona1,Persona persona2) {
		this.persona1=persona1;
		this.persona2=persona2;
		similaridad=persona1.calcularSimilaridad(persona2); 
	}
	
	public boolean equalsDeCaminos(Camino camino) {
		if(this.similaridad!=camino.getSimilaridad()) {
			return false;
		}
		if(!this.persona1.equals(camino.getPersona1())
				|| !this.persona2.equals(camino.getPersona2())) {
			return false;
		}
		return true;
	} 
	
	public static Camino mejorCamino(ArrayList<Camino> caminos){
		if(caminos.size()==0){
			throw new IllegalArgumentException("Array vacio");
		}
		Camino mejor = caminos.get(0);
		for(int i=1;i<caminos.size();i++){
			if(caminos.get(i).similaridad<mejor.similaridad){
				mejor = caminos.get(i);
			}
		}
		return mejor; 
	}
	
	
	
	//-------------Getters y Setters----------
	
	@Override
	public String toString() {
		return "["+persona1+","+ persona2+",similaridad="+similaridad+"]";
	}

	public int getSimilaridad() {return this.similaridad;}
	
	public Persona getPersona1() {return this.persona1;}
	
	public Persona getPersona2() {return this.persona2;}
	
	
}
