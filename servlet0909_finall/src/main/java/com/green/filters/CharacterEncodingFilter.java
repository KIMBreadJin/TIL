package com.green.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/CharacterEncodingFilter") //CharacterEncodingFilter web.xml 필터 이름 찾기 
public class CharacterEncodingFilter implements Filter {
	FilterConfig config;//멤버변
	//여러가지 특히 암호화되있는 것을 암호 해제하고서블릿(컨트롤러) 에 보내고  데이터 베이스에서  CRUD를 하고 
	//클라이언트(브라우저)에게 암호를 해야된다(destroy)  여기에 코드 삽입  
	public void destroy() { //서블릿 통과 후 소멸될때 호출되는 메서드 
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		chain.doFilter(request, response);
	}


	public void init(FilterConfig config) throws ServletException {//서블릿 통과전 초기화 생성시 호출되는 메서드
		System.out.println("필터 init 호출 ");
		this.config= config;
	}

}
