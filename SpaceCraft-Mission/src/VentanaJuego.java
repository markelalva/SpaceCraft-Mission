import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Clases.NaveJuego;


public class VentanaJuego extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JPanel Principal;
	JPanel mensajes;
	JLabel Tiempo;
	JLabel Puntuacion;
	GenerarMundo miMundo;
	NaveJuego nave;
	
	public VentanaJuego(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Principal = new JPanel();
		Principal.setBounds(0, 58, 994, 663);
		mensajes = new JPanel();
				getContentPane().setLayout(null);
		
		// Formato y layouts
				Principal.setLayout( null );
				Principal.setBackground( Color.white );
				// Añadido de componentes a contenedores
				getContentPane().add( Principal );
				
				JPanel Informacion = new JPanel();
				Informacion.setBackground(Color.YELLOW);
				Informacion.setBounds(0, 0, 994, 59);
				getContentPane().add(Informacion);
				Informacion.setLayout(null);
				
				JLabel Puntuacion1 = new JLabel("PUNTUACION:");
				Puntuacion1.setBounds(10, 21, 99, 14);
				Informacion.add(Puntuacion1);
				
				JLabel Tiempo1 = new JLabel("TIEMPO:");
				Tiempo1.setBounds(582, 21, 46, 14);
				Informacion.add(Tiempo1);
				// Formato de ventana
				setSize( 1000, 750 );
				setResizable( false );
		
		
				miMundo = new GenerarMundo( Principal );
				miMundo.cargarNave();
				nave = miMundo.getNave();
				Principal.repaint();
				
			}
		
	
	
}
