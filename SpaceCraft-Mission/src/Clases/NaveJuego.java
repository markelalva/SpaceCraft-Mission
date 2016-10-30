package Clases;

import java.awt.Color;

import org.omg.Messaging.SyncScopeHelper;

public class NaveJuego extends Nave {
private JLabelNave miGrafico; 


public NaveJuego(Color c){
	//Le pasamos un color para elegir un icono u otro
	miGrafico = new JLabelNave(c);
	
	
}


public JLabelNave getMiGrafico() {
	return miGrafico;
}


public void setMiGrafico(JLabelNave miGrafico) {
	this.miGrafico = miGrafico;
}

@Override
public void setPosX(double posX) {
	super.setPosX(posX);
	miGrafico.setLocation( (int)posX, (int)posY );
}

@Override
public void setPosY(double posY) {
	super.setPosY(posY);
	miGrafico.setLocation( (int)posX, (int)posY );
}



}
