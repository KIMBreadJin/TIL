package com.green.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDao;


@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기 get 방식이 들어오는구나 ");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			System.out.println("13)" + conn);
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			request.setAttribute("members", memberDao.selectList()); 
			response.setContentType("text/html; charset=utf-8");		
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberList.jsp");
			rd.include(request, response);
		}catch(Exception e) {
			throw new ServletException();
		} finally {
			try { if(rs !=null) rs.close();} catch(Exception e ) {}
			try { if(stmt !=null) stmt.close();} catch(Exception e ) {}
			try { if(conn !=null) conn.close();} catch(Exception e ) {}
		}
	}
}
