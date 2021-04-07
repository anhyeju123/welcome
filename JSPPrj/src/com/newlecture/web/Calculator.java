package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/calculator")
public class Calculator extends HttpServlet{
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		if(req.getMethod().equals("GET")){ //get인지post인지 비교 (반드시대문자)
//			System.out.println("GET 요청이왔습니다");
//		}	
//		else if(req.getMethod().equals("POST")){
//			System.out.println("POST 요청이왔습니다");
//		}
//		super.service(req, resp); //부모가 갖고있는 서비스 호출 -> get이면 doget호출 post면 dopost호출 (메소드가 있어야함)
//	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String exp = "0"; //아무런 쿠키가 없을때 기본값
		Cookie[] cookies = request.getCookies(); 
		if(cookies != null) //쿠키배열이 null인경우가 있을수도 있어서(하나도 없을때)
		for(Cookie c : cookies)  //cookies길이만큼 돌면서 변수c에 저장
			if(c.getName().equals("exp")) {//op라는 값이 있는지 
				exp = c.getValue();
				break; //찾으면 멈춰라
				}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		 
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("input{");
		out.write("width:50px;");
		out.write("height:50px;");
		out.write("}");
		out.write(".output{");
		out.write("height:50px;");
		out.write("background:#e9e9e9;");
		out.write("font-size:24px;");
		out.write("font-weight:bold;");
		out.write("text-align:right;");
		out.write("padding:0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("	<body>");
		out.write("	<div>");
		out.write("		<form method=\"post\">");
		out.write("			<table>");
		out.write("				<tr>");
		out.printf("					<td class=\"output\" colspan = \"4\">%s</td>", exp); //문자열 %s
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"CE\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"C\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"BS\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"/\" /></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"7\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"8\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"9\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"*\" /></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"4\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"5\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"6\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"-\" /></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"1\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"2\" /></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"3\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"+\" /></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"0\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"dot\" value=\".\" /></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"=\" /></td>");
		out.write("				</tr>");
		out.write("			</table>");
		out.write("		</form>");
		out.write("	</div>");

		out.write("</body>");
		out.write("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		expCookie.setPath("/calculator");
		response.addCookie(expCookie);
		//다른페이지로 전환 이거 안하면 값전달시 백지가 나옴
		response.sendRedirect("calculator"); //자기자신호출 Redirect는 get요청임
		}
	}
	
	
