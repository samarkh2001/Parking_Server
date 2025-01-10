package main.request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.Configs;
import main.request.user.UserRequestHandler;
import ocsf.server.src.ConnectionToClient;
import requests.Message;
import requests.RequestType;

public class RequestHandler {
	
	@SuppressWarnings("unchecked")
	public static void handleRequest(Message msg, ConnectionToClient client) {
		boolean success = false;
		List<String> data;
		switch(msg.getRequestEnumType()) {
		case REGISTER:
			if (msg.getRequestData() instanceof ArrayList) {
				data = (ArrayList<String>) msg.getRequestData();
				success = UserRequestHandler.register(data.get(0), data.get(1));
			}
			break;
		default:
			respondToClient(client, new Message(RequestType.INVALID_DATATYPE, "Message Type was not found.", false));
			return;
		}
		msg.setSuccess(success);
		respondToClient(client, msg);
		
	}
	
	/**
	 * Sends a response to the client through their connection.
	 * 
	 * @param client The client connection through which to send the response.
	 * @param msg The message to be sent.
	 */
	public static void respondToClient(ConnectionToClient client, Message msg) {
		try {
			client.sendToClient(msg);
		} catch (IOException e) {
			System.out.println("[ServerRequestHandler] - Error responding to client");
			e.printStackTrace();
		}
	}
	
	public static void debug(String src, String msg) {
		if (!Configs.DEBUG)
			return;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(src);
		sb.append("] - ");
		sb.append(msg);
		System.out.println(sb.toString());
	}

}
