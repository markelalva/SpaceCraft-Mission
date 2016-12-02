import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import Clases.Ataque;
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
	protected ArrayList <Ataque> ListaAtaques = new ArrayList <Ataque>();
	public double distanciarecorrida = 0;
	
	public GenerarMundo(JPanel panel1){
		panel = panel1;
		
	}



	
	public void cargarNave(double posx, double posy, Configuracion con){
		nave = new NaveJuego(con);
		nave.setPosicion(posx, posy);
		panel.add( nave.getMiGrafico() );  // A�ade al panel visual	
		nave.getMiGrafico().repaint();
	
	
		
		
}


	public NaveJuego getNave() {
		return nave;
	}
	//600, 465, 0
	
	public void CrearColumnaInferior(int tamanyo){
		Columna col = new Columna(tamanyo);
		col.setX(600);
		if (tamanyo >=200)
		col.setY( (465 - (tamanyo-200) ) );
		else
			col.setY(465+ (200 - tamanyo) );
		col.AjustarColumna();
		panel.add( col.getMigrafico() );  // A�ade al panel visual	
		col.getMigrafico().repaint();
		
		ListaColumnas.add(col);
}
	//600, 0, 1
	public void CrearColumnaSuperior(int tamanyo){
		Columna col = new Columna(tamanyo);
		col.setX(600);
		col.setY(0);
		col.r.setLocation(600+300, 0);
		col.AjustarColumna();
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
	
	public void AvanzaAtaques(){
		for(Ataque at : ListaAtaques){
			at.Avanzar();
		at.getMiGrafico().repaint();
		panel.repaint();
	
	}
}


public boolean ComprobarChoques(){
	boolean chocan = false;
	for (Columna e : ListaColumnas){
	if(e.getR().intersects(nave.getR())){

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

//Minimizamos el tama�o del array, para no ocupar memoria que no necesitamos.
ListaColumnas.trimToSize();
panel.repaint();
	}

//Metodo para Crear los Boss
public boolean cargarBoss(){
	boss = new Boss();
	boss.setPosicion(700, 200);
	panel.add( boss.getMiGrafico() );  // A�ade al panel visual	
	boss.getMiGrafico().repaint();
	
	return true;


	
	
}

public void AtacaBoss(){

	if (ListaAtaques.size() == 0 ){
		Ataque r = new Ataque ();
		r.setAtacante("HATSUROBIN");
		r.setDanyo(boss.getDanyoataque());
		r.setPosicion(boss.getX() -10, boss.getY());
		ListaAtaques.add(r);
		panel.add(r.getMiGrafico());
		r.getMiGrafico().repaint();
	}
		
	
	else{
		if ( (System.currentTimeMillis() - ListaAtaques.get(ListaAtaques.size() -1).getTiempoCreacion()) >1000 ){
	
			
		Ataque r = new Ataque ();
			r.setAtacante("HATSUROBIN");
			r.setDanyo(boss.getDanyoataque());
			r.setPosicion(boss.getX() -10, boss.getY());
			ListaAtaques.add(r);
			panel.add(r.getMiGrafico());
			r.getMiGrafico().repaint();
		}
		
	}
	
}
	
/*public void AtacaNave(){
	if (ListaAtaques.size() == 0 ){
		Ataque r = new Ataque ();
		r.setAtacante("HATSUROBIN2");
		r.setDanyo(nave.getDanyoataque());
		r.setPosicion(nave.getPosX() -10, nave.getPosY());
		ListaAtaques.add(r);
		panel.add(r.getMiGrafico());
		r.getMiGrafico().repaint();
	}
		
	
	else{
		
	
			
		Ataque r = new Ataque ();
			r.setAtacante("HATSUROBIN2");
			r.setDanyo(nave.getDanyoataque());
			r.setPosicion(nave.getPosX() -10, nave.getPosY());
			ListaAtaques.add(r);
			panel.add(r.getMiGrafico());
			r.getMiGrafico().repaint();
		}
		
	}
	
}*/
}

	
	
	


