package Clases;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelFondo extends JPanel {

	 int nivel=0;
	
	public JPanelFondo(int mundo){
		//this.setSize(1000, 750);
		nivel = mundo;
	}
	
	
	@Override
	public void paintComponent (Graphics g){
	//
	//Dimension tamaño = getSize();
	//Como no estamos usando un Jlabel no podemos utilizar el set Icon, asi que lo crearemos con el método ImageIcon
	ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/img/Fondo2.png"));
	g.drawImage(imagenFondo.getImage(),0,0,994, 663, null);
	setOpaque(false);
	super.paintComponent(g);
	}

	
	
	
}