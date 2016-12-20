package Logica.Elementos;

import java.awt.Rectangle;

import Visual.JLabels.JLabelEstrella;

public class Estrella {
	public int x;
	public int y;
	public double creacion;
	public Rectangle r;
	public JLabelEstrella miGrafico;
	public Estrella(int x, int y, double creacion, Rectangle r) {
		this.x = x;
		this.y = y;
		this.creacion = creacion;
		this.r = r;
		this.miGrafico = new JLabelEstrella();
	}
	
	public Estrella(){
		this.x = 0;
		this.y =0;
		this.creacion = System.currentTimeMillis();
		this.r = new Rectangle(0,0, 30,30);
		this.miGrafico = new JLabelEstrella();
		
		
	}



	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getCreacion() {
		return creacion;
	}

	public void setCreacion(double creacion) {
		this.creacion = creacion;
	}

	public Rectangle getR() {
		return r;
	}

	public void setR(Rectangle r) {
		this.r = r;
	}
	public JLabelEstrella getMiGrafico() {
		return miGrafico;
	}

	public void setMiGrafico(JLabelEstrella miGrafico) {
		this.miGrafico = miGrafico;
	}
	
	public void setPosicion(int posX, int posY) {
		setX(posX);
		setY(posY);
		r.setLocation(posX, posY);
		miGrafico.setLocation(posX, posY);
	}
	//Metodo para avanzar las estrellas.
	public void Avanzar(int Dificultad) {
		this.x = this.x - Dificultad;
		int valor = (int) this.x;
		int valor2 = (int) this.y;
		miGrafico.setLocation(valor, valor2);
		r.setLocation((int) (r.getX() - Dificultad), (int) this.y);
	}

	@Override
	public String toString() {
		return "Estrella [x=" + x + ", y=" + y + ", creacion=" + creacion + ", r=" + r + "]";
	}
	
	
	
	
	

}
