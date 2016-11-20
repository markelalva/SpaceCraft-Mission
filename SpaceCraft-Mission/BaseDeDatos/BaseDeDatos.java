import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

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

}
