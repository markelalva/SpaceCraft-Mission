package Clases;

import java.awt.Component;
import java.awt.Rectangle;

public class Boss {
private double x;
private double y;
private int vida;
private int da�oataque;
private JLabelBoss miGrafico;
private Rectangle r;
private boolean arriba = true;//Constructor con todos los par�metros
public Boss(int x, int y, int vida, int da�oataque, Rectangle r) {
	super();
	this.x = x;
	this.y = y;
	this.vida = vida;
	this.da�oataque = da�oataque;
	this.r = r;
	miGrafico = new JLabelBoss();
}

public Boss() {
	this.x = 0;
	this.y = 0;
	this.vida = 100;
	this.da�oataque = 100;
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
public int getDa�oataque() {
	return da�oataque;
}
public void setDa�oataque(int da�oataque) {
	this.da�oataque = da�oataque;
}
public Rectangle getR() {
	return r;
}
public void setR(Rectangle r) {
	this.r = r;
}
//To String (Por si es necesario sacar alg�n dato por consola).
@Override
public String toString() {
	return "Boss [x=" + x + ", y=" + y + ", vida=" + vida + ", da�oataque=" + da�oataque + ", r=" + r + "]";
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
