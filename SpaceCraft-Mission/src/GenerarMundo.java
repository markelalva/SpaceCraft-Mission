import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import Clases.Columna;
import Clases.NaveJuego;

public class GenerarMundo {
	private JPanel panel;
	NaveJuego nave;	
	public static Fondo panelfondo;
	protected ArrayList <Columna> ListaColumnas  = new ArrayList<Columna> ();
	public double distanciarecorrida = 0;



	public GenerarMundo(JPanel panel) {
		this.panel = panel;
		//Ponemos el Fondo
				/*panelfondo = new Fondo();
				panelfondo.setForeground(Color.WHITE);
				panelfondo.setBounds(0, 0, 994, 663);
				panel.add(panelfondo);
				panelfondo.setLayout(null);*/
			
	} 
	
	public void cargarNave(double posx, double posy){
		nave = new NaveJuego();
		nave.setPosicion(posx, posy);
		panel.add( nave.getMiGrafico() );  // A�ade al panel visual	
		nave.getMiGrafico().repaint();
	
	
		
		
}

	public NaveJuego getNave() {
		return nave;
	}
	//600, 465, 0
	
	public void CrearColumnaInferior(int tama�o){
		Columna col = new Columna(tama�o);
		col.setX(600);
		if (tama�o >=200)
		col.setY( (465 - (tama�o-200) ) );
		else
			col.setY(465+ (200 - tama�o) );
		panel.add( col.getMigrafico() );  // A�ade al panel visual	
		col.getMigrafico().repaint();
		ListaColumnas.add(col);
}
	//600, 0, 1
	public void CrearColumnaSuperior(int tama�o){
		Columna col = new Columna(tama�o);
		col.setX(600);
		col.setY(0);
		col.setTipo(1);
		panel.add( col.getMigrafico() );  // A�ade al panel visual	
		col.getMigrafico().repaint();
		ListaColumnas.add(col);

		
		
	}
	
	public void Avanzar(){
			for(Columna ee : ListaColumnas){
				ee.Avanzar();
			ee.getMigrafico().repaint();
			panel.repaint();
		
		}
			distanciarecorrida++;
	}


public boolean ComprobarChoques(){
	boolean chocan = false;
	for (Columna e : ListaColumnas){
	if(e.getR().intersects(nave.getR())){
	chocan = true;
	
	}
	System.out.println(chocan);

	
	
	}
	return chocan;
}
}
	
	
	


