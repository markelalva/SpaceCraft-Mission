import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton ElegirMundo;
	private JButton MenuConfiguracion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
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
		
		
		
		ElegirMundo.setBounds(156, 117, 133, 28);
		contentPane.add(ElegirMundo);
		
		MenuConfiguracion = new JButton ("Configuración");
		MenuConfiguracion.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				
			}
		
		});
		MenuConfiguracion.setBounds(156, 198, 133, 28);
		contentPane.add(MenuConfiguracion);
	}
}
