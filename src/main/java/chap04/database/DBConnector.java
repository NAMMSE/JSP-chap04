package chap04.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//0726 수업
public class DBConnector {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String id = "hr";
	private static String password = "1234";
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC Loading Success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC Loading Failed");
		}
	}
	
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		new DBConnector();
		System.out.println(DBConnector.getConnection());
	}

}
