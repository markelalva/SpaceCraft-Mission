import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

import Clases.NaveJuego;

public class GenerarMundo {
	private JPanel panel;
	NaveJuego nave;	
	public static Fondo panelfondo;


	public GenerarMundo(JPanel panel) {
		this.panel = panel;
		//Ponemos el Fondo
				/*panelfondo = new Fondo();
				panelfondo.setForeground(Color.WHITE);
				panelfondo.setBounds(0, 0, 994, 663);
				panel.add(panelfondo);
				panelfondo.setLayout(null);*/
			
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
