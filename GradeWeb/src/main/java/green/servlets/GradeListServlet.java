package green.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/grade/list")
public class GradeListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); 	 
			conn = DriverManager.getConnection("JDBC:mysql://localhost:3306/servlet","root","3159");  
			System.out.println(conn);
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("select korea,math,grade from migum");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>점수</title></head>");
			out.println("<body><h1>점수</h1>");		
			while(rs.next()) {
				out.print("국어 :" + rs.getInt("korea") + ", "  +
						"수학 :" + rs.getInt("math") + ", " + 
						"등급 :" + rs.getString("grade")+ "<br>"
						);
			}
			out.println("<a href='input'><input type='submit' value='점수등록하기'></a>");
			out.println("</body></html>");
			
		}catch(Exception e) {
			throw new ServletException();
		}finally {
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(stmt != null) stmt.close();}catch(Exception e) {}
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}


}
