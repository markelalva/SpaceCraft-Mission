package Logica;

import java.awt.Color;
import java.sql.*;

import Logica.Elementos.Jugador;

public class BaseDeDatos {
	private static final String URL = "jdbc:postgresql://ec2-79-125-13-42.eu-west-1.compute.amazonaws.com:5432/ddq7vec664eksu?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	private static final String USERNAME = "whdcyqdctwfnjx";
	private static final String PASSWORD = "f468c95bedacc40a787b1d6fafe27a91bbc45309328b21d217003ab58a5930a7";

	public static Connection initBD() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return con;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	// Obtener statement

	public static Statement ObtenerStatement(Connection con) {
		Statement st = null;
		;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	public static Statement usarCrearTablasBD(Connection con) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg
			try {
				statement.executeUpdate("create table usuarios "
						+ "(nickname text not null primary key, Colornave integer, Configuracion text, MaxPunt1 Integer, MaxPunt2 integer, MaxPunt3 Integer)");
				System.out.println("TABLA CREADA");
			} catch (SQLException e) {
			} // Tabla ya existe. Nada que hacer

			return statement;
		} catch (SQLException e) {

			return null;
		}
	}

	public static boolean usuarioInsert(Statement st, String Nickname) {
		boolean correcto = true;

		String sentSQL = "";

		sentSQL = "Insert into usuarios values(" + "'" + Nickname + "',0,'WASD',0,0,0)";

		try {
			st.executeUpdate(sentSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			correcto = false;
		}

		return correcto;

	}

	public static boolean CambiarConfiguracion(Statement st, Jugador u) {
		boolean completado = true;
		int color = 0;

		if (u.getConfi().getColorNave() == Color.RED) {
			color = 1;
			;

		}
		if (u.getConfi().getColorNave() == Color.GREEN) {
			color = 2;
		}
		String sentSQL = "update usuarios set" + " ColorNave=" + color + ", Configuracion = '"
				+ u.getConfi().getTeclas() + "' where nickname='" + u.getNombre() + "'";
		try {
			st.executeUpdate(sentSQL);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return completado;

	}

	public static boolean CambiarColorNave(Statement st, Jugador u, int ColorNave) {
		boolean completado = true;
		String sentSQL = "update usuarios set" + " Configuracion=" + ColorNave + " where nickname='" + u.getNombre()
				+ "'";
		try {
			st.executeUpdate(sentSQL);

		} catch (Exception ex) {
			completado = false;
		}
		return completado;

	}

	public static boolean ActualizarPuntuacion(Statement st, Jugador u, int puntuacion, int numerodepuntuacion) {

		boolean completado = true;
		String sentSQL = "update usuarios set" + " MaxPunt" + numerodepuntuacion + " =" + puntuacion + " where nickname='"
				+ u.getNombre() + "'";
		try {
			st.executeUpdate(sentSQL);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return completado;

	}

	public static ResultSet ObtenerDatosUsuario(String nickname, Statement st) {
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

	public static Jugador CargarJugador(ResultSet rs) {
		Jugador e = new Jugador();
		try {
			System.out.println("Hola");
			e.setNombre(rs.getString("nickname"));

			e.setMaxPunt1(rs.getInt("MaxPunt1"));
			e.setMaxPunt2(rs.getInt("MaxPunt2"));
			e.setMaxPunt3(rs.getInt("MaxPunt3"));
			Configuracion confi = new Configuracion();
			confi.setTeclas(rs.getString("Configuracion"));
			int color = rs.getInt("ColorNave");
			if (color == 0) {
				confi.setColorNave(Color.BLUE);
				System.out.println("El usuario tiene el color azul");

			}
			if (color == 1) {
				confi.setColorNave(Color.RED);

			}
			if (color == 2) {
				confi.setColorNave(Color.GREEN);
			}
			e.setConfi(confi);

		} catch (Exception ex) {

		}
		return e;
	}
}