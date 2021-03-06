package com.green.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dto.Green;


@SuppressWarnings("serial")
@WebServlet("/el/search")
public class SearchServlet extends HttpServlet {
	Map<String, Green> map = new HashMap<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("search 서블릿" + request.getParameter("name"));
		Green gr = new Green();
		for(int i=0; i<10; i++) {
			gr.setDriver(i+4);
			gr.setTire(i+3);
			gr.setWindow(i+2);
			gr.setName("박"+i);
			map.put("홀"+i, gr);	
		}
		System.out.println("Map에서 겁색된 결과는" + map.get(request.getParameter("name")));
		RequestDispatcher rd = request.getRequestDispatcher("a.jsp");
		request.setAttribute("tt",map.get("a0"));
		rd.forward(request, response);
	}

}
