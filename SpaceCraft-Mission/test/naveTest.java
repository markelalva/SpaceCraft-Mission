import static org.junit.Assert.*;

import org.junit.Test;

import Logica.Configuracion;
import Logica.Elementos.NaveJuego;

public class naveTest {

	
	Configuracion con = new Configuracion();
	NaveJuego e = new NaveJuego(con);
	@Test
	public void test() {
	}
		@Test
		public void setPosXTest(){
			e.setPosX(200);
			assertTrue(200 == e.getPosX());
			assertTrue(200 == e.getMiGrafico().getX());
			assertTrue(200 == e.getR().getX());
		}
		@Test
		public void setPosYTest(){
			e.setPosY(300);
			assertTrue(300 == e.getPosY());
			assertTrue(300 == e.getMiGrafico().getY());
			assertTrue(300 == e.getR().getY());
		}
		
		
		
	
	

}
