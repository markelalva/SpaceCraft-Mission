package Logica;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class Log {
	public  static Logger logger = Logger.getLogger( "SpaceCraft-Mission" );
	
	
	public static void CargarLog(){
		logger.setLevel( Level.ALL );
		Handler h = new StreamHandler( System.out, new SimpleFormatter() );
		h.setLevel( Level.FINEST );
		//Por si queremos sacarlo a archivo.
		//logger.addHandler( new FileHandler( "EjemploLogger.log.xml") );
		
	}
	
	public static void Loggear(String mensaje, Level a){
		logger.log(a, mensaje);
		
	}
}
