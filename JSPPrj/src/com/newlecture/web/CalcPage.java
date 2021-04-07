package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//get방식

@WebServlet("/calcpage")
public class CalcPage extends HttpServlet {
	//입력값을 저장하고 꺼내는방법
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		out.write("		<form action=\"calc3\" method=\"post\">");
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
}












