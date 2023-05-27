package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCUtil {
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	public static Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driver_name"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			return conn;
			
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
}
