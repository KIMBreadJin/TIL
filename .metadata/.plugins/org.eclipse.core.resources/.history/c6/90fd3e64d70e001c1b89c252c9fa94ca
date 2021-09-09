package green.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@SuppressWarnings("serial")
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("삭제 get");
		Connection conn = null;
		Statement stmt = null;
		try {
			ServletContext sc = this.getServletContext();// Singleton 패턴 (객체를 하나만 생성하고 공유) 
			Class.forName(sc.getInitParameter("driver"));
			conn= DriverManager.getConnection(sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			stmt = conn.createStatement();
			stmt.executeUpdate("delete from members where mno =" + request.getParameter("no"));
			response.sendRedirect("list");
		} catch(Exception e) {
			
		}finally {
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
	}


	

}
