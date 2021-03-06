package com.green.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dto.Green;

@SuppressWarnings("serial")
@WebServlet("/migum")
public class MigumServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/el/migumform.jsp");
//		Green a= new Green();
//		a.setDriver(13);
//		a.setName("홍길동");
//		a.setWindow(12);
//		a.setTire(20);
//		request.setAttribute("u", a);
		rd.forward(request, response);
	}

}
