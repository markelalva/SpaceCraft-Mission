package Clases;

public class Dificultades {
	private int DistanciaMapa;
	private int VelocidadAvance;
	private int DistanciaEntreColumnas;
	private int ImagenFondo;
	private int VelocidadMovimientoBoss;
	private int TiempoEntreAtaqueBoss;
	private int MaximoTamanyoDeColumna;

	public Dificultades(int Nivel) {
		 if (Nivel ==1 ){
		DistanciaMapa = 0;
		VelocidadAvance = 0;
		DistanciaEntreColumnas = 0;
		ImagenFondo = 0;
		VelocidadMovimientoBoss = 0;
		TiempoEntreAtaqueBoss = 0;
		MaximoTamanyoDeColumna = 0;
	}
		if (Nivel ==2){
			DistanciaMapa = 0;
			VelocidadAvance = 0;
			DistanciaEntreColumnas = 0;
			ImagenFondo = 0;
			VelocidadMovimientoBoss = 0;
			TiempoEntreAtaqueBoss = 0;
			MaximoTamanyoDeColumna = 0;
			
			
		}
		if (Nivel ==3){
			DistanciaMapa = 0;
			VelocidadAvance = 0;
			DistanciaEntreColumnas = 0;
			ImagenFondo = 0;
			VelocidadMovimientoBoss = 0;
			TiempoEntreAtaqueBoss = 0;
			MaximoTamanyoDeColumna = 0;
			
		}
	

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
}
