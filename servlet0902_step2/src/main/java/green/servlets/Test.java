package green.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.dto.Member;


@SuppressWarnings("serial")
@WebServlet("/test/a")
public class Test extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("a.jsp");
		List<Member> ms = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Member m = new Member();
			m
				.setCreatedDate(new Date())
				.setEmail("a@naver.com"+ i)
				.setName("그린"+i)
				.setNo((i+1)*20)
				.setPassword("1234"+i+100);
			ms.add(m);
		}
		request.setAttribute("d", ms);
		rd.forward(request, response);
	}

}
