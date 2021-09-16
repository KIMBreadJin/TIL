package com.green.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ScoreDao;
import com.green.dto.Score;

@SuppressWarnings("serial")
@WebServlet("/score/add")
public class ScoreAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd =  request.getRequestDispatcher("/score/ScoreForm.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기로 눌렀더니(submit 버튼)  post로 들어오나");
		try {
			ServletContext sc= this.getServletContext();
			Score score = new Score();
				score.setSname(request.getParameter("sname"))
					.setKorea(Integer.parseInt(request.getParameter("korea")))
					.setMath(Integer.parseInt(request.getParameter("math")))
					.setEng(Integer.parseInt(request.getParameter("eng")))
					.setTotal((score.getMath()+score.getKorea()+score.getEng()))
					.setAvg(score.getTotal()/3);
			if(score.getAvg()>=80) {
				score.setIsFail("합격");
			}else score.setIsFail("불합격");
					
					
			ScoreDao scoreDao = (ScoreDao) sc.getAttribute("scoreDao");
			scoreDao.insert(score);
			response.setContentType("text/html; charset=urf-8");
			response.sendRedirect("list");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error",e);
			RequestDispatcher rd= request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
	}
}
