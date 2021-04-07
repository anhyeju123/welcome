package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	//입력값을 저장하고 꺼내는방법
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext(); //저장소 (처음입력했던값을 저장후에 나중에 꺼내기위함)
		HttpSession session = request.getSession(); //저장소 차이:현재접속한 사용자만(브라우저가 다르면 달리인식)사용가능 
													//사용자마다 공간 부여, 같은 브라우저를 여러개 띄운것은 같은사용자임
		//사용자가 쿠키를 보내면 읽어서 다음요청때 보냄
		Cookie[] cookies = request.getCookies(); 
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		 
		//전달받음
		String v_ = request.getParameter("v"); //입력값전달
		String op = request.getParameter("operator"); //+,-,= 전달
		
		int v = 0;
	
		//빈문자열 처리
		if(!v_.equals("")) 
			v = Integer.parseInt(v_); //빈문자열이 아니면 v에 입력된값형변환후 저장
		
		//계산
		if(op.equals("=")) {
			
			//int x = (Integer)application.getAttribute("value");//저장소에 저장한값 가져옴, getAttribute는 오브젝트로 값반환히므로 형변환
			//int x = (Integer)session.getAttribute("value");
			int x = 0;
			
			for(Cookie c : cookies)  //cookies길이만큼 돌면서 변수c에 저장
			if(c.getName().equals("value")) {//value라는 값이 있는지 
				x = Integer.parseInt(c.getValue());
				break; //찾으면 멈춰라
				}
			
			
			int y = v; //지금 사용자가 전달한 value 값
			//String operator = (String)application.getAttribute("op");//왜 스트링?? 저장한 값 꺼냄
			//String operator = (String)session.getAttribute("op");
			
			String operator = "";
			for(Cookie c : cookies)  //cookies길이만큼 돌면서 변수c에 저장
				if(c.getName().equals("op")) {//op라는 값이 있는지 
					operator = c.getValue();
					break; //찾으면 멈춰라
					
					}
			
			int result = 0;
		
			if(operator.equals("+"))
				result = x+y;
			else
			 	result = x-y;
			response.getWriter().printf("result is %d\n", result);
		}	
		
		//값을 저장
		else{
//			application.setAttribute("value", v); //(key, 값)
//			application.setAttribute("op", op);
			
//			session.setAttribute("value", v); //(key, 값)
//			session.setAttribute("op", op);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v)); //정수형 쿠키값은 반드시 문자열로
			Cookie opCookie = new Cookie("op", op); //문자열
			valueCookie.setPath("/calc2"); //어느때에 사용자로부터 전달되어야 하는지 정하는것 (/ :모든페이지 , /notice/ : notice경로가 포함된 모든)
			valueCookie.setMaxAge(24*60*60); //쿠키만료날짜 (초단위)
			opCookie.setPath("/calc2"); //calc2에서만
			
			//쿠키를 클라이언트에 보냄
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			//다른페이지로 전환 이거 안하면 값전달시 백지가 나옴
			response.sendRedirect("calc2.html");
		}
		
	}

}
//세션아이디가 was에 의해서 발급이 되고 발급된 번호는 브라우저가 항상 가지고 다님
//브라우저의 개발자툴에서 네트워크 -> 쿠키에 적혀있는 아이디가 세션아이디

//쿠키가 나한테만 오도록 또는 범주안에 있는 서블릿에게만 url설정
//-> 그래야 비효율적으로 여러가지 값 전달이 되지않고 이름충돌이 안일어남

//application
//사용범위 : 전역
//생명주기 : was가 시작해서 종료할 때 까지
//저장위치 : was서버의 메모리

//session
//사용범위 : 세션범위 특정사용자(브라우저)만 사용하도록
//생명주기 : 세션이 시작해서 종료할 때 까지
//저장위치 : was서버의 메모리

//cookie
//사용범위 : 웹 브라우저별 지정한 패스 범주(url) 공간
//생명주기 : browser에 전달한 시간부터 만료시간 까지(지정가능)
//저장위치 : 웹브라우저의 메모리 또는 파일
//*기간 길게 가지고 싶다면 사용













