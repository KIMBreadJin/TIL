package green.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.dto.Member;


@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기 get 방식이 들어오는구나 ");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn = DriverManager.getConnection("JDBC:mysql://localhost:3306/servlet","root","3159");
			System.out.println(conn);
			stmt= conn.createStatement();
			rs= stmt.executeQuery("select MNO,MNAME,EMAIL,CRE_DATE from members");
			response.setContentType("text/html; charset=utf-8");
			
			ArrayList<Member> members = new ArrayList<>();
			while(rs.next()) {
				members.add(new Member()
						.setNo(rs.getInt("mno"))
						.setName(rs.getString("mname"))
						.setEmail(rs.getString("email"))
						.setCreatedDate(rs.getDate("cre_date"))
						);
			}
			
			request.setAttribute("members", members); //저장된 List의 members를 화면 출력(view)를 
		
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberList.jsp");
			rd.include(request, response);// 여기로 돌아오다 
		}catch(Exception e) {
			throw new ServletException();//강제로 ServletException 객체 생성하여 던지기 
		} finally {// 객체 생성의 역순으로 닫기 
			try { if(rs !=null) rs.close();} catch(Exception e ) {}
			try { if(stmt !=null) stmt.close();} catch(Exception e ) {}
			try { if(conn !=null) conn.close();} catch(Exception e ) {}
		}
	}
	


	
}
