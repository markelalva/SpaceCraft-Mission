package Visual;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.BaseDeDatos;
import Logica.Configuracion;
import Logica.Log;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4962475822908674877L;
	private JPanel contentPane;
	private JButton ElegirMundo;
	private JButton MenuConfiguracion;
	private JLabel NombreUsuario;
	private JButton btnExportarDatos;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { VentanaPrincipal frame = new
	 * VentanaPrincipal(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Logica.Elementos.Jugador usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		NombreUsuario = new JLabel(usuario.getNombre());
		NombreUsuario.setBounds(10, 43, 136, 14);
		contentPane.add(NombreUsuario);
		
				MenuConfiguracion = new JButton("Configuraci\u00F3n");
				MenuConfiguracion.setToolTipText("Elige c\u00F3mo quieres jugar");
				MenuConfiguracion.setBounds(171, 181, 165, 23);
				MenuConfiguracion.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						VentanaConfiguracion vc = new VentanaConfiguracion(usuario);
						vc.setVisible(true);
						dispose();
					}

				});
				
						ElegirMundo = new JButton("Seleccionar Nivel");
						ElegirMundo.setToolTipText("Selecciona un nivel");
						ElegirMundo.setBounds(171, 133, 165, 23);
						ElegirMundo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								
								ElegirMundo em = new ElegirMundo(usuario);
								em.setVisible(true);
								dispose();
							}
						});
						contentPane.add(ElegirMundo);
				contentPane.add(MenuConfiguracion);
		
		btnExportarDatos = new JButton("Exportar Datos");
		btnExportarDatos.setToolTipText("Obten tu diploma");
		if (usuario.getMaxPunt3() == 0){
			btnExportarDatos.setEnabled(false);
		}
		btnExportarDatos.setBounds(171, 230, 170, 23);
		btnExportarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Log.Loggear("Sus datos serán exportados a un .txt " , Level.INFO);
				PrintStream fich = null;
				try {
					fich = new PrintStream(new FileOutputStream("Puntuaciones_" + usuario.getNombre() +".txt"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fich.print("Enhorabuena, has conseguido pasarte el juego.");
				fich.println("DIPLOMA:");
				fich.println("Nombre: " + usuario.getNombre() );
				fich.println("Color De Nave Seleccionado : " + usuario.getConfi().getColorNave() );
				fich.println("Teclas a usar: " + usuario.getConfi().getTeclas() );
				fich.println("Máxima puntuación obtenida en el mundo 1: " + usuario.getMaxPunt1());
				fich.println("Máxima puntuación obtenida en el mundo 2: " + usuario.getMaxPunt2());
				fich.println("Máxima puntuación obtenida en el mundo 3: " + usuario.getMaxPunt3());
				fich.println(" ");
				fich.println("Gracias por jugar, esperemos haya cumplido sus expectativas.");
				
			}
		});
		contentPane.add(btnExportarDatos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Visual/img/barra-principal.png")));
		lblNewLabel.setBounds(156, 28, 200, 62);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeraVentana pv = new PrimeraVentana();
				pv.setVisible(true);
				dispose();
						
			}
		});
		btnNewButton.setToolTipText("Regresa al primer men\u00FA");
		btnNewButton.setBounds(171, 276, 165, 23);
		contentPane.add(btnNewButton);
	}
}
