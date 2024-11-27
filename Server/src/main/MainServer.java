package main;

import java.io.IOException;

import ocsf.server.src.AbstractServer;
import ocsf.server.src.ConnectionToClient;

public class MainServer extends AbstractServer{
	
	private int port;
	
	public MainServer(int port) {
		super(port);
		this.port = port;
	}
	
	public void startServer() {
		try {
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
