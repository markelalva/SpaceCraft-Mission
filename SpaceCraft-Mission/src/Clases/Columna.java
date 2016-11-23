package Clases;

import java.awt.Rectangle;

public class Columna {
	public double x;
	public double y;
	private JLabelColumna migrafico;
	private double fechacreacion;
	private int tipo;
	public Rectangle r;
	//Pondremos tipo 0 si es inferior y tipo 1 si es superior
	//Creamos el JLabel
	public Columna(int x, int y, int tipo, int tamaño) {
		this.x = x;
		this.y = y;
		this.tipo = tipo;
		migrafico = new JLabelColumna(tamaño);
		this.fechacreacion = System.currentTimeMillis();
		r = new Rectangle(x,y, tamaño/3, tamaño -10);
		
		
		
	}
	
	public Columna(int tamaño){
		this.x = 0;
		this.x = 0;
		migrafico = new JLabelColumna(tamaño);
		this.tipo =0;
		r = new Rectangle( (int) this.x , (int) this.y,  tamaño/3, tamaño -20);
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
		migrafico.setLocation( (int)x, (int)y );
		r.setLocation((int)this.x, (int)this.y);
	}

	public double getY() {
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
		int valor = (int) this.x;
		int valor2 = (int)  this.y;
		migrafico.setLocation( valor, valor2);
		r.setLocation((int) (r.getX()-1), (int)this.y);
	}

	public Rectangle getR() {
		return r;
	}
	
	public void AjustarColumna(){
		this.r.setLocation((int)this.x +50,(int) this.y);
	}

	
	
	
	
	

}
