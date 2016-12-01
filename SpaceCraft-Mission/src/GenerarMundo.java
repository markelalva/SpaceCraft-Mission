import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import Clases.Boss;
import Clases.Columna;
import Clases.Configuracion;
import Clases.JPanelFondo;
import Clases.NaveJuego;

public class GenerarMundo {
	private JPanel panel;
	private NaveJuego nave;	
	public Boss boss;
	public static Fondo panelfondo;
	protected ArrayList <Columna> ListaColumnas  = new ArrayList<Columna> ();
	public double distanciarecorrida = 0;
	
	public GenerarMundo(JPanel panel1){
		panel = panel1;
		
	}



	
	public void cargarNave(double posx, double posy, Configuracion con){
		nave = new NaveJuego(con);
		nave.setPosicion(posx, posy);
		panel.add( nave.getMiGrafico() );  // Añade al panel visual	
		nave.getMiGrafico().repaint();
	
	
		
		
}


	public NaveJuego getNave() {
		return nave;
	}
	//600, 465, 0
	
	public void CrearColumnaInferior(int tamaño){
		Columna col = new Columna(tamaño);
		col.setX(600);
		if (tamaño >=200)
		col.setY( (465 - (tamaño-200) ) );
		else
			col.setY(465+ (200 - tamaño) );
		col.AjustarColumna();
		panel.add( col.getMigrafico() );  // Añade al panel visual	
		col.getMigrafico().repaint();
		
		ListaColumnas.add(col);
}
	//600, 0, 1
	public void CrearColumnaSuperior(int tamaño){
		Columna col = new Columna(tamaño);
		col.setX(600);
		col.setY(0);
		col.r.setLocation(600+300, 0);
		col.AjustarColumna();
		col.setTipo(1);
		panel.add( col.getMigrafico() );  // Añade al panel visual	
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
		System.out.println("Coord Nave: " + nave.getR().toString());
		System.out.println("Coord Colum: " + e.getR().toString());

	chocan = true;
	
	}

	

	
	
	}
	return chocan;
}
//Metodo para borrar las columnas una vez que el Boss ha aparecido
public void BorrarColumnas(){
	//Borramos todo
for (Columna ee : ListaColumnas){
	panel.remove(ee.getMigrafico());
}
ListaColumnas.clear();

//Minimizamos el tamaño del array, para no ocupar memoria que no necesitamos.
ListaColumnas.trimToSize();
panel.repaint();
	}

//Metodo para Crear los Boss
public boolean cargarBoss(){
	boss = new Boss();
	boss.setPosicion(700, 200);
	panel.add( boss.getMiGrafico() );  // Añade al panel visual	
	boss.getMiGrafico().repaint();
	
	return true;


	
	
}
	
}

	
	
	


