package com.daxv.common.ServerSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.daxv.common.ServerSocket.ListenerObj.ChatP2PListener;
import com.daxv.common.ServerSocket.ListenerObj.ChatRoomListener;
import com.daxv.common.ServerSocket.ListenerObj.LoginMsgListener;
import com.daxv.common.ServerSocket.ListenerObj.LoginOutListener;
 
 
/**
 * @author xu.da1
 * 服务端
 */
public class ChatServer {
	public static void main(String[] args) throws IOException {
		// ①　创建一个线程 等其他客户端的连接
	   final ServerSocket serverSocket  = new ServerSocket(8080); 
		System.out.println("---服务器启动---" + new Date().toString());
		 
		try {
			Thread thread=	new Thread(new Runnable() { 
					public void run() { 
						while (true) {
							  Connection conn=null;
							  try { 
								 Socket client =serverSocket.accept(); 
								 conn=new Connection(client);
								 conn.addOnRecevieMsgListener(new LoginMsgListener(conn));
								 conn.addOnRecevieMsgListener(new ChatP2PListener()); 
								 conn.addOnRecevieMsgListener(new ChatRoomListener()); 
								 conn.addOnRecevieMsgListener(new LoginOutListener());
								 conn.connect(); 								 
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
								conn.disconnect();
							} 
						} 
					} 
			 
			}, "123");
 
			thread.start();
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	 
	}
}
