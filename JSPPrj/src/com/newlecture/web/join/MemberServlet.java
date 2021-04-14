package com.corin.dogHotel.join;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServlet extends HttpServlet{
	private static long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp); 
		//doPost호출
		//form 문이 여러개 올수 있다고 하면
		//비즈니스 로직은 똑같은데 get이 올지 post이 올지 모르므로
	}
	
	//forward 메소드: 현재작업을 계속 이어갈수있도록 공유
	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(url);
		
		rd.forward(req, resp);
		
	}
}


//result를 jsp로 전달하기 위한 연결고리 저장소(request사용) 
//1. forward : 현재작업을 계속 이어갈수있도록 공유
//2. redirect : 작업과 상관없이 새로운요청