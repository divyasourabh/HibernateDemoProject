package com.ds;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
//
//		Connection connection;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String dbPath = "jdbc:mysql:///living_being_database";
//			String username = "root";
//			String password = "Test@123";
//						
//			System.out.println("Connecting to database: " + dbPath);
//
//			connection = DriverManager.getConnection(dbPath, username, password);
//
//			System.out.println("Connection successful!!!");
//
//		}catch (Exception exc) {
//			exc.printStackTrace();
//		}
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "Test@123";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
