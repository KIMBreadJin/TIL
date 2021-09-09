package com.green.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDao;

@SuppressWarnings("serial")
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	Connection conn = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("삭제 get");
		try {
			ServletContext sc = this.getServletContext();// Singleton 패턴 (객체를 하나만 생성하고 공유) 
			MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
			memberDao.delete(Integer.parseInt(request.getParameter("no")));
			response.sendRedirect("list");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error",e);
			RequestDispatcher rd= request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
	}

	}
	

}
