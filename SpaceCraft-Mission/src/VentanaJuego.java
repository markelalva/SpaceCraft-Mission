import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Clases.Columna;
import Clases.Jugador;
import Clases.NaveJuego;
public class VentanaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	static Fondo panelfondo;
	JPanel Principal, Informacion1;
	JLabel Tiempo1, Puntuacion1, Tiempo2,Puntuacion2;
	GenerarMundo miMundo;
	NaveJuego nave;
	boolean presionado[];
	MiRunnable Hilo = null;
	private double tiempojugado;
	
	


	public VentanaJuego(Jugador usuario) {

		
		presionado = new boolean[4];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Principal = new JPanel();
		Principal.setBounds(0, 58, 994, 663);
		Principal.setFocusable(true);
		getContentPane().setLayout(null);

		// Formato y layouts
		Principal.setLayout(null);
		Principal.setBackground(Color.WHITE);
		// Añadido de componentes a contenedores
		getContentPane().add(Principal, null);

		// Formato de ventana
		setSize(1000, 750);
		setResizable(false);
		
		

		Informacion1 = new JPanel();
		Informacion1.setBackground(Color.YELLOW);
		Informacion1.setBounds(0, 0, 994, 59);
		getContentPane().add(Informacion1);
		Informacion1.setLayout(null);

		Puntuacion1 = new JLabel("PUNTUACION:");
		Puntuacion1.setBounds(10, 21, 99, 14);
		Informacion1.add(Puntuacion1);

		 Tiempo1 = new JLabel("TIEMPO: ");
		Tiempo1.setBounds(582, 21, 87, 14);
		Informacion1.add(Tiempo1);
		
		Puntuacion2 = new JLabel("New label");
		Puntuacion2.setBounds(141, 21, 46, 14);
		Informacion1.add(Puntuacion2);
		
		Tiempo2 = new JLabel("New label");
		Tiempo2.setBounds(679, 21, 46, 14);
		Informacion1.add(Tiempo2);
		
		
		Principal.addKeyListener( new KeyAdapter () {
			public void keyPressed(KeyEvent a) {
				// Miramos el tipo de configuracion que tiene.
				// Flechas
				if (usuario.getConfi().getTeclas() == 0) {
					switch (a.getKeyCode()) {

					case KeyEvent.VK_UP:
						// SUBIR NAVE
						presionado[0] = true;
						break;

					case KeyEvent.VK_DOWN:
						// BAJAR NAVE
						presionado[1] = true;
						break;

					case KeyEvent.VK_RIGHT:
						// AVANZAR
						presionado[2] = true;
						break;

					case KeyEvent.VK_LEFT:
						// RETROCEDER
						presionado[3] = true;
						break;
					}

				} else {

					switch (a.getKeyCode()) {

					case KeyEvent.VK_W:
						// SUBIR NAVE
						presionado[0] = true;
						break;

					case KeyEvent.VK_S:
						// BAJAR NAVE
						presionado[1] = true;
						break;

					case KeyEvent.VK_D:
						// AVANZAR
						presionado[2] = true;
						break;

					case KeyEvent.VK_A:
						// RETROCEDER
						presionado[3] = true;
						break;
					}

				}

			}

			public void keyReleased(KeyEvent a) {
				if (usuario.getConfi().getTeclas() == 0) {

					switch (a.getKeyCode()) {

					case KeyEvent.VK_UP:
						// DEJAR DE SUBIR NAVE
						presionado[0] = false;
						
						break;

					case KeyEvent.VK_DOWN:
						// DEJAR DE BAJAR NAVE
						presionado[1] = false;
						break;

					case KeyEvent.VK_RIGHT:
						// PARAR
						presionado[2] = false;
						break;

					case KeyEvent.VK_LEFT:
						// PARAR
						presionado[3] = false;
						break;
					}

				} else {

					switch (a.getKeyCode()) {

					case KeyEvent.VK_W:
						// DEJAR DE SUBIR
						presionado[0] = false;
						break;

					case KeyEvent.VK_S:
						// DEJAR DE BAJAR NAVE
						presionado[1] = false;
						break;

					case KeyEvent.VK_D:
						// PARAR
						presionado[2] = false;
						break;

					case KeyEvent.VK_A:
						// PARAR
						presionado[3] = false;
						break;
					}

				}

			}
			

		});
		this.miMundo = new GenerarMundo(Principal);
		this.miMundo.cargarNave(200, 300);
		this.nave = miMundo.getNave();
		this.Principal.repaint();
		//PONEMOS A 0 EL TIEMPO.
		tiempojugado = System.currentTimeMillis();
		
		
		//HILO
		this.Hilo = new MiRunnable();  // Sintaxis de new para clase interna
		Thread nuevoHilo = new Thread( this.Hilo );
		nuevoHilo.start();
		
		//Creamos las dos primeras columnas.
		miMundo.CrearColumnaInferior();
		miMundo.CrearColumnaSuperior();

		

		
		


	};
	
	//CREAMOS EL HILO PARA GESTIONAR TODO
	
	class MiRunnable implements Runnable {

		@Override
		public void run() {
			boolean seguir = true;
			while (seguir){
			//Miramos las posiciones del array para mover o no mover
			if (presionado[0] == true){
				//Llamada al metodo de subir la nave
				nave.MovimientoEjeY(false);
				
			}
			 if (presionado[1] == true){
				//Llamada al metodo de bajar la nave
				nave.MovimientoEjeY(true);
				
			}
			 if (presionado[2] == true){
				//Llamada al metodo de ir avanzando
				System.out.println("Avanzando");
				miMundo.Avanzar();
			}
			 if (presionado [3] ==true){
				//Llamada al metodo de retroceder.
			}
			
			
			
		
			//Aplicamos el efecto de la gravedad.
				nave.Gravedad();
			//Generamos mas columnas.
				CrearColumnas();
			//Actualizamos los labels
				
				Tiempo2.setText(String.valueOf( (System.currentTimeMillis() - tiempojugado ) / 1000));
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		}

}
	
	public void CrearColumnas(){
		if ((miMundo.distanciarecorrida / (miMundo.ListaColumnas.size() /2)) >200 ){
		miMundo.CrearColumnaInferior();
		miMundo.CrearColumnaSuperior();
		}
	}
}
