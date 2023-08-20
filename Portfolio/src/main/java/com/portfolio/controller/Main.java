package com.portfolio.controller;
import java.io.IOException;
import java.sql.SQLException;
import com.portfolio.operations.PostMessage;
import com.portfolio.contact.JDBCConfig;

/*		
 * 
 * 1. Add a Message
		2. Delete a Message
		3. Update a Message
*/

public class Main {

	public static void main(String[] args) throws IOException,SQLException {
		
		PostMessage pm = new PostMessage();
		pm.addPost();
		JDBCConfig.closeConnection();
		
	}

}
