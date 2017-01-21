package Visual;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Logica.Dificultades;
import Logica.Log;
import Logica.Elementos.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ElegirMundo extends JFrame {

	private JPanel contentPane;
	private JButton Mundo1, Mundo2, Mundo3;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElegirMundo frame = new ElegirMundo(new Jugador());
					frame.setVisible(true);
					System.out.println("HOLA");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ElegirMundo(Jugador usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ELEGIR MUNDO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(0, 11, 503, 45);
		contentPane.add(lblNewLabel);

		Mundo1 = new JButton("MUNDO 1");
		Mundo1.setToolTipText("Máxima Puntuacion de " + usuario.getNombre() + ": " +String.valueOf(usuario.getMaxPunt1()));
		Mundo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaJuego as = new VentanaJuego(usuario,new Dificultades(1));
				Log.Loggear("Mundo 1 Seleccionado..", Level.INFO);
				as.setVisible(true);
			}
		});
		Mundo1.setBounds(22, 92, 89, 23);
		contentPane.add(Mundo1);

		Mundo2 = new JButton("MUNDO 2");
		Mundo2.setToolTipText("Máxima Puntuacion de " + usuario.getNombre() + ": " +String.valueOf(usuario.getMaxPunt2()));
		Mundo2.setBounds(196, 92, 89, 23);
		contentPane.add(Mundo2);
		if (usuario.getMaxPunt1() == 0) {
			Mundo2.setEnabled(false);
		}
		Mundo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaJuego as = new VentanaJuego(usuario,new Dificultades(2));
				Log.Loggear("Mundo 2 Seleccionado..", Level.INFO);
				as.setVisible(true);
			}
		});
		Mundo3 = new JButton("MUNDO 3");
		Mundo3.setToolTipText("Máxima Puntuacion de " + usuario.getNombre() + ": " + String.valueOf( usuario.getMaxPunt3()));
		Mundo3.setBounds(364, 92, 89, 23);
		contentPane.add(Mundo3);
		if (usuario.getMaxPunt2() == 0) {
			Mundo3.setEnabled(false);
		}
		
		Mundo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaJuego as = new VentanaJuego(usuario,new Dificultades(3));
				Log.Loggear("Mundo 3 Seleccionado..", Level.INFO);
				as.setVisible(true);
			}
		});

		btnVolver = new JButton("VOLVER");
		btnVolver.setToolTipText("Regresa al men\u00FA principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vp = new VentanaPrincipal(usuario);
				vp.setVisible(true);
				dispose();

			}
		});
		btnVolver.setBounds(364, 259, 89, 23);
		contentPane.add(btnVolver);

	}
}
