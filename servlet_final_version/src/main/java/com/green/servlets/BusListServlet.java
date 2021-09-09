package com.green.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BusDao;

@SuppressWarnings("serial")
@WebServlet("/bus/list")
public class BusListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();	
			BusDao busDao = (BusDao) sc.getAttribute("busDao");			
			request.setAttribute("buses", busDao.selectList()); 
			response.setContentType("text/html; charset=utf-8");		
			RequestDispatcher rd = request.getRequestDispatcher("/bus/buslist.jsp");
			rd.include(request, response);
		}catch(Exception e) {
			throw new ServletException();
		}
	}
}


