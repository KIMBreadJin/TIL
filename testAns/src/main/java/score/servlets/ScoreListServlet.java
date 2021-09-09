package score.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.dto.Score;

@SuppressWarnings("serial")
@WebServlet("/score/list")
public class ScoreListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		 
			conn = DriverManager.getConnection("JDBC:mysql://localhost:3306/servlet","root","3159");  
			System.out.println(conn);
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("select * from score_tbl"); 
			response.setContentType("text/html; charset=utf-8");
			RequestDispatcher rd = request.getRequestDispatcher("/score/ScoreList.jsp");
			List<Score> Scores = new ArrayList<>();
			while(rs.next()) {
				Scores.add(new Score()
						.setTno(rs.getInt("tno"))
						.setTname(rs.getString("tname"))
						.setKor(rs.getInt("kor"))
						.setEng(rs.getInt("eng"))					
						.setMath(rs.getInt("math"))
						.setTavg(rs.getFloat("tavg"))
						.setTotal(rs.getInt("total"))
						.setGrade(rs.getString("grade"))
						);
			}
			request.setAttribute("key", Scores);	
			rd.forward(request,response);	
		}catch(Exception e) {
			throw new ServletException(); 
		}finally { 
			try {if(rs != null) rs.close();}catch(Exception e) {}
			try {if(stmt != null) stmt.close();}catch(Exception e) {}
			try {if(conn != null) conn.close();}catch(Exception e) {}
		}
	}

	}
