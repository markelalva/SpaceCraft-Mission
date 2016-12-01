package Clases;

import java.awt.Rectangle;

public class Ataque {
	private String Atacante;
	private int da�o;
	private Rectangle r;
	private double x;
	private double y;
	private JLabelDisparo miGrafico;
	private long TiempoCreacion;
	
	public Ataque(String atacante, int da�o,  double x, double y, JLabelDisparo miGrafico) {
		Atacante = atacante;
		this.da�o = da�o;
		this.r = new Rectangle();
		this.x = x;
		this.y = y;
		this.miGrafico = miGrafico;
		this.TiempoCreacion = System.currentTimeMillis();
	}
	
	public Ataque(){
		this.Atacante = "HatsuRobin";
		this.da�o =0;
		this.r = new Rectangle();
		this.x =0;
		this.y =0;
		this.TiempoCreacion = System.currentTimeMillis();
		miGrafico = new JLabelDisparo();
		
	}

	public long getTiempoCreacion() {
		return TiempoCreacion;
	}

	public void setTiempoCreacion(long tiempoCreacion) {
		TiempoCreacion = tiempoCreacion;
	}

	public String getAtacante() {
		return Atacante;
	}

	public void setAtacante(String atacante) {
		Atacante = atacante;
	}

	public int getDa�o() {
		return da�o;
	}

	public void setDa�o(int da�o) {
		this.da�o = da�o;
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
	
	
	public void Avanzar(){
		this.x = this.x -3;
		int valor = (int) this.x;
		int valor2 = (int)  this.y;
		miGrafico.setLocation( valor, valor2);
		r.setLocation((int) (r.getX()-3), (int)this.y);
	}

	//To String para Pruebas
	public String toString() {
		return "Ataque [Atacante=" + Atacante + ", da�o=" + da�o + ", r=" + r + ", x=" + x + ", y=" + y + "]";
	}
	

	
	
	
	
	

}
