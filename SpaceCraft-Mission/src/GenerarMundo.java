import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import Clases.Ataque;
import Clases.Boss;
import Clases.Columna;
import Clases.Configuracion;
import Clases.Dificultades;
import Clases.JPanelFondo;
import Clases.NaveJuego;

public class GenerarMundo {
	private JPanel panel;
	private NaveJuego nave;
	public Boss boss;
	public static Fondo panelfondo;
	public Dificultades dif;
	protected ArrayList<Columna> ListaColumnas = new ArrayList<Columna>();
	protected ArrayList<Ataque> ListaAtaques = new ArrayList<Ataque>(); // Array
																		// para
																		// los
																		// ataques
																		// del
																		// Boss
	protected ArrayList<Ataque> ListaAtaquesNave = new ArrayList<Ataque>();
	public double distanciarecorrida = 0;
	public double puntuacion = 0;
	private Random r = new Random();// Para cosas en las que se necesite
									// aleatoriedad
	public int VidasJugador = 3;
	private int VidasBoss = 3;
	private double tiempojugado;

	public GenerarMundo(JPanel panel1, Dificultades dificultad) {
		panel = panel1;
		VidasJugador = 3;
		VidasBoss = 3;
		dif = dificultad;
		puntuacion = (dificultad.getDistanciaMapa() * 3);
		tiempojugado = System.currentTimeMillis();

	}

	public void cargarNave(double posx, double posy, Configuracion con) {
		nave = new NaveJuego(con);
		nave.setPosicion(posx, posy);
		panel.add(nave.getMiGrafico()); // A�ade al panel visual
		nave.getMiGrafico().repaint();

	}

	public NaveJuego getNave() {
		return nave;
	}
	// 600, 465, 0

	public void CrearColumnaInferior(int tamanyo, int color) {

		Columna col = new Columna(tamanyo, color);
		col.setX(600);
		if (tamanyo >= 200)
			col.setY((465 - (tamanyo - 200)));
		else
			col.setY(465 + (200 - tamanyo));
		col.AjustarColumna();
		panel.add(col.getMigrafico()); // A�ade al panel visual
		col.getMigrafico().repaint();

		ListaColumnas.add(col);
	}

	// 600, 0, 1
	public void CrearColumnaSuperior(int tamanyo, int color) {
		Columna col = new Columna(tamanyo, color);
		col.setX(600);
		col.setY(0);
		col.r.setLocation(600 + 300, 0);
		col.AjustarColumna();
		col.setTipo(1);
		panel.add(col.getMigrafico()); // A�ade al panel visual
		col.getMigrafico().repaint();

		ListaColumnas.add(col);

	}

	public void Avanzar() {
		for (Columna ee : ListaColumnas) {
			ee.Avanzar(dif.getVelocidadAvance());
			ee.getMigrafico().repaint();
			panel.repaint();

		}
		distanciarecorrida++;
	}

	public void AvanzaAtaquesBoss() {
		for (Ataque at : ListaAtaques) {
			at.Avanzar(false);
			at.getMiGrafico().repaint();
			panel.repaint();

		}
	}

	public void AvanzaAtaquesNave() {
		for (Ataque at : ListaAtaquesNave) {
			at.Avanzar(true);
			at.getMiGrafico().repaint();
			panel.repaint();

		}
	}

	public boolean ComprobarChoques() {
		boolean chocan = false;
		for (Columna e : ListaColumnas) {
			if (e.getR().intersects(nave.getR())) {

				chocan = true;

			}

		}
		return chocan;
	}

	// Metodo para borrar las columnas una vez que el Boss ha aparecido
	public void BorrarColumnas() {
		// Borramos todo
		for (Columna ee : ListaColumnas) {
			panel.remove(ee.getMigrafico());
		}
		ListaColumnas.clear();

		// Minimizamos el tama�o del array, para no ocupar memoria que no
		// necesitamos.
		ListaColumnas.trimToSize();
		panel.repaint();
	}

	// Metodo para Crear los Boss
	public boolean cargarBoss() {
		boss = new Boss();
		boss.setPosicion(700, 200);
		panel.add(boss.getMiGrafico()); // A�ade al panel visual
		boss.getMiGrafico().repaint();

		return true;

	}

	public void AtacaBoss() {

		if (ListaAtaques.size() == 0) {
			Ataque r = new Ataque(false);
			r.setAtacante("HATSUROBIN");
			r.setDanyo(boss.getDanyoataque());
			r.setPosicion(boss.getX() - 10, boss.getY());
			ListaAtaques.add(r);
			panel.add(r.getMiGrafico());
			r.getMiGrafico().repaint();
		}

		else {
			if ((System.currentTimeMillis() - ListaAtaques.get(ListaAtaques.size() - 1).getTiempoCreacion()) > dif.getTiempoEntreAtaqueBoss()) {

				Ataque r = new Ataque(false);
				r.setAtacante("HATSUROBIN");
				r.setDanyo(boss.getDanyoataque());
				r.setPosicion(boss.getX() - 10, boss.getY());
				ListaAtaques.add(r);
				panel.add(r.getMiGrafico());
				r.getMiGrafico().repaint();
			}

		}

	}

	public void AtacaNave() {
		if (ListaAtaquesNave.size() == 0) {
			Ataque r = new Ataque(true);
			r.setAtacante("PLAYER");
			r.setDanyo(nave.getDanyoataque());
			r.setPosicion(nave.getPosX() - 10, nave.getPosY());
			ListaAtaquesNave.add(r);
			panel.add(r.getMiGrafico());
			r.getMiGrafico().repaint();
		}

		else {

			if ((System.currentTimeMillis()
					- ListaAtaquesNave.get(ListaAtaquesNave.size() - 1).getTiempoCreacion()) > 1000) {

				Ataque r = new Ataque(true);
				r.setAtacante("PLAYER");
				r.setDanyo(nave.getDanyoataque());
				r.setPosicion(nave.getPosX() - 10, nave.getPosY());
				ListaAtaquesNave.add(r);
				panel.add(r.getMiGrafico());
				r.getMiGrafico().repaint();
			}
		}

	}

	public void ComprobarChoquesAtaques() {
		// Creo dos ArrayList temporales de Ataques, para almacenar los que
		// tengo que eliminar, y evitar un concurrentModificationException
		ArrayList<Ataque> ListaAtaquesTemp = new ArrayList<Ataque>(); // Array
																		// para
																		// los
																		// ataques
																		// del
																		// Boss
		ArrayList<Ataque> ListaAtaquesNaveTemp = new ArrayList<Ataque>();
		// Comprobamos que los ataques no choquen entre ellos, si chocan entre
		// ellos eliminamos los 2.
		if (ListaAtaques.size() > 0 && ListaAtaquesNave.size() > 0) {
			for (Ataque aNave : ListaAtaquesNave) {
				for (Ataque aBoss : ListaAtaques) {
					if (aBoss.getR().intersects(aNave.getR())) {
						panel.remove(aNave.getMiGrafico());
						panel.remove(aBoss.getMiGrafico());
						ListaAtaquesTemp.add(aBoss);
						ListaAtaquesNaveTemp.add(aNave);

					}
				}
			}

			panel.repaint();

		}
		for (Ataque a1 : ListaAtaquesTemp) {
			ListaAtaques.remove(a1);
		}
		for (Ataque a1 : ListaAtaquesNaveTemp) {
			ListaAtaquesNave.remove(a1);
		}
		ListaAtaquesTemp.clear();
		ListaAtaquesNaveTemp.clear();

		// Comprobamos que los ataques no choquen con el boss o el jugador
		// Impacto al Boss

		if (ListaAtaquesNave.size() > 0) {
			for (Ataque aNave : ListaAtaquesNave) {
				if (aNave.getR().intersects(boss.getR())) {
					panel.remove(aNave.getMiGrafico());
					ListaAtaquesNaveTemp.add(aNave);
					VidasBoss--;

				}
			}
		}
		// Impacto al Jugador
		if (ListaAtaques.size() > 0) {
			for (Ataque aBoss : ListaAtaques) {
				if (aBoss.getR().intersects(nave.getR())) {
					panel.remove(aBoss.getMiGrafico());
					ListaAtaquesTemp.add(aBoss);
					VidasJugador--;

				}
			}
		}

		for (Ataque a1 : ListaAtaquesTemp) {
			ListaAtaques.remove(a1);
		}
		for (Ataque a1 : ListaAtaquesNaveTemp) {
			ListaAtaquesNave.remove(a1);
		}

	}
	
	public void ActualizarPuntuacion(){
		puntuacion = (dif.getDistanciaMapa() * 3) - ((System.currentTimeMillis() - tiempojugado)/60) - 500*(3-VidasJugador);
	}

	public boolean SeSigueJugando() {
		if (VidasJugador == 0 || VidasBoss == 0)
			return false;
		else
			return true;
	}

	public int getVidasJugador() {
		return VidasJugador;
	}

	public void setVidasJugador(int vidasJugador) {
		VidasJugador = vidasJugador;
	}

	public int getVidasBoss() {
		return VidasBoss;
	}

	public void setVidasBoss(int vidasBoss) {
		VidasBoss = vidasBoss;
	}

	public double getPuntuacion() {
		return (int)puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public double getTiempojugado() {
		return tiempojugado;
	}
	
}
