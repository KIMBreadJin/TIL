package green.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.dto.Member;

@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no"); 
		System.out.println("수정 get no =  " + no );
		Connection conn =null;
		Statement stmt =null;
		ResultSet rs =null;
		try {
			ServletContext sc = this.getServletContext();// Singleton 패턴 (객체를 하나만 생성하고 공유) 
			Class.forName(sc.getInitParameter("driver"));
			conn= DriverManager.getConnection(sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			System.out.println(conn);//Connection 객체의 주소가 잘 떠야 합니다. 
			stmt= conn.createStatement(); 
			rs =stmt.executeQuery("select mno,email,mname, cre_date from members  " + 
					 " where mno = " +no);
			rs.next();
			response.setContentType("text/html; charset=utf-8");
			RequestDispatcher rd = request.getRequestDispatcher("UpdateForm.jsp");
			String email = rs.getString("email"); //db에서 가져온 이름 
			String name = rs.getString("mname"); //db에서 가져온 이름 
			no = rs.getString("mno"); //db에서 가져온 이름 
			Date cre_date = rs.getDate("cre_date");
			System.out.println("번호  : " +no + " 이름 : " + name + " 이메일  : " +  email);
			System.out.println("가입일   : " +cre_date);
			Member member =new Member().setCreatedDate(cre_date).setEmail(email)
					.setName(name).setNo(Integer.parseInt(no));
			request.setAttribute("m", member);
			rd.forward(request, response);
		}catch(Exception e) {
		}finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			ServletContext sc = this.getServletContext();// Singleton 패턴 (객체를 하나만 생성하고 공유) 
			Class.forName(sc.getInitParameter("driver"));
			conn= DriverManager.getConnection(sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			System.out.println(conn);//Connection 객체의 주소가 잘 떠야 합니다. 
			pstmt = conn.prepareStatement("update members set email =? ,mname=?, mod_date=now() " +
					" where mno  =?"
					);
			pstmt.setString(1, request.getParameter("email"));
			pstmt.setString(2, request.getParameter("name"));
			pstmt.setInt(3, Integer.parseInt(request.getParameter("no")));
			pstmt.executeUpdate();
			response.sendRedirect("list"); // list 페이지로 돌아가라(redirect);
		} catch(Exception e) {
			
		}finally {
			try {if(pstmt!=null) pstmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		
	}

}
