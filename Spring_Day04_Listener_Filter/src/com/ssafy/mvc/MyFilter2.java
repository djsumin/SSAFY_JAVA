package com.ssafy.mvc;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class MyFilter2 implements Filter {

	public FilterConfig filterConfig;

	public MyFilter2() {
	}

	// 필터 초기화
	public void init(FilterConfig fConfig) throws ServletException {
	}

	// 필터 종료
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 이거 위에 코드를 작성하면
		System.out.println("서블릿 동작 이전에 할 것2");
		String encoding = this.filterConfig.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response); // 다음 필터로 전달, 서블릿 호출(꼭 필요한 파트)!!
		// 이 아래로 코드를 작성하면
		System.out.println("서블릿 동작 이후에 할 것2");
	}

}
