package green.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.dto.Member;


@SuppressWarnings("serial")
@WebServlet("el/hello")
public class Elsevrlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("el/list2.jsp");
		List<Member> list =new ArrayList<>();
		Member a = new Member().setNo(100).setName("홍길동").setEmail("hong@test.com");
		Member b = new Member().setNo(1200).setName("길동").setEmail("mal@test.com");
		Member c = new Member().setNo(300).setName("홍동").setEmail("kim@test.com");
		Member d = new Member().setNo(400).setName("홍길").setEmail("pack@test.com");
		Member e = new Member().setNo(500).setName("홍말자").setEmail("g@test.com");
		list.add(a); list.add(b);list.add(c);list.add(d);list.add(e);
		request.setAttribute("pp",list);
		request.setAttribute("b","홍말자");
		rd.forward(request, response);
		}


}
