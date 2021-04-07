package com.newlecture.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//post 방식

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	//입력값을 저장하고 꺼내는방법
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사용자가 쿠키를 보내면 읽어서 다음요청때 보냄
		Cookie[] cookies = request.getCookies(); 
		
		
		//전달받음
		String value = request.getParameter("value"); //숫자전달
		String operator = request.getParameter("operator"); //+,-,= 전달
		String dot = request.getParameter("dot");
		
		//쿠키읽어옴
		String exp = "";//exp를 만듬 읽어온것이 없을때 기본값
			if(cookies != null) //쿠키배열이 null인경우가 있을수도 있어서(하나도 없을때)
				for(Cookie c : cookies)  //cookies길이만큼 돌면서 변수c에 저장
					if(c.getName().equals("exp")) {//op라는 값이 있는지 
						exp = c.getValue();
						break; //찾으면 멈춰라
					}
		
		//연산
		if(operator != null && operator.equals("=")){ //널이아니면서 값이 = 이면 
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");///스크립트실행하는 구문(엔진이름)
			try {
				exp = String.valueOf(engine.eval(exp)); //엔진은 오브젝트 반환이고 exp는 문자열이므로, 계산결과 exp에 저장
			} catch (ScriptException e) {
				
				e.printStackTrace();
			}
		}
		//쿠키내용삭제
		else if(operator != null && operator.equals("C")){ //c 라면
			exp = "";
		}
		else {
		//읽어온값에 덧붙임
		exp += (value == null)?"":value; //null이면 ""붙이고 
		exp += (operator == null)?"":operator;
		exp += (dot == null)?"":dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp); //쿠키생성
		if(operator != null && operator.equals("C")) //이조건이오면 쿠키소멸
		expCookie.setMaxAge(0); //소멸
		response.addCookie(expCookie);
		//다른페이지로 전환 이거 안하면 값전달시 백지가 나옴
		response.sendRedirect("calcpage"); //경로가 같으므로 / 필요없음
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













