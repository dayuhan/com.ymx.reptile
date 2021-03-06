package com.daxv.common.WebSocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.daxv.common.Bus.SocketInfo;
import com.daxv.common.ToolKit.JSONUtils;
 

@ServerEndpoint("/webSocket/{username}")
public class WebSocket {
	private static int onlineCount = 0;
	private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
	private Session session;
	private String username;

	@OnOpen
	public void onOpen(@PathParam("username") String username, Session session)
			throws IOException {
		this.username = username;
		this.session = session;
		addOnlineCount();
		clients.put(username, this);
	}

	@OnClose
	public void onClose() throws IOException {
		clients.remove(username);
		subOnlineCount();
	}

	@OnMessage
	public void onMessage(String jsonMessAge) throws IOException {
		SocketInfo jsonTo = (SocketInfo) JSONUtils.jsonToBean(jsonMessAge,
				new SocketInfo());
		String mes = (String) jsonTo.getMessAge();
		if (!jsonTo.getTo().equals("All")) {
			sendMessageTo(mes, jsonTo.getTo().toString());
		} else {
			sendMessageAll(jsonTo.getMessAge());
		}
	}

	@OnError
	public void onError(Session session, Throwable error) {
		//error.printStackTrace();
		clients.remove(username);
	}

	public void sendMessageTo(String message, String To) throws IOException {
		for (WebSocket item : clients.values()) {
			if (item.username.equals(To))
				item.session.getAsyncRemote().sendText(message);
		}
	}

	public void sendMessageAll(String message) throws IOException {
		for (WebSocket item : clients.values()) {
			item.session.getAsyncRemote().sendText(message);
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocket.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocket.onlineCount--;
	}

	public static synchronized Map<String, WebSocket> getClients() {
		return clients;
	}

}