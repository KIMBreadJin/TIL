package servtest.servlets;

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

import servtest.dto.Choco;

@SuppressWarnings("serial")
@WebServlet("/green/list")
public class GreenList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dwdw");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("JDBC:mysql://localhost:3306/servlet","root","3159");   
			System.out.println(conn);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select korea, math, eng, address, phone, father from choco"); 
			response.setContentType("text/html; charset=utf-8");
			System.out.println("11");
			RequestDispatcher rd = request.getRequestDispatcher("chocoList.jsp");
			List<Choco> chocos = new ArrayList<>();
			while(rs.next()) {
				chocos.add(new Choco()
						.setKorea(rs.getInt("korea"))
						.setMath(rs.getInt("math"))
						.setEng(rs.getInt("eng"))					
						.setAddress(rs.getString("address"))
						.setPhone(rs.getString("phone"))
						.setFather(rs.getString("father"))
						);
			}
			request.setAttribute("chocos", chocos);	
			rd.include(request,response);
			
		}catch(Exception e) {
			throw new ServletException(); 
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(stmt != null) stmt.close();}catch(Exception e) {}
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
		}
}

