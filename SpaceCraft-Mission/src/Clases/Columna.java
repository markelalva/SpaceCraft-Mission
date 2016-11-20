package Clases;

import java.awt.Rectangle;

public class Columna {
	public int x;
	public int y;
	private JLabelColumna migrafico;
	private double fechacreacion;
	private int tipo;
	//Pondremos tipo 0 si es inferior y tipo 1 si es superior
	//Creamos el JLabel
	public Columna(int x, int y, int tipo) {
		this.x = x;
		this.y = y;
		this.tipo = tipo;
		migrafico = new JLabelColumna();
		this.fechacreacion = System.currentTimeMillis();
		Rectangle r = new Rectangle();
		
		
		
	}
	
	public Columna(){
		this.x = 0;
		this.x = 0;
		migrafico = new JLabelColumna();
		this.tipo =0; 
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		migrafico.setLocation( (int)x, (int)y );
	}

	public int getY() {
		return y;
		
	}

	public void setY(int y) {
		this.y = y;
		migrafico.setLocation( (int)x, (int)y );
	}
	

	public JLabelColumna getMigrafico() {
		return migrafico;
	}

	public void setMigrafico(JLabelColumna migrafico) {
		this.migrafico = migrafico;
	}
	
	public void Avanzar(){
		this.x = this.x -1;
		migrafico.setLocation( x, y);
	}
	
	
	
	
	

}
