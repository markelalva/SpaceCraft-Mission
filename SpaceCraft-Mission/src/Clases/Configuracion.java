package Clases;

import java.awt.Color;

public class Configuracion {
	//Atributos
	private Color ColorNave;
	private int Teclas;
	//Constructor con Parametros
	public Configuracion(Color colorNave, int teclas) {
		ColorNave = colorNave;
		Teclas = teclas;
	}
	
	//Constructor vacío
	
	public Configuracion(){
		
		this.ColorNave = Color.RED;
		this.Teclas = 0;
	}


	
	//Getter y Setters
	public Color getColorNave() {
		return ColorNave;
	}

	public void setColorNave(Color colorNave) {
		ColorNave = colorNave;
	}

	public int getTeclas() {
		return Teclas;
	}

	public void setTeclas(int teclas) {
		Teclas = teclas;
	}

	//ToString
	public String toString() {
		String teclas;
		if (Teclas ==0){
			teclas = "WASD";
		}
		else
			teclas ="Flechas";
	
	return "La configuración actual es : Usando las " + teclas + " y con la nave de color: " + this.ColorNave ;
	

	
	
	
	
	
	

}
}
