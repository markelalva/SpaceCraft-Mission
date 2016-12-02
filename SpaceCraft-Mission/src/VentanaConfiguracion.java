import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Configuracion;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
					Configuracion e = new Configuracion();
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
	public VentanaConfiguracion(Configuracion usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		//Agrupamos los botones
		//1� Grupo
		BotonesNave.add(rdbtnAzul);
		BotonesNave.add(rdbtnVerde);
		BotonesNave.add(rdbtnRojo);
		//2� Grupo
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		
		BotonesFlechas.add(rdbtnWasd);
		BotonesFlechas.add(radioButton);
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificada = new Configuracion();
				
				if (rdbtnAzul.isSelected()== false && rdbtnVerde.isSelected()== false && rdbtnRojo.isSelected()== false){
					JOptionPane.showMessageDialog(null, "Seleccione un color de nave");
	
				}else if(rdbtnWasd.isSelected()==false&&radioButton.isSelected()==false){
					JOptionPane.showMessageDialog(null, "Seleccione una configuracion de botones");
				}else if(rdbtnAzul.isSelected()== false && rdbtnVerde.isSelected()== false && rdbtnRojo.isSelected()== false&&rdbtnWasd.isSelected()==false&&radioButton.isSelected()==false){
					JOptionPane.showMessageDialog(null, "Seleccione un color de nave y una configuracion de botones");
				}else if (rdbtnAzul.isSelected()== true ){
					modificada.setColorNave(Color.BLUE);
				}else if (rdbtnVerde.isSelected()== true ){
					modificada.setColorNave(Color.GREEN);
				}else if (rdbtnRojo.isSelected()== true )
					modificada.setColorNave(Color.RED);
				
				
				if (rdbtnWasd.isSelected()==true){
					modificada.setTeclas(0);
				}else if (radioButton.isSelected()==true){
					modificada.setTeclas(1);
				}
				//Comprobamos si se ha modificado con la que existe en el usuario.
					if (modificada.equals(usuario)){
						JOptionPane.showMessageDialog(null, "Ya dispon�as de esta configuracion, pulsa el boton salir para volver al menu.");
						
					}
					
					else{
					JOptionPane.showMessageDialog(null, "Su configuraci�n es correcta y ha sido guardada, pulse el bot�n salir para volver al menu.");
					System.out.println(modificada.toString());
				}
					btnCancelar.setText("Salir");
					btnAceptar.setEnabled(false);
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
