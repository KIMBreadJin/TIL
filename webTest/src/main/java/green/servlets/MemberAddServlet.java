package green.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("추가 서블릿으로 get 방식으로 들어왔구나 ");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>회원등록</title></head>");
		out.println("<body><h1>회원등록</h1>");
		out.println("<form action ='add' method='post'>");
		out.println("이름 : <input type='text' name ='name'><br>");
		out.println("이메일 : <input type='text' name ='email'><br>");
		out.println("암호 : <input type='password' name ='password'><br>");
		out.println("나이 :<input type='text' name='age'><br>");
		out.println("<input type='submit' value='추가'>");
		out.println("<input type='reset' value='취소'>");
		out.println("</form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기로 눌렀더니(submit 버튼)  post로 들어오나");
		System.out.println("홍말자 : "+ request.getParameter("dong"));
		System.out.println("이메일  : "+ request.getParameter("email"));
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 등록
			//DriverManager 스태택 메서드인 getConnection을 호출하면 Connection(연결)  객체 반환 
			// 첫번째 파라미터는 url (database포함) , 두번째 계정 ,세번째 비밀번호 
			conn = DriverManager.getConnection("JDBC:mysql://localhost:3306/servlet","root","3159");
			System.out.println(conn);
			stmt= conn.prepareStatement(
					"insert into members(email, pwd, mname, green, cre_date,mod_date) values(?,?,?,?,now(),now())");// Statement 를 생성하겠다 
			stmt.setString(1, request.getParameter("email"));
			stmt.setString(2, request.getParameter("password"));
			stmt.setString(3, request.getParameter("name"));
			stmt.setString(4, request.getParameter("age"));
			stmt.executeUpdate();// prepare(준비하고) ? 를 채우고 이해 실행함 
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter(); // 브라우저에 출력하는 기능 
			out.println("<html><head><title>회원등록결과</title></head>");
			out.println("<body><p>등록 성공입니다.</p></body></html>");
			response.addHeader("Refresh","1;url=list");
		
		}catch(Exception e) {
			throw new ServletException();//강제로 ServletException 객체 생성하여 던지기 
		} finally {// 객체 생성의 역순으로 닫기 
			try { if(stmt !=null) stmt.close();} catch(Exception e ) {}
			try { if(conn !=null) conn.close();} catch(Exception e ) {}
		}
	}
}