package com.green.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ScoreDao;

@SuppressWarnings("serial")
@WebServlet("/score/list")
public class ScoreListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기 get 방식이 들어오는구나 ");

		try {
			ServletContext sc = this.getServletContext();	
			ScoreDao scoreDao = (ScoreDao) sc.getAttribute("scoreDao");			
			request.setAttribute("scores", scoreDao.selectList()); 
			response.setContentType("text/html; charset=utf-8");		
			RequestDispatcher rd = request.getRequestDispatcher("/score/ScoreList.jsp");
			rd.include(request, response);
		}catch(Exception e) {
			throw new ServletException();
		} 
	}
}
