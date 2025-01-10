package main.request.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.MainServer;
import main.request.RequestHandler;

public class UserRequestHandler {
	
	public static boolean register(String email, String password) {
		if (userExist(email, password))
			return false;
		try {
			Statement st = MainServer.dbConnection.createStatement();
			int res = st.executeUpdate("INSERT INTO users (email, password) VALUES ('"+email+"','"+password+"')");
			return res > 0;
		} catch (SQLException e) {
			System.out.println("[UserRequestHandler] - failed to execute query");
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean userExist(String email, String password) {
		if (MainServer.dbConnection == null)
			return false;
		try {
			Statement st = MainServer.dbConnection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM users WHERE email='"+email+"' AND password='"+password+"'");
			if (!rs.next()) {
				RequestHandler.debug("UserRequestHandler", "result set was empty");
				return false;
			}
			rs.close();
			return true;
		} catch (SQLException e) {
			System.out.println("[UserRequestHandler] - failed to execute query");
			e.printStackTrace();
		}
		return false;
	}

}
