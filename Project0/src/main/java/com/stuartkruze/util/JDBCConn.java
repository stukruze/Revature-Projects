package com.stuartkruze.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBCConn {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		if(conn == null) {
		
			String endpoint = "database-1.cp3v0h9viwot.us-east-2.rds.amazonaws.com";
			String url = "jdbc:postgresql://" + endpoint + "/postgres";
			String username = "stukruze";
			String password = "password";
			
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return conn;
		
		
	}

	
	
}
