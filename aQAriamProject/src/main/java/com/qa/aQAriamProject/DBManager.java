package com.qa.aQAriamProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBManager {

	// When testing the app, using a testDatabase 
	final String TEST_DB_URL = "jdbc:mysql://localhost:3306/testAquarium";
	
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/aquarium";
	final String USER = "root";
	final String PASSWORD = "root";

	Connection conn;

	public Connection connectDB() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(TEST_DB_URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			return conn;
		}
		System.out.println("Connected to Database succesfully :)");
		return conn;

	}

	public Fish convertResults(ResultSet result) {
		try {
			long id = result.getLong("id");
			String type = result.getString("type");
			String colour = result.getString("colour");
			int length = result.getInt("length");
			float cost = result.getFloat("cost");

			return new Fish(id, type, colour, length, cost);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
