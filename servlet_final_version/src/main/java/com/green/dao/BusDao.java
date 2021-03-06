package com.green.dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.dto.Bus;
import com.green.util.DBConnectionPool;

public class BusDao {
	DBConnectionPool connPool;
	public void setConnPool(DBConnectionPool connPool) { //setter
		this.connPool=connPool;
	}
	public List<Bus> selectList() throws Exception{ //BusListServlet에서의 DATABASE관련 코드 이동 
		Connection connection = null;
		Statement stmt =null;
		ResultSet rs = null;
		try {
			connection = connPool.getConnection();
			stmt= connection.createStatement();
			rs =stmt.executeQuery(
					"select * from bus_tbl"
					);
			List<Bus> buses = new ArrayList<>();
			while(rs.next()) {
				buses.add(new Bus()
						.setAddress(rs.getInt("address"))
						.setPhone(rs.getInt("phone"))
						.setFather(rs.getInt("father"))
						.setMother(rs.getInt("mother"))
						.setSon(rs.getInt("son"))
						.setName(rs.getString("name"))
						);
			}
			return buses;
		} catch(Exception e ) {
			throw e;
		} finally {
			try { if(rs!=null) rs.close(); } catch(Exception e) {}
			try { if(stmt!=null) stmt.close(); } catch(Exception e) {}
			if(connection !=null) connPool.returnConnection(connection); //사용후 반납  
		}
	}
}
