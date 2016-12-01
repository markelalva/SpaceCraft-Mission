package Clases;

import java.awt.Rectangle;

public class Ataque {
	private String Atacante;
	private int daño;
	private Rectangle r;
	private double x;
	private double y;
	private JLabelDisparo miGrafico;
	
	public Ataque(String atacante, int daño, Rectangle r, double x, double y, JLabelDisparo miGrafico) {
		Atacante = atacante;
		this.daño = daño;
		this.r = r;
		this.x = x;
		this.y = y;
		this.miGrafico = miGrafico;
	}
	
	public Ataque(){
		this.Atacante = "HatsuRobin";
		this.daño =0;
		this.r = new Rectangle();
		this.x =0;
		this.y =0;
		
	}

	public String getAtacante() {
		return Atacante;
	}

	public void setAtacante(String atacante) {
		Atacante = atacante;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public Rectangle getR() {
		return r;
	}

	public void setR(Rectangle r) {
		this.r = r;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}


	public JLabelDisparo getMiGrafico() {
		return miGrafico;
	}

	public void setMiGrafico(JLabelDisparo miGrafico) {
		this.miGrafico = miGrafico;
	}
	
	public void setPosicion(double posX, double posY) {
		setX(posX);
		setY(posY);
		//Colocamos el grafico a esa posicion
		miGrafico.setLocation( (int)posX, (int)posY );
	}

	//To String para Pruebas
	public String toString() {
		return "Ataque [Atacante=" + Atacante + ", daño=" + daño + ", r=" + r + ", x=" + x + ", y=" + y + "]";
	}
	

	
	
	
	
	

}
