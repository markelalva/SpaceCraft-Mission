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

import Clases.Jugador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JLabel lblNewLabel = new JLabel("elegir mundo");
		lblNewLabel.setBounds(102, 11, 273, 14);
		contentPane.add(lblNewLabel);
		
		Mundo1 = new JButton("1");
		Mundo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaJuego as = new VentanaJuego(usuario);
				as.setVisible(true);
			}
		});
		Mundo1.setBounds(22, 54, 89, 23);
		contentPane.add(Mundo1);
		
		Mundo2 = new JButton("2");
		Mundo2.setBounds(195, 54, 89, 23);
		contentPane.add(Mundo2);
		
		Mundo3  = new JButton("3");
		Mundo3.setBounds(364, 54, 89, 23);
		contentPane.add(Mundo3);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vp = new VentanaPrincipal(usuario);
				vp.setVisible(true);
				dispose();
				
				
			}
		});
		btnVolver.setBounds(364, 263, 89, 23);
		contentPane.add(btnVolver);
		

	}
}
