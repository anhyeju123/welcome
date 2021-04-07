package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg") //어노테이션 맵핑
public class NoticeReg extends HttpServlet {
	@Override
	//HttpServletRequest입력도구  HttpServletResponse출력도구
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{
		response.setCharacterEncoding("UTF-8");//UTF-8로 인코딩해라
		response.setContentType("text/html; charset=UTF-8");//utf-8로 보낼테니 html/text문서에서 utf-8로 읽어라하고 브라우저에게
		//request.setCharacterEncoding("UTF-8");//입력값을 얻어올때			
		
		//OutputStream os = response.getOutputStream(); //문자를 출력할수 있도록
		//PrintStream out = new PrintStream(os, true); // 기다리지말고 출력해라(플러쉬) true=바로보내라
		PrintWriter out = response.getWriter(); //위의 두문장을 이렇게 씀(출력도구)
		
		//아래는 넘겨받는곳
		String title = request.getParameter("title");//getParameter=키워드(쿼리값)를읽음(무조건문자열로읽음)
		String content = request.getParameter("content");
		
		//잘받았다 이게맞니? 확인하는문구 (출력도구가 있기 때문에 사용가능)
		out.println(title);
		out.println(content);
	}

}

//	http:/.../hello?cnt=3 = 3
//	http:/.../hello?cnt=  = ""
//	http:/.../hello?      = null
//	http:/.../hello       = null