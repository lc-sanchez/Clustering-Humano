package models;



public class Persona {
	private String nombre;
	private int deporte;
	private int musica;
	private int espectaculo;
	private int ciencia;
	
	public Persona(String nombre, int deporte, int musica, int espectaculo, int ciencia){
		setNombre(nombre);
		setDeporte(deporte);
		setMusica(musica);
		setEspectaculo(espectaculo);
		setCiencia(ciencia);
	}
	
	public int getDeporte() {return deporte;}
	public void setDeporte(int deporte) {this.deporte=deporte;}
	
	public int getMusica() {return musica;}
	public void setMusica(int musica) {this.musica=musica;}
	
	public int getEspectaculo() {return espectaculo;}
	public void setEspectaculo(int espectaculo) {this.espectaculo=espectaculo;}
	
	public int getCiencia() {return this.ciencia;}
	public void setCiencia(int ciencia) {this.ciencia=ciencia;}

	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
}
