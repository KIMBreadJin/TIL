package green.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	String name = request.getParameter("name");
	System.out.println("update"+no);
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		ServletContext sc = this.getServletContext(); //Singleton 패턴 (객체를 하나만 생성하고 공유)
		Class.forName(sc.getInitParameter("driver"));
		conn = DriverManager.getConnection(sc.getInitParameter("url"),
				sc.getInitParameter("username"),
				sc.getInitParameter("password"));
		System.out.println(conn);
		stmt = conn.createStatement();
		rs=stmt.executeQuery("select mno,email,mname,cre_date from members where mno = " + no);
		rs.next();
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("updateForm.jsp");
		Member member = new Member();
	
		member.setName(rs.getString("mname"));
				
			
		
		request.setAttribute("a", member);
		rd.include(request,response);
		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>회원정보</title></head>");
//		out.println("<body><h1>회원정보</h1>");
//		out.println("<form action = 'update' method='post'>");
//		out.println("번호 : <input type='text' name = 'no' value='" +no+ "' readonly><br>");
//		out.println("이름: <input type='text' name = 'name' value=" +rs.getString("mname")+ "><br>");
//		out.println("이메일: <input type='text' name = 'email' value=" +rs.getString("email")+ "><br>");
//		out.println("가입일: "+rs.getString("cre_date")+ "<br>");
//		out.println("<input type='submit' value='저장'>");
//		out.println("<input type='button' value='삭제' " + "onclick='location.href=\"delete?no=" + no + "\";'>");
//		out.println("<input type='button' value='취소' " + "onclick='location.href=\"list\"'>");
//		out.println("</form></body></html>");
	}catch(Exception e) {
		
	}finally {
		try{if(rs!=null) rs.close();} catch(Exception e ) {}
		try{if(stmt!=null) stmt.close();} catch(Exception e ) {}
		try{if(conn!=null) conn.close();} catch(Exception e ) {}
	}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("post로 잘 들어오나? "+ name);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {	
			ServletContext sc = this.getServletContext(); //Singleton 패턴 (객체를 하나만 생성하고 공유)
			Class.forName(sc.getInitParameter("driver"));
			conn = DriverManager.getConnection(sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			System.out.println(conn);
			pstmt = conn.prepareStatement("update members set email =?, mname=?, mod_date=now()  where mno = ?"
					);
			pstmt.setString(1, request.getParameter("email"));
			pstmt.setString(2, request.getParameter("name"));
			pstmt.setInt(3, Integer.parseInt(request.getParameter("no")));
			pstmt.executeUpdate();
			response.sendRedirect("list"); // list 페이지로 돌아가라(redirest);
			
		}catch(Exception e) {
			
		}finally {
			try{if(pstmt!=null) pstmt.close();} catch(Exception e ) {}
			try{if(conn!=null) conn.close();} catch(Exception e ) {}
		}
		
		
}
}