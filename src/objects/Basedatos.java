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
	
	public static boolean insert(Item item) {
		boolean salida = false;
		
		try {
			Statement stm = Basedatos.connection.createStatement();
			
			if(item.getClass().getSimpleName().equals("Armadura")) {
				stm.executeUpdate("INSERT INTO item(nombre, item_type, valor, acciones) VALUES ('" + item.nombre + "', 'Armadura', " + item.valor + ", " + item.getNumAcciones() + ")");
				stm.executeUpdate("INSERT INTO armadura(nombre_item, armadura, peso) VALUES ('" + item.nombre + "', " + ((Armadura)item).getArmadura() + " , " + ((Armadura)item).getPeso() + ")");
			}else if(item.getClass().getSimpleName().equals("Arma")) {
				stm.executeUpdate("INSERT INTO item(nombre, item_type, valor, acciones) VALUES ('" + item.nombre + "', 'Arma', " + item.valor + ", " + item.getNumAcciones() + ")");
				stm.executeUpdate("INSERT INTO arma(nombre_item, agravio, peso) VALUES ('" + item.nombre + "', " + ((Arma)item).getAgravio() + " , " + ((Arma)item).getPeso() + ")");
			}else if(item.getClass().getSimpleName().equals("Consumible")) {
				stm.executeUpdate("INSERT INTO item(nombre, item_type, valor, acciones) VALUES ('" + item.nombre + "', 'Consumible', " + item.valor + ", " + item.getNumAcciones() + ")");
				stm.executeUpdate("INSERT INTO consumible(nombre_item, cantidad) VALUES ('" + item.nombre + "', " + ((Consumible)item).getCantidad() + ")");
			}
			
			for(int i = 0; i < item.getNumAcciones(); i++)
				stm.executeUpdate("INSERT INTO item_habilidad(item, habilidad) VALUES ('" + item.nombre + "', '" + item.getAcciones()[i].getNombre() + "')");
				
			
		}catch(SQLException e) {
			System.out.println("SQL mensaje: " + e.getMessage());
	      	System.out.println("SQL Estado: " + e.getSQLState());
	      	System.out.println("SQL codigo especifico: " + e.getErrorCode());
		}
		
		return salida;
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
