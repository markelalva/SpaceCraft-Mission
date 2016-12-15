package Clases;

import java.awt.Rectangle;

public class Ataque {
	private String Atacante;
	private int danyo;
	private Rectangle r;
	private double x;
	private double y;
	private JLabelDisparo miGrafico;
	private long TiempoCreacion;

	public Ataque(String atacante, int danyo, double x, double y, JLabelDisparo miGrafico) {
		Atacante = atacante;
		this.danyo = danyo;
		this.r = new Rectangle();
		this.x = x;
		this.y = y;
		this.miGrafico = miGrafico;
		this.TiempoCreacion = System.currentTimeMillis();
	}

	public Ataque(boolean AtacaPlayer) {
		this.Atacante = "HatsuRobin";
		this.danyo = 0;
		this.r = new Rectangle();
		this.x = 0;
		this.y = 0;
		this.TiempoCreacion = System.currentTimeMillis();
		if (AtacaPlayer) {
			miGrafico = new JLabelDisparo(true);
			r.setBounds((int) x, (int) y, 20, 20);
		} else {
			miGrafico = new JLabelDisparo(false);
			r.setBounds((int) x, (int) y, 40, 40);
		}

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

	public int getDanyo() {
		return danyo;
	}

	public void setDanyo(int danyo) {
		this.danyo = danyo;
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
		// Colocamos el grafico a esa posicion
		miGrafico.setLocation((int) posX, (int) posY);
		r.setLocation((int) posX, (int) posY);
	}

	public void Avanzar(boolean EsJugador) {
		if (!EsJugador) {
			this.x = this.x - 3;
			int valor = (int) this.x;
			int valor2 = (int) this.y;
			miGrafico.setLocation(valor, valor2);
			r.setLocation((int) (r.getX() - 3), (int) this.y);
		} else {
			this.x = this.x + 3;
			int valor = (int) this.x;
			int valor2 = (int) this.y;
			miGrafico.setLocation(valor, valor2);
			r.setLocation((int) (r.getX() + 3), (int) this.y);
		}
	}

	// To String para Pruebas
	public String toString() {
		return "Ataque [Atacante=" + Atacante + ", da�o=" + danyo + ", r=" + r + ", x=" + x + ", y=" + y + "]";
	}

}
