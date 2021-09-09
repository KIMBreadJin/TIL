package green.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {

	//입력화면 출력(display)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =  request.getRequestDispatcher("/member/MemberForm.jsp");
		rd.forward(request, response);
	}

	//입력하면 여기로 호출되고  데이터 베이스에 데이터 추가 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기로 눌렀더니(submit 버튼)  post로 들어오나");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		request.setCharacterEncoding("utf-8");
		System.out.println("email : " + email +  "password: "+password+ "name : " +name );
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 등록
			conn = DriverManager.getConnection("JDBC:mysql://localhost:3306/servlet","root","1234");
			System.out.println(conn);
			stmt= conn.prepareStatement(
					"insert into members(email, pwd, mname, cre_date,mod_date) values(?,?,?,now(),now())");// Statement 를 생성하겠다 
			stmt.setString(1, email );
			stmt.setString(2, password);
			stmt.setString(3, name);
			stmt.executeUpdate();// prepare(준비하고) ? 를 채우고 이때  실행함 
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter(); // 브라우저에 출력하는 기능 
			out.println("<html><head><title>회원등록결과</title></head>");
			out.println("<body><p>등록 성공입니다.</p></body></htlm>");
			// 리프레시(refresh) 정보를 응답 헤더에 추가 
			 response.addHeader("Refresh", "1;url=list"); //1초 있다가 list url (MemberListServlet) 
			 //태수  희주 채현 혜원 치원 강우 지혜 
		}catch(Exception e) {
			throw new ServletException();//강제로 ServletException 객체 생성하여 던지기 
		} finally {// 객체 생성의 역순으로 닫기 
			try { if(stmt !=null) stmt.close();} catch(Exception e ) {}
			try { if(conn !=null) conn.close();} catch(Exception e ) {}
		}
	}
	//태수 채현 지혜 혜원 희주 영진 강우 재욱 국한 세웅 
	// 세명 치원 세형 재영 

}
