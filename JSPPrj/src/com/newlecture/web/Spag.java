package com.newlecture.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
    	String num_ = request.getParameter("n");
    	if(num_ != null && !num_.equals(""))
    		num = Integer.parseInt(num_);
    	
    	String result;
    	
    	if(num%2 != 0)
    	 result = "홀수";
    	else
    	 result = "짝수";
    	
    	request.setAttribute("request", result); //값을 담음
    	
    	//result를 jsp로 전달하기 위한 연결고리 저장소(request사용) 
    	//1. forward : 현재작업을 계속 이어갈수있도록 공유
    	//2. redirect : 작업과 상관없이 새로운요청
    	RequestDispatcher dispatcher 
    				= request.getRequestDispatcher("spag.jsp"); //spage.jsp는 서블릿임
    	dispatcher.forward(request, response); //현재작업했던내용을 req,resp에담고 jsp에 전달
    	
}
}

//실행은 여기서