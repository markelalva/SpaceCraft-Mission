package Logica.Elementos;

import java.awt.Rectangle;

import Visual.JLabels.JLabelColumna;

public class Columna {
	public double x;
	public double y;
	private JLabelColumna migrafico;
	private double fechacreacion;
	private int tipo;
	public Rectangle r;

	// Pondremos tipo 0 si es inferior y tipo 1 si es superior
	// Creamos el JLabel
	public Columna(int x, int y, int tipo, int tamanyo, int color) {
		this.x = x;
		this.y = y;
		this.tipo = tipo;
		migrafico = new JLabelColumna(tamanyo, color);
		this.fechacreacion = System.currentTimeMillis();
		r = new Rectangle(x, y, tamanyo / 3, tamanyo - 10);

	}

	public Columna(int tamanyo, int color) {
		this.x = 0;
		this.x = 0;
		migrafico = new JLabelColumna(tamanyo, color);
		this.tipo = 0;
		r = new Rectangle((int) this.x, (int) this.y, tamanyo / 3, tamanyo - 20);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		migrafico.setLocation((int) x, (int) y);
		r.setLocation((int) this.x, (int) this.y);
	}

	public double getY() {
		return y;

	}

	public void setY(int y) {
		this.y = y;
		migrafico.setLocation((int) x, (int) y);
	}

	public JLabelColumna getMigrafico() {
		return migrafico;
	}

	public void setMigrafico(JLabelColumna migrafico) {
		this.migrafico = migrafico;
	}

	public void Avanzar(int Dificultad) {
		this.x = this.x - Dificultad;
		int valor = (int) this.x;
		int valor2 = (int) this.y;
		migrafico.setLocation(valor, valor2);
		r.setLocation((int) (r.getX() - Dificultad), (int) this.y);
	}

	public Rectangle getR() {
		return r;
	}

	public void AjustarColumna() {
		this.r.setLocation((int) this.x + 50, (int) this.y);
	}

}
