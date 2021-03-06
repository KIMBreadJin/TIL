package com.green.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.green.dto.Member;

public class MemberDao {
	Connection connection; //멤버면수
	//DataSource ds;
	public void setConnection(Connection connection) { //setter
		this.connection=connection;
}
	public List<Member> selectList() throws Exception { //MemberListServlet에서의 DATABASE관련 코드 이동
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt= this.connection.createStatement();
			rs =stmt.executeQuery(
					"select mno ,mname, email, cre_date from members"
					);
			List<Member> members = new ArrayList<>();
			while(rs.next()) {
				members.add(new Member()
						.setNo(rs.getInt("mno"))
						.setName(rs.getString("mname"))
						.setEmail(rs.getString("email"))
						.setCreatedDate(rs.getDate("cre_date"))
						);
			}
			return members;
			
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs!=null) rs.close();} catch(Exception e) {}
			try { if(stmt!=null) stmt.close();} catch(Exception e) {}
			try { if(connection!=null) connection.close();} catch(Exception e) {}
		}
	}
	public int insert (Member member) throws Exception{
		//Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			System.out.println(this.connection);
			pstmt= this.connection.prepareStatement(
					"insert into members(email, pwd, mname, cre_date,mod_date) values(?,?,?,now(),now())");// Statement 를 생성하겠다 
			pstmt.setString(1, member.getEmail() );
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			return pstmt.executeUpdate();// prepare(준비하고) ? 를 채우고 이때  실행함 
			
		}catch(Exception e) {
			throw e;//강제로 ServletException 객체 생성하여 던지기 
		} finally {// 객체 생성의 역순으로 닫기 
			try { if(pstmt !=null) pstmt.close();} catch(Exception e ) {}
			try { if(connection !=null) connection.close();} catch(Exception e ) {}
		}
	}
	public Member selectOne(int no) throws Exception{ // update 서블릿의 doGet으로부터 가져온 코드
//		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			System.out.println(this.connection);//Connection 객체의 주소가 잘 떠야 합니다. 
			stmt= this.connection.createStatement(); 
			rs =stmt.executeQuery("select mno,email,mname, cre_date from members  " + 
					 " where mno = " +no);
			if(rs.next()){
				return new Member().setNo(rs.getInt(no))
								.setEmail(rs.getString("email"))
								.setName(rs.getString("mname"))
								.setCreatedDate(rs.getDate("cre_date"));
			}else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다");
			}
			
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(stmt!=null) rs.close();} catch(Exception e) {}
			try {if(this.connection!=null) rs.close();} catch(Exception e) {}
			
		}
	}
	public int update(Member member) throws Exception{
		PreparedStatement pstmt = null;
		try {
			System.out.println(this.connection);//Connection 객체의 주소가 잘 떠야 합니다. 
			pstmt = this.connection.prepareStatement("update members set email =? ,mname=?, mod_date=now() " +
					" where mno  =?"
					);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getName());
			pstmt.setInt(3, member.getNo());
			return pstmt.executeUpdate();
		} catch(Exception e) {
			throw e;
			
		}finally {
			try {if(pstmt!=null) pstmt.close();} catch(Exception e) {}
			try {if(this.connection!=null) this.connection.close();} catch(Exception e) {}
		}
	}
	public Member exist(String email, String password) throws Exception{
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			System.out.println(this.connection);//Connection 객체의 주소가 잘 떠야 합니다. 
			pstmt= this.connection.prepareStatement("select email,mname from members  " + 
					 " where email = ? and pwd = ? ");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return new Member()
						.setEmail(rs.getString("email"))
						.setName(rs.getString("mname"));
			} else {
				return null;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(pstmt!=null) pstmt.close();} catch(Exception e) {}
			try {if(this.connection!=null) this.connection.close();} catch(Exception e) {}
			
		}
	}
	public int delete (int no) throws Exception{
		Statement stmt = null;
		try {
			stmt = this.connection.createStatement();
			return stmt.executeUpdate("delete from members where mno =" +no);
		} catch(Exception e) {
			throw e;
		}finally {
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			try {if(this.connection !=null) this.connection.close();} catch(Exception e) {}
		}
	}
}

