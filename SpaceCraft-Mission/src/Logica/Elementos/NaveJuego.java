package Logica.Elementos;

import java.awt.Rectangle;

import Logica.Configuracion;
import Visual.JLabels.JLabelNave;

public class NaveJuego extends Nave {
	private JLabelNave miGrafico;
	private Rectangle r;

	public NaveJuego(Configuracion con) {
		// Le pasamos un color para elegir un icono u otro
		miGrafico = new JLabelNave(con);
		r = new Rectangle();
		r.setBounds(0, 0, 40, 30);

	}

	public JLabelNave getMiGrafico() {
		return miGrafico;
	}

	public void setMiGrafico(JLabelNave miGrafico) {
		this.miGrafico = miGrafico;
	}

	@Override
	public void setPosX(double posX) {
		super.setPosX(posX);
		miGrafico.setLocation((int) posX, (int) posY);
		r.setLocation((int) posX, (int) posY);

	}

	@Override
	public void setPosY(double posY) {
		super.setPosY(posY);
		miGrafico.setLocation((int) posX, (int) posY);
		r.setLocation((int) posX, (int) posY);
	}

	@Override
	public String toString() {
		return "NaveJuego [miGrafico=" + miGrafico + "]";
	}

	public Rectangle getR() {
		return r;
	}

}
