package green.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import green.dto.GreenDto;

public class GreenDao {
	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection= connection;
	}
	public List<GreenDto> select() throws Exception{
		Statement stmt =null;
		ResultSet rs =null;
		List<GreenDto> greens = new ArrayList<>();
		try {
			stmt = this.connection.createStatement();
			rs = stmt.executeQuery("select * from green_tbl");
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				GreenDto a = new GreenDto();
				a.setAge(age);
				a.setName(name);
				greens.add(a);
			}
		} catch( Exception e) {
		}
		return greens;
	}
	
}
