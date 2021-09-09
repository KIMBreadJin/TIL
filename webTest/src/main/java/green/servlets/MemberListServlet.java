package green.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("여기 get 방식이 들어오는구나");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // 데이터베이스 조회 결과가 저장됨
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 등록
			 
			 //DriverManager 스태틱 메서드인 getconnection을 호출하면 Connection 객체 반환
			conn = DriverManager.getConnection("JDBC:mysql://localhost:3306/servlet","root","3159");  // 파라미터는 (url (datavase 포함) , 계정, 비밀번호) 
			System.out.println(conn);
			stmt = conn.createStatement(); // statement 를 실행
			rs = stmt.executeQuery("select MNO,MNAME,EMAIL,GREEN,CRE_DATE from members"); //문자열로 sql query 실행
			//조회된 데이터가 ResultSet에 저장
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter(); //브라우저에 출력
			//
			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");
			out.println("<p><a href='add'>신규회원</a></p>");
			while(rs.next()) {
				out.print(rs.getInt("MNO") + ", " + "<a href='update?no="+ rs.getInt("MNO") + "'>" +
						rs.getString("MNAME") + "</a> , " + 
						rs.getString("EMAIL")+ ", " +
						rs.getInt("GREEN")+", "+
						rs.getDate("CRE_DATE") +
						"<a href ='delete?no=" + rs.getInt("MNO")+"'>[삭제]</a><br>");
			}
			out.println("</body></html>");
			
		}catch(Exception e) {
			throw new ServletException(); // 강제로 ServletException 객체 생성하여 던지기
		}finally { //객체 생성의 역순으로 닫기
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(stmt != null) stmt.close();}catch(Exception e) {}
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}


}
