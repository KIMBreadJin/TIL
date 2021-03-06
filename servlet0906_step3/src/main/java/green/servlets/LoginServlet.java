package green.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import green.dto.Member;

@SuppressWarnings("serial")
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =  request.getRequestDispatcher("/auth/LoginForm.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			ServletContext sc = this.getServletContext();// Singleton 패턴 (객체를 하나만 생성하고 공유) 
			Class.forName(sc.getInitParameter("driver"));
			conn= DriverManager.getConnection(sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			System.out.println(conn);//Connection 객체의 주소가 잘 떠야 합니다. 
			pstmt= conn.prepareStatement("select email,mname from members  " + 
					 " where email = ? and pwd = ? ");
			pstmt.setString(1, request.getParameter("email"));
			pstmt.setString(2, request.getParameter("password"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				Member member = new Member()
						.setEmail(rs.getString("email"))
						.setName(rs.getString("mname"));
				HttpSession session = request.getSession();
				session.setAttribute("member",member);
				response.sendRedirect("../member/list");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/auth/LoginFail.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e) {
		}finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			
		}
	}

}
