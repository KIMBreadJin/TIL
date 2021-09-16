package com.green.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionPool {
	String url;
	String username;
	String password;
	List<Connection> connList = new ArrayList<>();
	public DBConnectionPool(String driver, String url, String username, String password) throws Exception{
		this.url = url;
		this.username = username;
		this.password = password;
		Class.forName(driver);
	}
	public Connection getConnection() throws Exception{
		if(connList.size() > 0) {
			Connection conn = connList.get(0);
			if(conn.isValid(10)) return conn;
		}
		return DriverManager.getConnection(url,username,password);
	}
	public void returnConnection(Connection conn) throws Exception{
		connList.add(conn);
	}
	public void closeAll() {
		for(Connection conn : connList){
			try {conn.close();} catch (Exception e) {}
		}
	}
	//DBConnectionPool은 DB에 접속하기 위한 COnnection 객체를 저장하고 이싿가 필요시 가져다 사용하고 다 사용하면 반납함
	// 필요시 getConnectionPool 호출하여 Connection 객체 가져다 사용하고 다사용하고 나서 returnConnection호출하여 반납
}
