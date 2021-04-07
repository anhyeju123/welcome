package overview_01;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class newlecture01 extends HttpServlet {
	
	//HttpServletRequest입력도구  HttpServletResponse출력도구
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{
		//OutputStream os = response.getOutputStream(); //문자를 출력할수 있도록
		//PrintStream out = new PrintStream(os, true); // 기다리지말고 출력해라(플러쉬) true=바로보내라
		
		PrintWriter out = response.getWriter(); //위의 두문장을 이렇게 씀
 		out.println("hello servlet"); //system이 아니라 원격에있는 사용자에게 전송해서 문서로 볼수있음
 		
	}

}
