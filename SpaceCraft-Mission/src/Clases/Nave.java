package Clases;

public class Nave {
	protected double miVelocidad; // Velocidad en pixels/segundo
	protected double miDireccionActual; // Dirección en la que estoy mirando en grados (de 0 a 360)
	protected double posX; // Posición en X (horizontal)
	protected double posY; //Posicion en Y (vertical)
	
	
	public Nave() {
		miVelocidad = 0;
		miDireccionActual = 0;
		posX = 300;
		posY = 300;
		
		
	}


	//Getters y Setters
	public double getMiVelocidad() {
		return miVelocidad;
	}


	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}


	public double getMiDireccionActual() {
		return miDireccionActual;
	}


	public void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}


	public double getPosX() {
		return posX;
	}


	public void setPosX(double posX) {
		this.posX = posX;
	}


	public double getPosY() {
		return posY;
	}


	public void setPosY(double posY) {
		this.posY = posY;
	}


	@Override
	public String toString() {
		return "Nave [miVelocidad=" + miVelocidad + ", miDireccionActual=" + miDireccionActual + ", posX=" + posX
				+ ", posY=" + posY + "]";
	}
	
	
	
	
	
	
	

}
