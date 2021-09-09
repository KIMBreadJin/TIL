package red.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import red.dto.RedDto;

public class RedDao {
private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public List<RedDto> select() throws Exception{
		Statement stmt = null;
		ResultSet rs = null;
		List<RedDto> reds = new ArrayList<>();
		try {
			stmt = this.connection.createStatement();
			rs = stmt.executeQuery("select * from red_tbl");
			while(rs.next()) {
				String address = rs.getString("address");
				int age = rs.getInt("age");
				int phone = rs.getInt("phone");
				RedDto a = new RedDto();
				a.setAge(age);
				a.setAddress(address);
				a.setPhone(phone);
				reds.add(a);
			}
		} catch(Exception e) {
		
		}
		return reds;
	}
}
