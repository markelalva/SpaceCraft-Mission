package Clases;

import java.awt.Component;
import java.awt.Rectangle;

public class Boss {	private int ImagenBoss;
	private double x;
	private double y;
	private int vida;
	private int danyoataque;
	private JLabelBoss miGrafico;
	private Rectangle r;
	private boolean arriba = true;// Constructor con todos los par�metros

	public Boss(int x, int y, int vida, int danyoataque, Rectangle r, int nivel) {
		super();
		this.x = x;
		this.y = y;
		this.vida = vida;
		this.danyoataque = danyoataque;
		this.r = r;
		miGrafico = new JLabelBoss(nivel);
	}

	public Boss(int ImagenBoss) {
		
		this.x = 0;
		this.y = 0;
		this.vida = 100;
		this.danyoataque = 100;
		miGrafico = new JLabelBoss(ImagenBoss);
		r = new Rectangle();
		r.setBounds(0, 0, 100, 100);
		// TODO Auto-generated constructor stub
	}

	// Getters y Setters
	public double getX() {
		return x;
	}

	public void setX(double posX) {
		this.x = posX;
	}

	public double getY() {
		return y;
	}

	public void setY(double posY) {
		this.y = posY;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDanyoataque() {
		return danyoataque;
	}

	public void setDanyoataque(int danyoataque) {
		this.danyoataque = danyoataque;
	}

	public Rectangle getR() {
		return r;
	}

	public void setR(Rectangle r) {
		this.r = r;
	}

	// To String (Por si es necesario sacar alg�n dato por consola).
	@Override
	public String toString() {
		return "Boss [x=" + x + ", y=" + y + ", vida=" + vida + ", da�oataque=" + danyoataque + ", r=" + r + "]";
	}

	public void setPosicion(double posX, double posY) {
		setX(posX);
		setY(posY);
		// Colocamos el grafico a esa posicion
		miGrafico.setLocation((int) posX, (int) posY);
		r.setLocation((int) posX, (int) posY);
	}

	public JLabelBoss getMiGrafico() {
		return miGrafico;
	}

	public void setMiGrafico(JLabelBoss miGrafico) {
		this.miGrafico = miGrafico;
	}

	public void MoverBoss(int Dificultad) {
		if (arriba) {
			setPosicion(this.x, this.y - Dificultad);
			if (this.y < 0)
				arriba = false;

		} else {
			setPosicion(this.x, this.y + Dificultad);
			if (this.y >= 500)
				arriba = true;
		}

	}

}
