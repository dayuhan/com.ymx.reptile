package com.daxv.common.ServerSocket;

import java.util.HashMap;

/**
 * ���ӹ����� �������н������������
 */
public class ConnectionManager {
	public static HashMap<String, Connection> conns = new HashMap<String, Connection>();
 

	public static void remove(String account) {
		// TODO Auto-generated method stub
		conns.remove(account);
	}

	public static void addConns(Connection conn) {
		conns.put(conn.getWho().getAccount(), conn);
	}
	public static HashMap<String, Connection> getConns() {	
		return conns;
	}
 
}
