package Clases;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Clases.*;

public class JLabelNave extends JLabel {
	
		private static final long serialVersionUID = 1L;  // Para serialización
		public static final int TAMANYO_NAVE = 60;  // píxels (igual ancho que algo)
		public static final int RADIO_ESFERA_COCHE = 55;  // Radio en píxels del bounding circle del coche (para choques)
		private static final boolean DIBUJAR_ESFERA_NAVE = true;  // Dibujado (para depuración) del bounding circle de choque del coche
public JLabelNave(){
	//TODO Dependiendo del color que se le pase, se cogerá un icono u otro.
	try {
		setIcon( new ImageIcon(getClass().getResource("/img/nave.png")));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.err.println( "Error en carga de recurso: nave.png no encontrado" );
		
	}
	
	 setSize( TAMANYO_NAVE, TAMANYO_NAVE );  
	
	
	
}
		
		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
			Image img = ((ImageIcon)getIcon()).getImage();
			Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
			// Escalado más fino con estos 3 parámetros:
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
	        // Dibujado de la imagen
	        g2.drawImage( img, 0, 0, TAMANYO_NAVE, TAMANYO_NAVE, null );
	        if (DIBUJAR_ESFERA_NAVE) g2.drawOval( TAMANYO_NAVE/2-RADIO_ESFERA_COCHE, TAMANYO_NAVE/2-RADIO_ESFERA_COCHE,
	        		RADIO_ESFERA_COCHE*2, RADIO_ESFERA_COCHE*2 );
		}
	}

