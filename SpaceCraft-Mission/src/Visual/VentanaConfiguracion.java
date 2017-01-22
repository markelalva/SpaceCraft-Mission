package Visual;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.Messaging.SyncScopeHelper;

import Logica.BaseDeDatos;
import Logica.Configuracion;
import Logica.Log;
import Logica.Elementos.Jugador;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.logging.Level;
import java.awt.event.ActionEvent;

public class VentanaConfiguracion extends JFrame {

	private JPanel contentPane;
	private JLabel txtConfiguracin, txtColorNave, txtTeclas;
	JButton btnCancelar;
	private Configuracion modificada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jugador e = new Jugador();
					VentanaConfiguracion frame = new VentanaConfiguracion(e);
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
	public VentanaConfiguracion(Jugador jug) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Configuración");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtConfiguracin = new JLabel();
		txtConfiguracin.setText("CONFIGURACI\u00D3N");
		txtConfiguracin.setBounds(138, 11, 101, 31);
		contentPane.add(txtConfiguracin);

		txtColorNave = new JLabel();
		txtColorNave.setText("Color Nave:");
		txtColorNave.setBounds(31, 49, 86, 20);
		contentPane.add(txtColorNave);

		JRadioButton rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setBounds(31, 90, 109, 23);
		contentPane.add(rdbtnAzul);

		JRadioButton rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBounds(140, 90, 109, 23);
		contentPane.add(rdbtnRojo);

		JRadioButton rdbtnVerde = new JRadioButton("Verde");
		rdbtnVerde.setBounds(251, 90, 109, 23);
		contentPane.add(rdbtnVerde);

		txtTeclas = new JLabel();
		txtTeclas.setText("Teclas:");
		txtTeclas.setBounds(31, 146, 86, 20);
		contentPane.add(txtTeclas);

		JRadioButton rdbtnWasd = new JRadioButton("W,A,S,D");
		rdbtnWasd.setBounds(31, 194, 109, 23);
		contentPane.add(rdbtnWasd);

		JRadioButton radioButton = new JRadioButton("\u2190\u2191\u2192\u2193");
		radioButton.setBounds(174, 194, 109, 23);
		contentPane.add(radioButton);

		ButtonGroup BotonesNave = new ButtonGroup();
		ButtonGroup BotonesFlechas = new ButtonGroup();
		// Agrupamos los botones
		// 1ï¿½ Grupo
		BotonesNave.add(rdbtnAzul);
		BotonesNave.add(rdbtnVerde);
		BotonesNave.add(rdbtnRojo);
		// 2ï¿½ Grupo

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setToolTipText("Regresa a la ventana principal");
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal vp = new VentanaPrincipal(jug);
				vp.setVisible(true);
				dispose();
			}
		}
		);

		BotonesFlechas.add(rdbtnWasd);
		BotonesFlechas.add(radioButton);
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean seguir = true;
				modificada = new Configuracion();

				if (rdbtnAzul.isSelected() == false && rdbtnVerde.isSelected() == false
						&& rdbtnRojo.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Seleccione un color de nave");
					seguir = false;
				} else if (rdbtnWasd.isSelected() == false && radioButton.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Seleccione una configuracion de botones");
					seguir = false;
				} else if (rdbtnAzul.isSelected() == false && rdbtnVerde.isSelected() == false
						&& rdbtnRojo.isSelected() == false && rdbtnWasd.isSelected() == false
						&& radioButton.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Seleccione un color de nave y una configuracion de botones");
					seguir = false;
				} else if (rdbtnAzul.isSelected() == true) {
					modificada.setColorNave(Color.BLUE);
				} else if (rdbtnVerde.isSelected() == true) {
					modificada.setColorNave(Color.GREEN);
				} else if (rdbtnRojo.isSelected() == true)
					modificada.setColorNave(Color.RED);

				if (rdbtnWasd.isSelected() == true) {
					modificada.setTeclas("WASD");
				} else if (radioButton.isSelected() == true) {
					modificada.setTeclas("FLECHAS");
				}
				// Comprobamos si se ha modificado con la que existe en el
				// usuario.
			
				if (seguir) {
					
					if ((modificada.getColorNave() == jug.getConfi().getColorNave())
							&& (modificada.getTeclas().equals(jug.getConfi().getTeclas()))) {
						JOptionPane.showMessageDialog(null,
								"Ya disponías de esta configuracion, regresando al menï¿½ principal.");
						VentanaPrincipal vp = new VentanaPrincipal(jug);
						vp.setVisible(true);
						dispose();
					}

					else {
						JOptionPane.showMessageDialog(null,
								"Su configuraciï¿½n es correcta y ha sido guardada, pulse el botï¿½n salir para volver al menu.");
						Log.Loggear("El usuario : " + jug.getNombre() + "ha cambiado su configuracion.", Level.FINE);
						// La modificamos
						jug.setConfi(modificada);
						// La actualizamos en la base de datos
						// Creamos una nueva conexiï¿½n.
						Connection con = BaseDeDatos.initBD();
						BaseDeDatos.CambiarConfiguracion(BaseDeDatos.ObtenerStatement(con), jug);
						// Paramos 1 segundo
						try {
							Thread.sleep(500);
							con.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}

						VentanaPrincipal vp = new VentanaPrincipal(jug);
						vp.setVisible(true);
						dispose();

					}
				}
			}
		});
		btnAceptar.setBounds(228, 227, 89, 23);
		contentPane.add(btnAceptar);

	}

	public Configuracion getModificada() {
		return modificada;
	}

	public void setModificada(Configuracion modificada) {
		this.modificada = modificada;
	}

}
