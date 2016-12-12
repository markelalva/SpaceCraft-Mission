package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import Clases.Jugador;

public class BaseDeDatos {
	
	
	
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			return null;
		}
	}
	
	
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table usuarios " +
					"(nickname string, Colornave integer, Configuracion int, MaxPunt1 Integer, MaxPunt2 integer, MaxPunt3 Integer)");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer

			return statement;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean usuarioInsert( Statement st,String Nickname) {
		boolean correcto= true;
		
		String sentSQL = "";
		

			sentSQL = "Insert into usuario values(" +
					"'" + Nickname+"'0,0,0,0,0)";
					
		try {
			st.executeUpdate(sentSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			correcto=false;
		}	
		
	return correcto;

}
	public static boolean CambiarConfiguracion( Statement st, Jugador u,int TipoConfiguracion  ) {
		boolean completado = true;
		String sentSQL = "update usuarios set" +
				" Configuracion=" + TipoConfiguracion +
				" where nick='" + u.getNombre() + "'";
		try{
			st.executeUpdate(sentSQL);

	
	

} catch(Exception ex){
	completado = false;
}
		return completado;
	
	
}
	public static boolean CambiarColorNave( Statement st, Jugador u,int ColorNave  ) {
		boolean completado = true;
		String sentSQL = "update usuarios set" +
				" Configuracion=" + ColorNave +
				" where nick='" + u.getNombre() + "'";
		try{
			st.executeUpdate(sentSQL);

	
	

} catch(Exception ex){
	completado = false;
}
		return completado;
	
	
}
	public static boolean ActualizarPuntuacion( Statement st, Jugador u, int puntuacion, int numerodepuntuacion ) {

		boolean completado = true;
		String sentSQL = "update usuarios set" +
				" MaxPunt" + numerodepuntuacion + " =" + puntuacion +
				" where nick='" + u.getNombre() + "'";
		try{
			st.executeUpdate(sentSQL);

	
	

} catch(Exception ex){
	completado = false;
}
		return completado;
	
	
}
	public static ResultSet ObtenerDatosUsuario(String nickname, Statement st){
		ResultSet rs = null;
		String sentSql = "Select * from usuarios where nickname = '" + nickname + "'";
		
		 try {
			rs = st.executeQuery(sentSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs; 
	
		
		
		

	}
}