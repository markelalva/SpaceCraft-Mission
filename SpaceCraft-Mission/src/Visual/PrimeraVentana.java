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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		setTitle("Inicio");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		MensajeBienvenida = new JLabel("Bienvenido a SpaceCraft-Mission");
		MensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);

		Connection con = BaseDeDatos.initBD();
		//También cargamos el Log
		Log.CargarLog();

		btnQuieroJugar = new JButton("Quiero Jugar");
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
							Log.Loggear("El Jugador " + NombreJugador + "Se ha loggeado correctamente", Level.INFO);
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
						Log.Loggear("El Jugador " + NombreJugador + " Se ha loggeado correctamente", Level.INFO);
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

		Jugador = new JTextField();
		Jugador.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(106)
					.addComponent(MensajeBienvenida, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(134)
					.addComponent(Jugador, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(162)
					.addComponent(btnQuieroJugar))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(350)
					.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(MensajeBienvenida, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(Jugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnQuieroJugar)
					.addGap(80)
					.addComponent(btnSalir))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
