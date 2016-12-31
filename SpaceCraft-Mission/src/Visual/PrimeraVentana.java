package Visual;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Logica.*;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.awt.event.ActionEvent;

public class PrimeraVentana extends JFrame {

	private JPanel contentPane;
	private JLabel MensajeBienvenida;
	private JButton btnQuieroJugar, btnSalir;
	private JTextField Jugador;
	// Prueba

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeraVentana frame = new PrimeraVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrimeraVentana() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		MensajeBienvenida = new JLabel("Bienvenido a SpaceCraft-Mission");
		MensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		MensajeBienvenida.setBounds(101, 11, 208, 43);
		contentPane.add(MensajeBienvenida);

		Connection con = BaseDeDatos.initBD();
		//También cargamos el Log
		Log.CargarLog();

		btnQuieroJugar = new JButton("Quiero Jugar");
		btnQuieroJugar.setBounds(159, 119, 129, 23);
		contentPane.add(btnQuieroJugar);
		btnQuieroJugar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO creamos la siguiente ventana.
				String NombreJugador = Jugador.getText();
				if (NombreJugador.length() == 0) {
					JOptionPane.showMessageDialog(null, "No ha introducido un nombre de usuario");

				}

				else {
					ResultSet rs = BaseDeDatos.ObtenerDatosUsuario(NombreJugador.toUpperCase(),
							BaseDeDatos.ObtenerStatement(con));
					boolean existe = true;
					try {
						rs.next();
						rs.getString("nickname");
					} catch (Exception ex) {
						existe = false;
					}
					Logica.Elementos.Jugador jug = null;
					if (existe) {
						try {
							JOptionPane.showMessageDialog(null,
									"Gracias por volver a jugar: " + rs.getString("nickname"));
								
							jug = BaseDeDatos.CargarJugador(rs);

							VentanaPrincipal vp = new VentanaPrincipal(jug);
							vp.setVisible(true);
							dispose();
						} catch (Exception ex) {

						}

					} else

					{
						BaseDeDatos.usuarioInsert(BaseDeDatos.ObtenerStatement(con), NombreJugador.toUpperCase());
						JOptionPane.showMessageDialog(null, "Bienvenido a SpaceCraft-Mission  " + NombreJugador);
						Log.Loggear("El Jugador " + NombreJugador + "Se ha loggeado correctamente", Level.INFO);
						jug = new Logica.Elementos.Jugador();
						jug.setNombre(NombreJugador);
						VentanaPrincipal vp = new VentanaPrincipal(jug);
						vp.setVisible(true);
						// Cerramos la conexiï¿½n
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();

					}

				}

			}

		});

		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Gracias por Jugar");
				System.exit(0);
			}
		});
		btnSalir.setBounds(345, 237, 89, 23);
		contentPane.add(btnSalir);

		Jugador = new JTextField();
		Jugador.setBounds(159, 65, 129, 20);
		contentPane.add(Jugador);
		Jugador.setColumns(10);

	}
}
