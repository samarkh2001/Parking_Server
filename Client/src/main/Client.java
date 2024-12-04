package main;

import java.io.IOException;

import ocsf.client.AbstractClient;

public class Client extends AbstractClient{
	public static Client connection;
	public static boolean connected = false;
	private boolean awaitResponse = true;
	
	
	public Client(String host, int port) {
		super(host, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleMessageFromServer(Object response) {
		// TODO Auto-generated method stub
		awaitResponse = false;
		System.out.println(response);
	}
	
	public void sendMessageToServer(String message) {
		try
	    {
	    	openConnection();//in order to send more than one message
	    	connected = true;
	    	awaitResponse = true;
	    	sendToServer(message);
			// wait for response
			while (awaitResponse) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	    }
	    catch(IOException e)
	    {
	    	connected = false;
	    	System.out.println("[Client] - Error sending message to server");
	    	e.printStackTrace();
	    }
	}
}
