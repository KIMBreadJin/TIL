package green.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.dto.Member;

@SuppressWarnings("serial")
@WebServlet("/el/helllo2")
public class HelloSerlvet extends HttpServlet {
	Map<String, Member> map = new HashMap<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqNo = request.getParameter("no");
		System.out.println("view에서 넘어온 숫자는 " + reqNo);
		for(int i = 0; i<5; i++) {
			map.put(""+(i+1), new Member().setNo(i+3).setName("홍길동" +i+3).setEmail("hong@test.com"+i+3));	
			}
		map.forEach((k,v)->{
			System.out.println("키값 : " + k + "밸류 : " + v);
		});
		RequestDispatcher rd = request.getRequestDispatcher("/el/serch.jsp");
		Member resMember= map.get(reqNo.trim());
		System.out.println(resMember);
		request.setAttribute("s", resMember);
		rd.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
