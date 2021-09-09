package com.green.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

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
		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			Connection conn = DriverManager.getConnection(sc.getInitParameter("url"),
					sc.getInitParameter("username"), sc.getInitParameter("password")
					);
			sc.setAttribute("conn", conn); // Connection 객체를 재활용 가능함 
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			sc.setAttribute("memberDao", memberDao);
		} catch(Throwable e) {
			throw new ServletException();
		}
	}

	public void destroy() {
		System.out.println("AppInitServlet 마무리 ....");
		super.destroy();
		Connection conn = (Connection) this.getServletContext().getAttribute("conn");
		try {
			if(conn!=null && conn.isClosed()==false) conn.close();
		} catch(Exception e) {}
	}

}
