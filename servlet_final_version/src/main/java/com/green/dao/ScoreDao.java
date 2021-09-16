package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.dto.Score;
import com.green.util.DBConnectionPool;

public class ScoreDao {
	DBConnectionPool connPool;
	public void setConnPool(DBConnectionPool connPool) { //setter
		System.out.println("Dao에서의 connPool 객체: " +connPool);
		this.connPool=connPool;
	}
	public List<Score> selectList() throws Exception{ 
		Connection connection = null;
		Statement stmt =null;
		ResultSet rs = null;
		try {
			connection = connPool.getConnection();
			stmt= connection.createStatement();
			rs =stmt.executeQuery(
					"select * from score"
					);
			List<Score> scores = new ArrayList<>();
			while(rs.next()) {
				scores.add(new Score()
						.setSno(rs.getInt("sno"))
						.setSname(rs.getString("sname"))
						.setSpassword(rs.getString("spassword"))
						.setKorea(rs.getInt("korea"))
						.setMath(rs.getInt("math"))
						.setEng(rs.getInt("eng"))
						.setTotal(rs.getInt("total"))
						.setAvg(rs.getFloat("avg"))
						.setIsFail(rs.getString("isFail"))
						);
			}
			return scores;
			
		} catch(Exception e ) {
			throw e;
		} finally {
			try { if(rs!=null) rs.close(); } catch(Exception e) {}
			try { if(stmt!=null) stmt.close(); } catch(Exception e) {}
			if(connection !=null) connPool.returnConnection(connection); //사용후 반납  
		}
	}
	public int insert (Score score) throws Exception{
		Connection connection=null;
		PreparedStatement pstmt = null;
		try {
			connection = connPool.getConnection();
			pstmt= connection.prepareStatement(
					"insert into score(korea, math, eng) values(?,?,?)");// Statement 를 생성하겠다 
			pstmt.setInt(1, score.getKorea() );
			pstmt.setInt(2, score.getMath());
			pstmt.setInt(3, score.getEng());
			return pstmt.executeUpdate();// prepare(준비하고) ? 를 채우고 이때  실행함 
			
		}catch(Exception e) {
			throw e;//강제로 ServletException 객체 생성하여 던지기 
		} finally {// 객체 생성의 역순으로 닫기 
			try { if(pstmt !=null) pstmt.close();} catch(Exception e ) {}
			if(connection !=null) connPool.returnConnection(connection); //사용후 반납  
		}
	}
	public Score selectOne(int sno) throws Exception{ // update 서블릿의 doGet으로부터 가져온 코드 
		Connection connection = null;
		Statement stmt =null;
		ResultSet rs =null;
		try {
			connection = connPool.getConnection();
			stmt= connection.createStatement(); 
			rs =stmt.executeQuery("select sno, korea, math, eng from score  " + 
					 " where sno = " + sno);
			if(rs.next()){
				return new Score().setSno(rs.getInt(sno))
								.setKorea(rs.getInt("korea"))
								.setMath(rs.getInt("math"))
								.setEng(rs.getInt("eng"));
			}else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다");
			}
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			if(connection !=null) connPool.returnConnection(connection); //사용후 반납		
		}
	}
	public int update(Score score) throws Exception {
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {
			conn= connPool.getConnection();
			pstmt = conn.prepareStatement("update score set korea =? ,math =?, eng =? " +
					" where sno  =?"
					);
			pstmt.setInt(1, score.getKorea() );
			pstmt.setInt(2, score.getMath());
			pstmt.setInt(3, score.getEng());
			return pstmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		}finally {
			try {if(pstmt!=null) pstmt.close();} catch(Exception e) {}
			if(conn !=null) connPool.returnConnection(conn); //사용후 반납	
		}
	}
	public int delete (int sno) throws Exception{
		Connection conn=null;
		Statement stmt = null;
		try {
			conn= connPool.getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate("delete from score where sno =" + sno);
		} catch(Exception e) {
			throw e;
		}finally {
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			if(conn !=null) connPool.returnConnection(conn); //사용후 반납	
		}
	}
} 
