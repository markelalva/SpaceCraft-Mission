import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

import Clases.NaveJuego;

public class GenerarMundo {
	private JPanel panel;
	NaveJuego nave;	


	public GenerarMundo(JPanel panel) {
		this.panel = panel;
	} 
	
	public void cargarNave(double posx, double posy){
		nave = new NaveJuego();
		nave.setPosicion(posx, posy);
		panel.add( nave.getMiGrafico() );  // Añade al panel visual	
		nave.getMiGrafico().repaint();
	
	
		
		
}

	public NaveJuego getNave() {
		return nave;
	}
	
	

}
