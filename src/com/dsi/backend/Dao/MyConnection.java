package com.dsi.backend.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/vehicle";
		String username = "root";
		String password = "mysql";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
