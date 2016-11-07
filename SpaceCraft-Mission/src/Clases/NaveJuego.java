package Clases;

public class NaveJuego extends Nave {
private JLabelNave miGrafico; 


public NaveJuego (){
	//Le pasamos un color para elegir un icono u otro
	miGrafico = new JLabelNave();
	
	
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


@Override
public String toString() {
	return "NaveJuego [miGrafico=" + miGrafico + "]";
}








}
