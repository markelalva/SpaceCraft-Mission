import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrimeraVentana extends JFrame {

	private JPanel contentPane;
	private JLabel MensajeBienvenida;
	private JButton btnQuieroJugar, btnSalir;
	private JTextField Jugador;
	

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

		btnQuieroJugar = new JButton("Quiero Jugar");
		btnQuieroJugar.setBounds(159, 85, 106, 23);
		contentPane.add(btnQuieroJugar);
		btnQuieroJugar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			//TODO creamos la siguiente ventana.
			String NombreJugador = Jugador.getText();
			if (NombreJugador.length() ==0 ){
				JOptionPane.showMessageDialog(null, "No ha introducido un nombre de usuario");
				
				
			}
				
			}


		
			
			
			
		}
	);

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
		Jugador.setBounds(171, 130, 86, 20);
		contentPane.add(Jugador);
		Jugador.setColumns(10);
		
	
	}
}
