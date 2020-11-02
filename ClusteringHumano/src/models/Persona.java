package models;

import java.util.ArrayList;

public class Persona {
	private ArrayList<Integer> intereses;
	private String nombre;
	
	public Persona(String nombre, int deportes, int musica, int espectaculo, int ciencia){
		setNombre(nombre);
		
		intereses = new ArrayList<Integer>();
		intereses.add(deportes);
		intereses.add(musica);
		intereses.add(espectaculo);
		intereses.add(ciencia);
	}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
}
