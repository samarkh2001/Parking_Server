package main;
import java.io.IOException;
import java.sql.Connection;
import main.databse.DatabaseConnector;
import ocsf.server.src.AbstractServer;
import ocsf.server.src.ConnectionToClient;

public class MainServer extends AbstractServer{
	public static Connection dbConnection;
	private int port;
	
	public MainServer(int port) {
		super(port);
		this.port = port;
	}
	
	public void startServer() {
		try {
			DatabaseConnector dbConnector = new DatabaseConnector();
			dbConnection = dbConnector.getConnection("jdbc:mysql://localhost/park_db?serverTimezone=IST","root","SK212142806sk");
			if(dbConnection != null)
				System.out.println("DataBase Connection successful");
			else
				System.out.println("Failed to connect to database");
			System.out.println("starting server on port " + port);
			listen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MainServer server = new MainServer(5555);
		server.startServer();
	}

	@Override
	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		// TODO Auto-generated method stub
		
	}

}
