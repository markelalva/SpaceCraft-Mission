package Interfaces;

import java.awt.Rectangle;

public interface ObjetoConMovimiento {
	
	public Rectangle getR();
	public void setR(Rectangle r);
	public double getX();
	public void setX(double x);
	public double getY();
	public void setY(double y);
	public void setPosicion(double posX, double posY);
}
