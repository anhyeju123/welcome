package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add2")
public class add2 extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//값 전달받아 num_에 저장
		String[] num_ = request.getParameterValues("num"); //여러개가 하나의 이름으로 올때 values
		
		int result = 0; //result 기본값
		
		for(int i=0; i<num_.length; i++) { //num_길이(4)까지 증가
			int num = Integer.parseInt(num_[i]); 
//			num = num_[0]
//			num = num_[1]
//			num = num_[2]		
//			num = num_[3]
			result+=num; 
//			result = num_[0]+num_[1]+num_[2]+num_[3]
		}
		
		response.getWriter().printf("result is %d\n", result);
	}

}
