import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class VentanaConfiguración extends JFrame {

	private JPanel contentPane;
	private JTextField txtConfiguracin;
	private JTextField txtColorNave;
	private JTextField txtTeclas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfiguración frame = new VentanaConfiguración();
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
	public VentanaConfiguración() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtConfiguracin = new JTextField();
		txtConfiguracin.setText("CONFIGURACI\u00D3N");
		txtConfiguracin.setBounds(138, 11, 101, 31);
		contentPane.add(txtConfiguracin);
		txtConfiguracin.setColumns(10);
		
		txtColorNave = new JTextField();
		txtColorNave.setText("Color Nave:");
		txtColorNave.setBounds(31, 49, 86, 20);
		contentPane.add(txtColorNave);
		txtColorNave.setColumns(10);
		
		JRadioButton rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setBounds(31, 90, 109, 23);
		contentPane.add(rdbtnAzul);
		
		JRadioButton rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBounds(140, 90, 109, 23);
		contentPane.add(rdbtnRojo);
		
		JRadioButton rdbtnVerde = new JRadioButton("Verde");
		rdbtnVerde.setBounds(251, 90, 109, 23);
		contentPane.add(rdbtnVerde);
		
		txtTeclas = new JTextField();
		txtTeclas.setText("Teclas:");
		txtTeclas.setBounds(31, 146, 86, 20);
		contentPane.add(txtTeclas);
		txtTeclas.setColumns(10);
		
		JRadioButton rdbtnWasd = new JRadioButton("W,A,S,D");
		rdbtnWasd.setBounds(31, 194, 109, 23);
		contentPane.add(rdbtnWasd);
		
		JRadioButton radioButton = new JRadioButton("\u2190\u2191\u2192\u2193");
		radioButton.setBounds(174, 194, 109, 23);
		contentPane.add(radioButton);
		
		ButtonGroup BotonesNave = new ButtonGroup();
		ButtonGroup BotonesFlechas = new ButtonGroup();
		//Agrupamos los botones
		//1º Grupo
		BotonesNave.add(rdbtnAzul);
		BotonesNave.add(rdbtnVerde);
		BotonesNave.add(rdbtnRojo);
		//2º Grupo
		BotonesFlechas.add(rdbtnWasd);
		BotonesFlechas.add(radioButton);
		Configuracion config=new Configuracion();
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (rdbtnAzul.isSelected()== false && rdbtnVerde.isSelected()== false && rdbtnRojo.isSelected()== false){
					JOptionPane.showMessageDialog(null, "Seleccione un color de nave");
				}else if(rdbtnWasd.isSelected()==false&&radioButton.isSelected()==false){
					JOptionPane.showMessageDialog(null, "Seleccione una configuracion de botones");
				}else if(rdbtnAzul.isSelected()== false && rdbtnVerde.isSelected()== false && rdbtnRojo.isSelected()== false&&rdbtnWasd.isSelected()==false&&radioButton.isSelected()==false){
					JOptionPane.showMessageDialog(null, "Seleccione un color de nave y una configuracion de botones");
				}else if (rdbtnAzul.isSelected()== true ){
					config.setColorNave(Color.BLUE);
				}else if (rdbtnVerde.isSelected()== true ){
					config.setColorNave(Color.GREEN);
				}else if (rdbtnRojo.isSelected()== true ){
					config.setColorNave(Color.RED);
				}else if (rdbtnWasd.isSelected()==true){
					config.setTeclas(0);
				}else if (radioButton.isSelected()==true){
					config.setTeclas(1);
				}
			   }
		});
		btnAceptar.setBounds(228, 227, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		
	}
	
}
