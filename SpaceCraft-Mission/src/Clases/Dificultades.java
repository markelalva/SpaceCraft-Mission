package Clases;

public class Dificultades {
	private int DistanciaMapa;
	private int VelocidadAvance;
	private int DistanciaEntreColumnas;
	private int ImagenFondo;
	private int VelocidadMovimientoBoss;
	private int TiempoEntreAtaqueBoss;
	private int MinimoTamanyoDeColumna;
	private int MaximoTamanyoDeColumna;

	public Dificultades(int Nivel) {
		 if (Nivel ==1 ){
		DistanciaMapa = 2000;
		VelocidadAvance = 4;
		DistanciaEntreColumnas = 100;
		ImagenFondo = 1;
		VelocidadMovimientoBoss = 2;
		TiempoEntreAtaqueBoss = 1000;
		MinimoTamanyoDeColumna = 100;
		MaximoTamanyoDeColumna = 300;
	}
		if (Nivel ==2){
			DistanciaMapa = 3000;
			VelocidadAvance = 6;
			DistanciaEntreColumnas = 90;
			ImagenFondo = 2;
			VelocidadMovimientoBoss = 4;
			TiempoEntreAtaqueBoss = 750;
			MinimoTamanyoDeColumna = 200;
			MaximoTamanyoDeColumna = 300;
			
			
		}
		if (Nivel ==3){
			DistanciaMapa = 4000;
			VelocidadAvance = 8;
			DistanciaEntreColumnas = 80;
			ImagenFondo = 3;
			VelocidadMovimientoBoss = 6;
			TiempoEntreAtaqueBoss = 500;
			MinimoTamanyoDeColumna = 250;
			MaximoTamanyoDeColumna = 300;
			
		}
	//revisar tamanyo columna, igual no pasa la nave

}

	// Hacemos los getters, no necesitamos los Setters.
	public int getDistanciaMapa() {
		return DistanciaMapa;
	}

	public int getVelocidadAvance() {
		return VelocidadAvance;
	}

	public int getDistanciaEntreColumnas() {
		return DistanciaEntreColumnas;
	}

	public int getImagenFondo() {
		return ImagenFondo;
	}

	public int getVelocidadMovimientoBoss() {
		return VelocidadMovimientoBoss;
	}

	public int getTiempoEntreAtaqueBoss() {
		return TiempoEntreAtaqueBoss;
	}

	public int getMaximoTamanyoDeColumna() {
		return MaximoTamanyoDeColumna;
	}

	public int getMinimoTamanyoDeColumna() {
		return MinimoTamanyoDeColumna;
	}
	
}
