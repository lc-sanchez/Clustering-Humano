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
	
	public Integer calcularSimilaridad(Persona p2) {
		Integer restaDeporte= Math.abs(this.getDeporte()-p2.getDeporte());
		Integer restaMusica= Math.abs(this.getMusica()-p2.getMusica());
		Integer restaEspectaculo= Math.abs(this.getEspectaculo()-p2.getEspectaculo());
		Integer restaCiencia= Math.abs(this.getCiencia()-p2.getCiencia());
 		
		return restaDeporte+restaMusica+restaEspectaculo+restaCiencia;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		//if (this == obj)
			//return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		if (ciencia != other.ciencia) 
			return false;
		if (deporte != other.deporte)
			return false;
		if (espectaculo != other.espectaculo)
			return false;
		if (musica != other.musica)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	//----------------------------Getters y Setters--------
	//Evaluar test para casos bordes-> valores menores a 0 y mayores a 5
	
	private boolean valorPermitido(int interes) {
		if(interes>=0 && interes<=5) {
			return true;
		}
		return false;
	}
	
	public int getDeporte() {return deporte;}
	public void setDeporte(int deporte) {
		if(!valorPermitido(deporte)) {
			throw new RuntimeException("Valor no permitido");
		}
		else {this.deporte=deporte;}
	}
	
	public int getMusica() {return musica;}
	public void setMusica(int musica) {
		if(!valorPermitido(musica)) {
			throw new RuntimeException("Valor no permitido");
		}
		else {this.musica=musica;}
		
	}
	
	public int getEspectaculo() {return espectaculo;}
	public void setEspectaculo(int espectaculo) {
		if(!valorPermitido(espectaculo)) {
			throw new RuntimeException("Valor no permitido");
		}else {this.espectaculo=espectaculo;}
	}
	
	public int getCiencia() {return this.ciencia;}
	public void setCiencia(int ciencia) {
		if(!valorPermitido(ciencia)) {
			throw new RuntimeException("Valor no permitido");
		}else {this.ciencia=ciencia;}
	}

	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {
		if(nombre==null) {
			throw new RuntimeException("Nombre no null");
		}
		this.nombre = nombre;
	}
	
}
