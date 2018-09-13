package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbank {
	private static Connection con;
	private static Statement myStatement;
	private static ResultSet myRS;
	
	private static String ip = "aniira.de";
	private static String dbname = "m1";
	private static String user = "m1_user";
	private static String pw = "tai17.ring";
	
	public static boolean login() { 
		String path = "jdbc:mysql://"+ ip + "/" + dbname + "?serverTimezone=UTC";
		return connect(path, user, pw);
	}
		
	
	public static boolean login(String ip, String dbname, String user, String pw) {
		String path = "jdbc:mysql://"+ ip + "/" + dbname + "?serverTimezone=UTC";
		return connect(path, user, pw);
	}
	
	public static boolean connect(String path, String user, String pw) {
		try
		{
			con = DriverManager.getConnection(path, user, pw);
			System.out.println("Verbindung aufgebaut!");
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Verbindung fehlgeschlagen!");
			return false;
		}
	}

	
	public static boolean checkUser(String user, String pw) {
		try {
			myStatement=con.createStatement();
			myRS=myStatement.executeQuery(
					"SELECT id FROM nutzer WHERE user='" + user + "' and password='" + pw + "';");
			
			if (myRS.next()) {
				System.out.println("Etwas gefunden");
				return true;
			}
			System.out.println("NiX gefunden");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
		
	}
	
	
}
