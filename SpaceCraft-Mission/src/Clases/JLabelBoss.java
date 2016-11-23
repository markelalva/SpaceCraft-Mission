package Clases;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelBoss extends JLabel  {
	
	private static final long serialVersionUID = 1L;  // Para serialización
	private static final int TAMANYO_BOSS = 100;  // píxels (igual ancho que algo)  
	public JLabelBoss(){
		
		try {
			
			setIcon( new ImageIcon(getClass().getResource("/img/naveBoss1.png")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println( "Error en carga de recurso: columna.png no encontrado" );
			
		}
		
		 setSize( TAMANYO_BOSS, TAMANYO_BOSS );  
		
	}
			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
				Image img = ((ImageIcon)getIcon()).getImage();
				Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
				// Escalado más fino con estos 3 parámetros:
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
		        // Dibujado de la imagen
		        g2.drawImage( img, 0, 0, TAMANYO_BOSS, TAMANYO_BOSS, null );
		}
	}


