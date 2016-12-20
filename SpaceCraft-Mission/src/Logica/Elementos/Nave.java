package Logica.Elementos;

public class Nave {
	protected double miVelocidad; // Velocidad en pixels/segundo
	protected double miDireccionActual; // Direcci�n en la que estoy mirando en
										// grados (de 0 a 360)
	protected double posX; // Posici�n en X (horizontal)
	protected double posY; // Posicion en Y (vertical)
	private final static int LIMITE_SUPERIOR = -5;
	private final static int LIMITE_INFERIOR = 615;
	protected int danyoataque;

	public Nave() {
		miVelocidad = 0;
		miDireccionActual = 0;
		posX = 300;
		posY = 300;
		this.danyoataque = 100;

	}

	// Getters y Setters
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

	public void setPosicion(double posX, double posY) {
		setPosX(posX);
		setPosY(posY);
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public int getDanyoataque() {
		return danyoataque;
	}

	public void setDanyoataque(int danyoataque) {
		this.danyoataque = danyoataque;
	}

	@Override
	public String toString() {
		return "Nave [miVelocidad=" + miVelocidad + ", miDireccionActual=" + miDireccionActual + ", posX=" + posX
				+ ", posY=" + posY + "]";
	}

	public void MovimientoEjeY(boolean bajar) {
		// Si subir es true, la nave sube, si es false, la nave baja
		if (this.posY >= LIMITE_SUPERIOR && this.posY <= LIMITE_INFERIOR) {
			if (bajar) {
				setPosY(this.posY + 10);
				// Para evitar que pase de 615.
				if (posY > 615)
					setPosY(615);
			} else
				setPosY(this.posY - 10);

		}

	}

	public void Gravedad() {
		if (this.posY < LIMITE_INFERIOR)
			setPosY(this.posY + 1);

	}

}
