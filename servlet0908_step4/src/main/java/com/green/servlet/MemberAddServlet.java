package com.green.servlet;

import java.io.IOException;

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
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {

	//입력화면 출력(display)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd =  request.getRequestDispatcher("/member/MemberForm.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
	}

	//입력하면 여기로 호출되고  데이터 베이스에 데이터 추가 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기로 눌렀더니(submit 버튼)  post로 들어오나");
		try {
			ServletContext sc= this.getServletContext();
			MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
			memberDao.insert(new Member().setEmail(request.getParameter("email"))
										.setPassword(request.getParameter("password"))
										.setName(request.getParameter("name"))
										);
					response.sendRedirect("list");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//태수 채현 지혜 혜원 희주 영진 강우 재욱 국한 세웅 
	// 세명 치원 세형 재영 

}
