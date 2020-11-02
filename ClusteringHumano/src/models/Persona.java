package models;

public class Persona {
	private String nombre;
	
	public Persona(String nombre, int deportes, int musica, int espectaculo, int ciencia){
		setNombre(nombre);
	}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
}
