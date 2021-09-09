package com.green.listeners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
         //프로그램 종료시 호출되는 메서드
    }

    public void contextInitialized(ServletContextEvent event)  {
    	System.out.println("프러그램 실행시 처음으로 호출되는 메서드");
    	Connection conn = null;
         try {
        	 ServletContext sc = event.getServletContext();
        	 Class.forName(sc.getInitParameter("driver"));
        	 conn = DriverManager.getConnection(
        			 sc.getInitParameter("url"),
        			 sc.getInitParameter("username"),
        			 sc.getInitParameter("password")
        			 );
         }catch(Exception e) {
        	 
         }
    }
	
}
