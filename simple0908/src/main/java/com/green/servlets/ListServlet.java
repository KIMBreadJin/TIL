package com.green.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dto.Green;

@SuppressWarnings("serial")
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	List<Green> list = new ArrayList<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Green g = new Green();
		String name = request.getParameter("name"); 
		String window = request.getParameter("window"); 
		String tire = request.getParameter("tire"); 
		String driver = request.getParameter("driver");
		
			g.setDriver(Integer.parseInt(driver));
			g.setName(name);
			g.setTire(Integer.parseInt(tire));
			g.setWindow(Integer.parseInt(window));
			list.add(g);
			list.forEach(i->{
			System.out.println("list의 post에서의 " + "타이어 : " + i.getTire() + "이름 : " +  i.getName() + "창문 : " +  i.getWindow() + "운전자 : " +i.getDriver());
		    });
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/el/b.jsp");
	//	System.out.println("list post 값 " + list);
//		System.out.println("list의 post에서의 name:" + name + "창문 : " + window + "운전자 : " +driver+ "타이어 : " + tire);
		request.setAttribute("li", list);
		rd.forward(request, response);
	}

}
