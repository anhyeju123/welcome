package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") //모든url에 대해서 어노테이션
public class CharacterEncodingFilter implements Filter {
//클래스 생성전 add해서 서블릿필터 추가
	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, 
			FilterChain chain) //FilterChain 다음으로 넘길지 말지 결정하는것
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8"); //필터 실행전 실행 (인코딩)
		
		chain.doFilter(request, response); //다음필터, 다음서블릿를 실행되게끔함
		
		//System.out.println("after filter"); //response에 의해 결과가 오면 실행
	}

}
