package org.keysoft.JpaRepository.Helper;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseHelper {
		
	private static final String DB_URL = "jdbc:mysql://localhost:5200/demo_db?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USERNAME =  "root";
    private static final String   PASSWORD = "Root@123";
	// max row of request to db
	public static final String CONNECTION_POOL = "100";
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			if (conn != null) {
				System.out.println("Connection successfully !");
			}
		} catch (Exception e) {
			System.err.println("Connection failured");
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
