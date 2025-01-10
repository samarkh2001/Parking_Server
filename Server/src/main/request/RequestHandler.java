package main.request;

import java.io.IOException;

import commons.entities.User;
import commons.requests.Message;
import commons.requests.RequestType;
import main.Configs;
import main.request.user.UserRequestHandler;
import ocsf.server.src.ConnectionToClient;


public class RequestHandler {

	public static void handleRequest(Message msg, ConnectionToClient client) {
		boolean success = false;
		User u;
		switch(msg.getRequestEnumType()) {
		case REGISTER:
			if (msg.getRequestData() instanceof User) {
				u = (User) msg.getRequestData();
				success = UserRequestHandler.register(u);
			}
			break;
		case LOGIN:
			if (msg.getRequestData() instanceof User) {
				u = (User) msg.getRequestData();
				u = UserRequestHandler.userLogin(u.getEmail(), u.getPassword());
				success = u != null;
				msg.setResponse(u);
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
