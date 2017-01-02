import static org.junit.Assert.*;

import org.junit.Test;

import Logica.Elementos.Columna;

public class ColumnaTest {
Columna e = new Columna(200, 2);
	@Test

	public void test() {
	
	}
	@Test
	public void setXTest(){
		e.setX(200);
		assertTrue(200 == e.getX());
		assertTrue (200 == e.getMigrafico().getX());
		assertTrue ( 200 == e.getR().getX());
	}
	
	@Test
	public void setYTest(){
		e.setY(300);
		assertTrue(300 == e.getY());
		assertTrue (300== e.getMigrafico().getY());
	}
	@Test
	public void AvanzarTest(){
		e.setX(0);
		e.Avanzar(10);
		System.out.println(e.getX());
		assertTrue(-10.0 == e.getX());
		assertTrue(-10.0 == e.getMigrafico().getX());
		assertTrue ( -10.0 == e.getR().getX());
	}

}
