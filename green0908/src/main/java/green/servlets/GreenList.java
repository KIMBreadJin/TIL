package green.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.dao.GreenDao;

@SuppressWarnings("serial")
@WebServlet("/green/list")
public class GreenList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 등록
			conn = DriverManager.getConnection("JDBC:mysql://localhost:3306/servlet","root","3159");
			System.out.println(conn);
			
			GreenDao greens = new GreenDao();
			greens.setConnection(conn);
			RequestDispatcher rd = request.getRequestDispatcher("/green/list.jsp");
			request.setAttribute("greens", greens.select());
			rd.forward(request, response);
			
			}catch(Exception e) {
		}
	}

}
