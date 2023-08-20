package com.portfolio.operations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.portfolio.contact.JDBCConfig;

public class PostMessage {
	Connection con = null;

	public PostMessage() throws IOException {
		con = JDBCConfig.getConnection();
	}

	public void addPost() throws SQLException {
		// System.out.println(con);
		if (con != null) {
			String name = "";
			String email = "";
			String message = "";
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Name:");
			scan.nextLine();
			System.out.println("Enter EmailID:");
			scan.nextLine();
			System.out.println("Enter Message:");
			scan.nextLine();
			if (name != null && email != null && message != null) {
				String insertQuery = "INSERT INTO Message(ContactName, EmailId, Message) VALUES (?, ?, ?)";

				try (PreparedStatement pstmt = con.prepareStatement(insertQuery)) {
					pstmt.setString(1, name);
					pstmt.setString(2, email);
					pstmt.setString(3, message);

					int rowsAffected = pstmt.executeUpdate();
					System.out.println("Rows Affected: " + rowsAffected);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
