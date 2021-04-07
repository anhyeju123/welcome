package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi") //어노테이션 
public class Nana extends HttpServlet {
	@Override
	//HttpServletRequest입력도구  HttpServletResponse출력도구
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{
		response.setCharacterEncoding("UTF-8");//UTF-8로 인코딩해라
		response.setContentType("text/html; charset=UTF-8");//utf-8로 보낼테니 html/text문서에서 utf-8로 읽어라하고 브라우저에게
		
		//OutputStream os = response.getOutputStream(); //문자를 출력할수 있도록
		//PrintStream out = new PrintStream(os, true); // 기다리지말고 출력해라(플러쉬) true=바로보내라
		PrintWriter out = response.getWriter(); //위의 두문장을 이렇게 씀
		
		String cnt_ = request.getParameter("cnt");//getParameter=키워드(쿼리값)를읽음(무조건문자열로읽음)
		
		//아래는 http://.../hello?cut=3 에서 cut요청을 처리하기위함
		int cnt = 100; //기본값
		if(cnt_ != null && !cnt_.equals("")) //cnt_가 null이 아니고 빈문자열이 아니면
			cnt = Integer.parseInt(cnt_); //정수로 쓰고싶으므로 정수형으로 형변환후 cnt에 저장
		
		
		for(int i=0; i<cnt; i++)
 		out.println((i+1)+": 안녕 servlet<br >"); //system이 아니라 원격에있는 사용자에게 전송해서 문서로 볼수있음
 		
	}

}

//	http:/.../hello?cnt=3 = 3
//	http:/.../hello?cnt=  = ""
//	http:/.../hello?      = null
//	http:/.../hello       = null