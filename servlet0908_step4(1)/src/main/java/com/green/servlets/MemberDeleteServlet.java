package com.green.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDao;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@SuppressWarnings("serial")
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("삭제 get");
		Connection conn=null;
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao =(MemberDao) sc.getAttribute("memberDao");
			conn = (Connection) sc.getAttribute("conn");
			memberDao.setConnection(conn); 
			//AppinitServlet init 메서드에서 생성하여 저장한 Connection객체를 얻어와 memberDao에 setter로 전달
			memberDao.delete(Integer.parseInt(request.getParameter("no")));
			response.sendRedirect("list");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd =request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}


	

}
