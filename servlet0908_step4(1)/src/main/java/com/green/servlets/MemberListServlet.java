package com.green.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기 get 방식이 들어오는구나 ");
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			ServletContext sc = this.getServletContext();
			conn =(Connection) sc.getAttribute("conn"); 
			System.out.println("13) list 서블릿 의 컨넥션 :" + conn);
			MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
			memberDao.setConnection(conn);
			// request에 회원 목록 데이터 보관함 
			request.setAttribute("members", memberDao.selectList()); //저장된 List의 members를 화면 출력(view)를
			response.setContentType("text/html; charset=utf-8"); //추가, 한글 깨짐 ,원래 있던것을 제거해서 문제 발생 
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberList.jsp");
			rd.include(request, response);// 여기로 돌아오다 
		}catch(Exception e) {
			throw new ServletException();//강제로 ServletException 객체 생성하여 던지기 
		} 
	}
	
	//jsp(view) 로 변경하니까 지금은 코드가 거지 같아도 우선 참으세요
	//refactoring 나가는 것을 경험하는 겁니다. 
	//M(Model/테이블객체/VO/Value Object ) V(view/jsp) C(controller/서블릿)  2  패턴을 적용합니다. 


	
}
