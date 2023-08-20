package com.portfolio.contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConfig {
	private static Connection con = null;

    public static Connection getConnection() throws IOException {
        if (con != null) {
            return con;
        }

        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream("src/main/java/application.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception if needed
        }

        try {
            con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
            System.out.println("Connection Established");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQLException or rethrow it as needed
        }

        return con;
    }
	
	public static void closeConnection() throws SQLException {
		if(con != null)
				con.close();
		System.out.println("Connection Closed");
	}
		

}


