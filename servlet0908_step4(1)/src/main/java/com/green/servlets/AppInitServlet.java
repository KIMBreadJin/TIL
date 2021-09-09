package com.green.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.green.dao.MemberDao;


@SuppressWarnings("serial")
@WebServlet("/AppInitServlet")
public class AppInitServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("AppInitServet 준비 ....");
		super.init(config);
		ServletContext sc = this.getServletContext();
		try {
			Class.forName(sc.getInitParameter("driver"));
			Connection conn = DriverManager.getConnection(sc.getInitParameter("url"), sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			sc.setAttribute("conn", conn);
			MemberDao memberDao = new MemberDao();//meberDao에게 setConnectionPool을 통해 connectionPool 
			sc.setAttribute("memberDao", memberDao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		System.out.println("AppInitServlet 마무리 ....");
		super.destroy();
		Connection conn = (Connection)this.getServletContext().getAttribute("conn");
		try {
			if(conn != null && conn.isClosed() == false) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
