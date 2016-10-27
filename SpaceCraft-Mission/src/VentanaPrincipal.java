import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Configuracion;
import Clases.Jugador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton ElegirMundo;
	private JButton MenuConfiguracion;
	private JLabel NombreUsuario;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Jugador e) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ElegirMundo = new JButton("Seleccionar Nivel");
		ElegirMundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		ElegirMundo.setBounds(180, 118, 133, 28);
		contentPane.add(ElegirMundo);
		
		MenuConfiguracion = new JButton ("Configuración");
		MenuConfiguracion.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				VentanaConfiguración vc = new VentanaConfiguración();
				vc.setVisible(true);
				
				
				
			}
			
		
		});
		MenuConfiguracion.setBounds(180, 185, 133, 28);
		contentPane.add(MenuConfiguracion);
		
		JLabel lblNewLabel = new JLabel("Menu Principal (Cambiar por un icono)");
		lblNewLabel.setBounds(180, 23, 165, 46);
		contentPane.add(lblNewLabel);
		
		NombreUsuario = new JLabel(e.getNombre());
		NombreUsuario.setBounds(10, 23, 46, 14);
		contentPane.add(NombreUsuario);
	}
}
