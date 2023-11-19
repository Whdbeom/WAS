<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	   	String n1 = request.getParameter("n1");
	   	String n2 = request.getParameter("n2");
	   	
	   	int num1 = Integer.parseInt(n1);
	   	int num2 = Integer.parseInt(n2);
	   	
	   	int result = num1 + num2;
	%>
     

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ㅇㅋㅋㅋㅋㅋㅋ
		<h1>
		<% out.print(result); %>
		<% out.write(result); %>
		</h1>
</body>
</html>