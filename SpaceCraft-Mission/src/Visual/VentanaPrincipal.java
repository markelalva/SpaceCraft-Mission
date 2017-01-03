package Visual;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Configuracion;
import Logica.Log;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

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
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("46px"),
				ColumnSpec.decode("124px"),
				ColumnSpec.decode("165px"),},
			new RowSpec[] {
				RowSpec.decode("23px"),
				RowSpec.decode("46px"),
				RowSpec.decode("49px"),
				RowSpec.decode("28px"),
				RowSpec.decode("39px"),
				RowSpec.decode("28px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lblNewLabel = new JLabel("Menu Principal (Cambiar por un icono)");
		contentPane.add(lblNewLabel, "4, 2, fill, fill");

		NombreUsuario = new JLabel(usuario.getNombre());
		contentPane.add(NombreUsuario, "2, 2, fill, top");
		
				MenuConfiguracion = new JButton("Configuraciï¿½n");
				MenuConfiguracion.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						VentanaConfiguracion vc = new VentanaConfiguracion(usuario);
						vc.setVisible(true);
						dispose();
					}

				});
				
						ElegirMundo = new JButton("Seleccionar Nivel");
						ElegirMundo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ElegirMundo em = new ElegirMundo(usuario);
								em.setVisible(true);
								dispose();
							}
						});
						contentPane.add(ElegirMundo, "4, 5, left, top");
				contentPane.add(MenuConfiguracion, "4, 10, left, fill");
		
		btnExportarDatos = new JButton("Exportar Datos");
		btnExportarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Log.Loggear("Sus datos serán exportados a un .txt " , Level.INFO);
				PrintStream fich = null;
				try {
					fich = new PrintStream(new FileOutputStream("Puntuaciones_" + usuario.getNombre()));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fich.println("Nombre: " + usuario.getNombre() );
				fich.println("Color De Nave Seleccionado : " + usuario.getConfi().getColorNave() );
				fich.println("Teclas a usar: " + usuario.getConfi().getTeclas() );
				fich.println("Máxima puntuación obtenida en el mundo 1: " + usuario.getMaxPunt1());
				fich.println("Máxima puntuación obtenida en el mundo 2: " + usuario.getMaxPunt2());
				fich.println("Máxima puntuación obtenida en el mundo 3: " + usuario.getMaxPunt3());
				
			}
		});
		contentPane.add(btnExportarDatos, "2, 12, 2, 1");
	}
}
