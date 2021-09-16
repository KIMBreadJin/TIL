package com.green.servlets;

import java.io.IOException;
import java.sql.Connection;

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
@WebServlet("/score/update")
public class ScoreUpdateServlet extends HttpServlet {
	Connection conn = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno")); 
		System.out.println("수정 get sno =  " + sno);
		try {
			ServletContext sc = this.getServletContext();
			ScoreDao scoreDao = (ScoreDao) sc.getAttribute("scoreDao");
			request.setAttribute("score", scoreDao.selectOne(sno));
			RequestDispatcher rd = request.getRequestDispatcher("../score/ScoreUpdateForm.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("업데이트");
			response.setContentType("text/html; charset = urf-8");
			ServletContext sc = this.getServletContext();
			ScoreDao scoreDao = (ScoreDao) sc.getAttribute("scoreDao");
			Score score = new Score();
			scoreDao.update(score
						.setSno(Integer.parseInt(request.getParameter("sno")))
						.setSname(request.getParameter("sname"))
						.setKorea(Integer.parseInt(request.getParameter("korea")))
						.setMath(Integer.parseInt(request.getParameter("math")))
						.setEng(Integer.parseInt(request.getParameter("eng")))
						.setTotal(Integer.parseInt(request.getParameter("korea")) + 
								Integer.parseInt(request.getParameter("math")) +
								Integer.parseInt(request.getParameter("eng")))
						.setAvg(score.getTotal() / 3));
								
			if((score.getAvg()) >= 80) {
				scoreDao.update(score.setIsFail("합격"));
			}else scoreDao.update(score.setIsFail("불합격"));
			
			response.sendRedirect("list");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	
	}

}
