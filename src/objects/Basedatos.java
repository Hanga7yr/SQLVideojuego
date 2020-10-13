package objects;

import java.sql.*;

public abstract class Basedatos {
	private static Connection connection;
	
	private static String basedatos;
	private static String host;
	private static String port;
	private static String user;
	private static String pwd;
	private static String parAdic;
	private static String urlConnection;
	
	static {
		basedatos = "videojuego";
		host = "localhost";
		port = "3306";
		user = "root";
		pwd = "";
		parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
		
		
		
		try{Basedatos.connection = DriverManager.getConnection(urlConnection, user, pwd);}
		catch(SQLException e) {
			System.out.println("SQL mensaje: " + e.getMessage());
	      	System.out.println("SQL Estado: " + e.getSQLState());
	      	System.out.println("SQL codigo especifico: " + e.getErrorCode());
		} 
	}
	
	public static boolean insert(String str) {
		boolean salida = false;
		
		try {
			Statement stm = Basedatos.connection.createStatement();
			stm.executeUpdate("INSERT INTO " + str);
		}catch(SQLException e) {
			System.out.println("SQL mensaje: " + e.getMessage());
	      	System.out.println("SQL Estado: " + e.getSQLState());
	      	System.out.println("SQL codigo especifico: " + e.getErrorCode());
		}
		
		return salida;
	}
	
	public static ResultSet select(String str) {
		ResultSet result = null;
		
		try {
			Statement stm = Basedatos.connection.createStatement();
			result = stm.executeQuery(str);
		}catch(SQLException e) {
			System.out.println("SQL mensaje: " + e.getMessage());
	      	System.out.println("SQL Estado: " + e.getSQLState());
	      	System.out.println("SQL codigo especifico: " + e.getErrorCode());
		}
		
		return result;
	}
	
	public static int update(String str) {
		int result = 0;
		
		try {
			Statement stm = Basedatos.connection.createStatement();
			result = stm.executeUpdate(str);
		}catch(SQLException e) {
			System.out.println("SQL mensaje: " + e.getMessage());
	      	System.out.println("SQL Estado: " + e.getSQLState());
	      	System.out.println("SQL codigo especifico: " + e.getErrorCode());
		}
		
		return result;
	}
}
