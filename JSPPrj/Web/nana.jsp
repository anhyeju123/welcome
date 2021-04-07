<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//위에서 인코딩했기때문에 따로 인코딩 필요없음.
//출력하는 out코드는 내장객체가 이미 가지고있기 때문에 따로 안써도됨

String cnt_ = request.getParameter("cnt");//getParameter=키워드(쿼리값)를읽음(무조건문자열로읽음)

//아래는 http://.../hello?cut=3 에서 cut요청을 처리하기위함
int cnt = 100; //기본값
if(cnt_ != null && !cnt_.equals("")) //cnt_가 null이 아니고 빈문자열이 아니면
	cnt = Integer.parseInt(cnt_); //정수로 쓰고싶으므로 정수형으로 형변환후 cnt에 저장
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% for(int i=0; i<cnt; i++){ %>
	안녕 servlet<br >
	<% } %>
</body>
</html>