import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Fondo extends javax.swing.JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3350439759763284828L;

	public Fondo(){
		this.setSize(994, 663);
		
	}
	
	public void paintComponent (Graphics e){
		Dimension medidas = getSize();
		ImageIcon Fondo = new ImageIcon(getClass().getResource("/img/fondo.jpg"));
		e.drawImage(Fondo.getImage(), 0, 0, medidas.width, medidas.height, null);
		setOpaque(false);
		super.paintComponent(e);
		
	}

}