package red.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import red.dto.RedDto;

@SuppressWarnings("serial")
@WebServlet("/red/list2")
public class RedList2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("JDBC:mysql://localhost:3306/servlet","root","3159");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from red_tbl");
			List<RedDto> reds = new ArrayList<>();
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
			RequestDispatcher rd = request.getRequestDispatcher("/red/list.jsp");
			request.setAttribute("reds", reds);
			rd.forward(request, response);
			
			}catch(Exception e) {
		}
	}

}
