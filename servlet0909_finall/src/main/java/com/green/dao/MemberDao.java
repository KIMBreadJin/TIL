package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.dto.Member;
import com.green.util.DBConnectionPool;

public class MemberDao {
	DBConnectionPool connPool;
	public void setConnPool(DBConnectionPool connPool) { //setter
		System.out.println("Dao에서의 connPool 객체: " +connPool);
		this.connPool=connPool;
	}
	public List<Member> selectList() throws Exception{ //MemberListServlet에서의 DATABASE관련 코드 이동 
		Connection connection = null;
		Statement stmt =null;
		ResultSet rs = null;
		try {
			connection = connPool.getConnection();
			stmt= connection.createStatement();
			rs =stmt.executeQuery(
					"select mno, mname, email, cre_date from members"
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
		} catch(Exception e ) {
			throw e;
		} finally {
			try { if(rs!=null) rs.close(); } catch(Exception e) {}
			try { if(stmt!=null) stmt.close(); } catch(Exception e) {}
			if(connection !=null) connPool.returnConnection(connection); //사용후 반납  
		}
	}
	public int insert (Member member) throws Exception{
		System.out.println("12)  member dao insert  member : " +member);
		Connection connection=null;
		PreparedStatement pstmt = null;
		try {
			connection = connPool.getConnection();
			pstmt= connection.prepareStatement(
					"insert into members(email, pwd, mname, cre_date,mod_date) values(?,?,?,now(),now())");// Statement 를 생성하겠다 
			pstmt.setString(1, member.getEmail() );
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			return pstmt.executeUpdate();// prepare(준비하고) ? 를 채우고 이때  실행함 
			
		}catch(Exception e) {
			throw e;//강제로 ServletException 객체 생성하여 던지기 
		} finally {// 객체 생성의 역순으로 닫기 
			try { if(pstmt !=null) pstmt.close();} catch(Exception e ) {}
			if(connection !=null) connPool.returnConnection(connection); //사용후 반납  
		}
	}
	public Member selectOne(int no) throws Exception{ // update 서블릿의 doGet으로부터 가져온 코드 
		Connection connection = null;
		Statement stmt =null;
		ResultSet rs =null;
		try {
			connection = connPool.getConnection();
			stmt= connection.createStatement(); 
			Member member =null;
			rs =stmt.executeQuery("select * from members  " + 
					 " where mno = " +no);
			if (rs.next()) {
				member = new Member()
							.setNo(rs.getInt("MNO"))
							.setName(rs.getString("MNAME"))
							.setEmail(rs.getString("EMAIL"))
							.setCreatedDate(rs.getDate("CRE_DATE"))
							.setPassword(rs.getString("PWD"));
			}
			return member;
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			if(connection !=null) connPool.returnConnection(connection); //사용후 반납		
		}
	}
	public int update(Member member) throws Exception {
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {
			conn= connPool.getConnection();
			pstmt = conn.prepareStatement("update members set email =? ,mname=?, mod_date=now() " +
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
			if(conn !=null) connPool.returnConnection(conn); //사용후 반납	
		}
	}
	public Member exist(String email, String password) throws Exception{
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			conn= connPool.getConnection();
			pstmt=conn.prepareStatement("select email,mname from members  " + 
					 " where email = ? and pwd=? "); 
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return  new Member()
						.setEmail(rs.getString("email"))
						.setName(rs.getString("mname"));
			} else { //로그인 실패시 
				return null;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(pstmt!=null) pstmt.close();} catch(Exception e) {}
			if(conn !=null) connPool.returnConnection(conn); //사용후 반납	
		}
	}
	public int delete (int no) throws Exception{
		Connection conn=null;
		Statement stmt = null;
		try {
			conn= connPool.getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate("delete from members where mno =" + no);
		} catch(Exception e) {
			throw e;
		}finally {
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			if(conn !=null) connPool.returnConnection(conn); //사용후 반납	
		}
	}
} 