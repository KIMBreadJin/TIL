package green.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
	FilterConfig config;
	public void destroy() { // 서블릿 통과후 소멸될때 호출되는 메서드	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException { //서블릿 통과전 초기화 생성시 호출되는 메서드
		this.config=config;
	}

}
