package Clases;

public class Jugador {

	private String nombre;
	private Configuracion confi;
	private int MaxPunt1;
	private int MaxPunt2;
	private int MaxPunt3;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.confi = new Configuracion();
		this.MaxPunt1 = 0;
		this.MaxPunt2 = 0;
		this.MaxPunt3 = 0;
	}

	public Jugador() {

		this.nombre = " ";
		this.confi = new Configuracion();
		this.MaxPunt1 = 0;
		this.MaxPunt2 = 0;
		this.MaxPunt3 = 0;
	}

	public int getMaxPunt1() {
		return MaxPunt1;
	}

	public void setMaxPunt1(int maxPunt1) {
		MaxPunt1 = maxPunt1;
	}

	public int getMaxPunt2() {
		return MaxPunt2;
	}

	public void setMaxPunt2(int maxPunt2) {
		MaxPunt2 = maxPunt2;
	}

	public int getMaxPunt3() {
		return MaxPunt3;
	}

	public void setMaxPunt3(int maxPunt3) {
		MaxPunt3 = maxPunt3;
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
