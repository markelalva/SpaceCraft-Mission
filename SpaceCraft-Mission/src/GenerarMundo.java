import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

import Clases.NaveJuego;

public class GenerarMundo {
	JPanel panel;
	NaveJuego nave;	


	public GenerarMundo(JPanel panel) {
		this.panel = panel;
	} 
	
	public void cargarNave(){
		nave = new NaveJuego();
		nave.setPosX(100);
		nave.setPosY(100);
		panel.add( nave.getMiGrafico() );  // Añade al panel visual	
		nave.getMiGrafico().repaint();
	
	
		
		
}

	public NaveJuego getNave() {
		return nave;
	}
	
	

}
