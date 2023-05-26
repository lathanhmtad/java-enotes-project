package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/enotes_management";
			String user = "root";
			String password = "1234";
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			return conn;
			
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
}
