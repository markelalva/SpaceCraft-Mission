package Visual;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import Logica.BaseDeDatos;
import Logica.Dificultades;
import Logica.GenerarMundo;
import Logica.Elementos.*;
import Visual.JPanels.JPanelFondo;


public class VentanaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel Principal, Informacion1;
	JLabel Tiempo1, Puntuacion1, Tiempo2, Puntuacion2, Vida1Jugador, Vida2Jugador, Vida3Jugador, Vida1Boss, Vida2Boss,
			Vida3Boss;
	GenerarMundo miMundo;
	NaveJuego nave;
	boolean presionado[];
	MiRunnable Hilo = null;
	private Random r = new Random(); // Prueba
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private Dificultades dif;
	DateFormat formatoFechaLocal = DateFormat.getDateInstance(3, Locale.getDefault());
	Jugador jug;
	Connection con;

	public VentanaJuego(Jugador usuario, Dificultades dificultad) {
		jug = usuario;
		presionado = new boolean[5];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Principal = new JPanelFondo(dificultad.getImagenFondo());
		Principal.setBounds(0, 58, 994, 663);
		Principal.setFocusable(true);
		getContentPane().setLayout(null);
		dif = dificultad;
		con = BaseDeDatos.initBD();

		// Formato y layouts
		Principal.setLayout(null);
		Principal.setBackground(Color.WHITE);
		// A�adido de componentes a contenedores
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

		Vida1Jugador = new JLabel("");
		Vida1Jugador.setBounds(285, 15, 40, 27);
		Informacion1.add(Vida1Jugador);

		Vida2Jugador = new JLabel("");
		Vida2Jugador.setBounds(335, 15, 40, 27);
		Informacion1.add(Vida2Jugador);

		Vida3Jugador = new JLabel("");
		Vida3Jugador.setBounds(385, 15, 40, 27);
		Informacion1.add(Vida3Jugador);

		ImageIcon corazon = new ImageIcon("src/Visual/img/corazon.jpg");
		Icon icono1 = new ImageIcon(corazon.getImage().getScaledInstance(Vida1Jugador.getWidth(),
				Vida1Jugador.getHeight(), Image.SCALE_DEFAULT));
		Vida1Jugador.setIcon(icono1);
		Vida2Jugador.setIcon(icono1);
		Vida3Jugador.setIcon(icono1);

		Vida1Boss = new JLabel("");
		Vida1Boss.setBounds(760, 15, 40, 27);
		Informacion1.add(Vida1Boss);

		Vida2Boss = new JLabel("");
		Vida2Boss.setBounds(810, 15, 40, 27);
		Informacion1.add(Vida2Boss);

		Vida3Boss = new JLabel("");
		Vida3Boss.setBounds(860, 15, 40, 27);
		Informacion1.add(Vida3Boss);

		ImageIcon corazonlatino = new ImageIcon("src/Visual/img/corazonlatino.png");
		Icon icono2 = new ImageIcon(corazonlatino.getImage().getScaledInstance(Vida1Jugador.getWidth(),
				Vida1Jugador.getHeight(), Image.SCALE_DEFAULT));
		Vida1Boss.setIcon(icono2);
		Vida2Boss.setIcon(icono2);
		Vida3Boss.setIcon(icono2);
		this.repaint();

		Principal.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent a) {
				// Miramos el tipo de configuracion que tiene.
				// Flechas
				if (usuario.getConfi().getTeclas().equals("FLECHAS")) {
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
					// Dispàrar
					case KeyEvent.VK_SPACE:
						presionado[4] = true;
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
					// Atacar
					case KeyEvent.VK_SPACE:
						presionado[4] = true;
						break;

					}

				}

			}

			public void keyReleased(KeyEvent a) {
				if (usuario.getConfi().getTeclas().equals("FLECHAS")) {
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
					// DISPARAR
					case KeyEvent.VK_SPACE:
						presionado[4] = false;
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
					// DISPARAR
					case KeyEvent.VK_SPACE:
						presionado[4] = false;
						break;
					}

				}

			}

		});
		this.miMundo = new GenerarMundo(Principal, dif);
		this.miMundo.cargarNave(200, 300, usuario.getConfi());
		this.nave = miMundo.getNave();
		this.Principal.repaint();
		// PONEMOS A 0 EL TIEMPO.
		
		// Creamos las dos primeras columnas.
		int Color = r.nextInt(2);
		miMundo.CrearColumnaInferior(200, Color);
		miMundo.CrearColumnaSuperior(200, Color);

		// HILO
		this.Hilo = new MiRunnable(); // Sintaxis de new para clase interna
		Thread nuevoHilo = new Thread(this.Hilo);
		nuevoHilo.start();



	};

	// CREAMOS EL HILO PARA GESTIONAR TODO

	class MiRunnable implements Runnable {

		@Override
		public void run() {
			boolean boss = false;
			boolean seguir = true;
			boolean bosscargado = false;
			while (seguir) {
				// Miramos las posiciones del array para mover o no mover
				if (presionado[0] == true) {
					// Llamada al metodo de subir la nave
					nave.MovimientoEjeY(false);

				}
				if (presionado[1] == true) {
					// Llamada al metodo de bajar la nave
					nave.MovimientoEjeY(true);

				}
				if (presionado[2] == true) {
					// Llamada al metodo de ir avanzando
					miMundo.Avanzar();
				}
				if (presionado[3] == true) {
					// Llamada al metodo de retroceder.
				}

				// Aplicamos el efecto de la gravedad.
				nave.Gravedad();
				miMundo.ComprobarChoques();
				// Generamos mas columnas.
				if (!boss) {
					CrearColumnas();
					// Comprobamos los choques
					seguir = miMundo.SeSigueJugando();
					//Cargamos las Estrellas
					miMundo.CrearYBorrarEstrellas();
				}
				// Actualizamos los labels
				miMundo.ActualizarPuntuacion();
				Tiempo2.setText(String.valueOf((System.currentTimeMillis() - miMundo.getTiempojugado()) / 1000));
				Puntuacion2.setText(String.valueOf(miMundo.getPuntuacion()));
				// Eliminamos Vidas
				VentanaJuego.this.QuitarVidas();
				VentanaJuego.this.QuitarVidasBoss();
				// Cuando la distancia llegue a un valor, activamos el Modo
				// Boss.
				if (miMundo.distanciarecorrida > dif.getDistanciaMapa()) {
					boss = true;

					if (!bosscargado) {
						bosscargado = miMundo.cargarBoss();
						miMundo.BorrarColumnas();

					}
					miMundo.boss.MoverBoss(dif.getVelocidadMovimientoBoss());
					miMundo.AtacaBoss();
					miMundo.AvanzaAtaquesBoss();
					miMundo.AvanzaAtaquesNave();
					miMundo.ComprobarChoquesAtaques();
					
					

					seguir = miMundo.SeSigueJugando();
					if (presionado[4]) {
						miMundo.AtacaNave();
					}

				}
				miMundo.Avanzar();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if ( !seguir ) {
				System.out.println(bosscargado);
				if ((miMundo.VidasJugador == 0) || (!bosscargado)) {
					JOptionPane.showMessageDialog(null, "Ha perdido, intentalo de nuevo.");
					//Volvemos al menú principal
					ElegirMundo em = new ElegirMundo(jug);
					em.setVisible(true);
					dispose();
					

				} else {

					JOptionPane.showMessageDialog(null, "Ha ganado");

					//Actualizamos las puntuaciones tanto en el usuario como en la BD.
					if (dif.getImagenFondo() ==1){
						if ((int)miMundo.getPuntuacion() > jug.getMaxPunt1()){
						jug.setMaxPunt1((int)miMundo.getPuntuacion());
						BaseDeDatos.ActualizarPuntuacion(BaseDeDatos.ObtenerStatement(con), jug, (int)miMundo.getPuntuacion(), 1);
						}
					}
					if (dif.getImagenFondo() ==2){
						if ((int)miMundo.getPuntuacion() > jug.getMaxPunt2()){
						jug.setMaxPunt2((int)miMundo.getPuntuacion());
						BaseDeDatos.ActualizarPuntuacion(BaseDeDatos.ObtenerStatement(con), jug, (int)miMundo.getPuntuacion(), 2);
						}
					}
					else{
						if ((int)miMundo.getPuntuacion() > jug.getMaxPunt3()){
						jug.setMaxPunt3((int)miMundo.getPuntuacion());
						BaseDeDatos.ActualizarPuntuacion(BaseDeDatos.ObtenerStatement(con), jug, (int)miMundo.getPuntuacion(), 3);
						}
					}
					ElegirMundo em = new ElegirMundo(jug);
					em.setVisible(true);
					try{
						con.close();	
					}
					catch (Exception ex){
						
					}
					
					dispose();

				

				}
			}
		}

	}

	public void CrearColumnas() {
		r = new Random();
		int n = 0;
		if ((miMundo.distanciarecorrida / (miMundo.ListaColumnas.size() / 2)) > dif.getDistanciaEntreColumnas()) {
			do {
				n = r.nextInt(dif.getMaximoTamanyoDeColumna());

			} while (n < dif.getMinimoTamanyoDeColumna());
			int Color = r.nextInt(2);
			miMundo.CrearColumnaInferior(n, Color);
			miMundo.CrearColumnaSuperior(n, Color);
		}
	}

	public void QuitarVidas() {

		if (miMundo.getVidasJugador() > 0) {
			Vida1Jugador.setVisible(true);
		} else {
			Vida1Jugador.setVisible(false);
		}

		if (miMundo.getVidasJugador() > 1) {
			Vida2Jugador.setVisible(true);
		} else {
			Vida2Jugador.setVisible(false);
		}

		if (miMundo.getVidasJugador() > 2) {
			Vida3Jugador.setVisible(true);
		} else {
			Vida3Jugador.setVisible(false);
		}
	}

	public void QuitarVidasBoss() {

		if (miMundo.getVidasBoss() > 0) {
			Vida1Boss.setVisible(true);
		} else {
			Vida1Boss.setVisible(false);
		}

		if (miMundo.getVidasBoss() > 1) {
			Vida2Boss.setVisible(true);
		} else {
			Vida2Boss.setVisible(false);
		}

		if (miMundo.getVidasBoss() > 2) {
			Vida3Boss.setVisible(true);
		} else {
			Vida3Boss.setVisible(false);
		}
	}
}
