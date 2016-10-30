import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JPanel Principal;
	JPanel mensajes;
	JLabel Tiempo;
	JLabel Puntuacion;
	
	public VentanaJuego(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Principal = new JPanel();
		mensajes = new JPanel();
		
		// Formato y layouts
				Principal.setLayout( null );
				Principal.setBackground( Color.white );
				// Añadido de componentes a contenedores
				getContentPane().add( Principal, BorderLayout.CENTER );
				// Formato de ventana
				setSize( 1000, 750 );
				setResizable( false );
		
		
		
	}

}
