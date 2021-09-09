package green.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/grade/input")
public class GradeInput extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>점수입력</title></head>");
		out.println("<body><h1>점수입력</h1>");
		out.println("<form action ='input' method='post'>");
		out.println("국어 : <input type='text' name ='korea'><br>");
		out.println("수학 : <input type='text' name ='math'><br>");
		out.println("등급 : <input type='text' name ='grade'><br>");
		out.println("<input type='submit' value='추가'>");
		out.println("</form></body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("JDBC:mysql://localhost:3306/servlet","root","3159");
			System.out.println(conn);
			stmt= conn.prepareStatement(
					"insert into migum(korea,math,grade) values(?,?,?)");
			stmt.setString(1, request.getParameter("korea"));
			stmt.setString(2, request.getParameter("math"));
			stmt.setString(3, request.getParameter("grade"));
			stmt.executeUpdate();
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter(); 
			out.println("<html><head><title>점수등록</title></head>");
			out.println("<body><p>등록되었습니다.</p></body></html>");
			response.addHeader("Refresh","1;url=list");
		
		}catch(Exception e) {
			throw new ServletException();
		} finally {
			try { if(stmt !=null) stmt.close();} catch(Exception e ) {}
			try { if(conn !=null) conn.close();} catch(Exception e ) {}
		}

}
	
}
