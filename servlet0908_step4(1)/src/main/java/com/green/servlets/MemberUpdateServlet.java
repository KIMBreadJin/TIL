package com.green.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDao;
import com.green.dto.Member;

@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	Connection conn =null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn =null;
		String no = request.getParameter("no"); 
		System.out.println("수정 get no =  " + no );
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
			conn = (Connection) sc.getAttribute("conn");
			memberDao.setConnection(conn);
			Member member =memberDao.selectOne(Integer.parseInt(no));
			request.setAttribute("member", member);
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberUpdateForm.jsp");
			rd.forward(request, response);
		} catch(Exception e ) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);		
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
			memberDao.setConnection(conn);
			memberDao.update(new Member()
							.setNo(Integer.parseInt(request.getParameter("no")))
							.setName(request.getParameter("name"))
							.setEmail(request.getParameter("email")));
			response.sendRedirect("list");			
		} catch (Exception e ) {
			e.printStackTrace();
			request.setAttribute("error",e);
			RequestDispatcher rd  = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
