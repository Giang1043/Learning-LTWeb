package vn.lightforknight.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionMySQL {
	private static Connection conn = null;
	private static String USERNAME = "root";
	private static String PASSWORD = "014789";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://@localhost:3306/LTWeb";
	
	public static Connection getDataConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
	}
	

}
