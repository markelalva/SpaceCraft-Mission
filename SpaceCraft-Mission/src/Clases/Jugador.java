package Clases;

public class Jugador {
	
	private String nombre;
	private Configuracion confi;
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.confi = new Configuracion();
	}
	
	public Jugador(){
		
		this.nombre = " ";
		this.confi = new Configuracion();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Configuracion getConfi() {
		return confi;
	}

	public void setConfi(Configuracion confi) {
		this.confi = confi;
	}
	
	
	
	
	

}
