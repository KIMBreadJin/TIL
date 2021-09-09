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
		// TODO Auto-generated method stub
		System.out.println("여기 get 방식이 들어오는구나 ");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; //데이터베이스 조회 결과가 저장됨 
		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 등록
			//DriverManager 스태택 메서드인 getConnection을 호출하면 Connection(연결)  객체 반환 
			// 첫번째 파라미터는 url (database포함) , 두번째 계정 ,세번째 비밀번호 
			conn = DriverManager.getConnection("JDBC:mysql://localhost:3306/servlet","root","1234");
			System.out.println(conn);
			stmt= conn.createStatement();// Statement 를 생성하겠다 
			rs= stmt.executeQuery("select MNO,MNAME,EMAIL,CRE_DATE from members");//문자열롤 sql 쿼리 실행 
			//조회된 데이터가 ResultSet에 저장됨 
			response.setContentType("text/html; charset=utf-8");
			ArrayList<Member> members = new ArrayList<>();
			while(rs.next()) {//데이터베이스로 부터 가져온 데이터를 List에 저장하고 
				members.add(new Member()
						.setNo(rs.getInt("mno"))
						.setName(rs.getString("mname"))
						.setEmail(rs.getString("email"))
						.setCreatedDate(rs.getDate("cre_date"))
						);
			}
			// request에 회원 목록 데이터 보관함 
			request.setAttribute("members", members); //저장된 List의 members를 화면 출력(view)를 
			//담당하는 jsp로 이동시킴 
			//jsp로 출력을 위임함
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
	
	//jsp(view) 로 변경하니까 지금은 코드가 거지 같아도 우선 참으세요
	//refactoring 나가는 것을 경험하는 겁니다. 
	//M(Model/테이블객체/VO/Value Object ) V(view/jsp) C(controller/서블릿)  2  패턴을 적용합니다. 


	
}
