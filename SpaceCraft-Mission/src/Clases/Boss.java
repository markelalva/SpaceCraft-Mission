package Clases;

import java.awt.Component;
import java.awt.Rectangle;

public class Boss {
private double x;
private double y;
private int vida;
private int dañoataque;
private JLabelBoss miGrafico;
private Rectangle r;
private boolean arriba = true;//Constructor con todos los parámetros
public Boss(int x, int y, int vida, int dañoataque, Rectangle r) {
	super();
	this.x = x;
	this.y = y;
	this.vida = vida;
	this.dañoataque = dañoataque;
	this.r = r;
	miGrafico = new JLabelBoss();
}

public Boss() {
	this.x = 0;
	this.y = 0;
	this.vida = 100;
	this.dañoataque = 100;
	miGrafico = new JLabelBoss();
	// TODO Auto-generated constructor stub
}

//Getters y Setters
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
public int getDañoataque() {
	return dañoataque;
}
public void setDañoataque(int dañoataque) {
	this.dañoataque = dañoataque;
}
public Rectangle getR() {
	return r;
}
public void setR(Rectangle r) {
	this.r = r;
}
//To String (Por si es necesario sacar algún dato por consola).
@Override
public String toString() {
	return "Boss [x=" + x + ", y=" + y + ", vida=" + vida + ", dañoataque=" + dañoataque + ", r=" + r + "]";
}

public void setPosicion(double posX, double posY) {
	setX(posX);
	setY(posY);
	//Colocamos el grafico a esa posicion
	miGrafico.setLocation( (int)posX, (int)posY );
}

public JLabelBoss getMiGrafico() {
	return miGrafico;
}

public void setMiGrafico(JLabelBoss miGrafico) {
	this.miGrafico = miGrafico;
}

public void MoverBoss(){
	if (arriba){
		setPosicion(this.x, this.y -2);
		if (this.y <0)
			arriba = false;
		
		
	}
	else{
		setPosicion(this.x, this.y+2);
		if (this.y >=500)
			arriba = true;
	}
	
}














}
