package com.green.listeners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.green.dao.MemberDao;
import com.green.util.DBConnectionPool;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	DBConnectionPool connPool;
    public void contextDestroyed(ServletContextEvent arg0)  { 
         connPool.closeAll(); //프로그램 종료시 모든 Connection 객체 종료  
    }
    public void contextInitialized(ServletContextEvent event)  { 
    	System.out.println("프로그램 실행시 처음으로 호출되는 메서드 ");
		 try {
			 ServletContext sc = event.getServletContext();
			 connPool =new DBConnectionPool(
					 sc.getInitParameter("driver"),
					 sc.getInitParameter("url"),
					 sc.getInitParameter("username"),
					 sc.getInitParameter("password")
					 );
			 MemberDao memberDao = new MemberDao();
			 memberDao.setConnPool(connPool); //MemberDao 객체에  connPool 주입(injection) 
			 sc.setAttribute("memberDao", memberDao);
		 } catch(Exception e) {
        	 e.printStackTrace();
         }
    }
	
}