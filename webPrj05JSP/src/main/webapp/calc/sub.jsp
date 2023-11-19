<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

 	String n1 = request.getParameter("n1");
 	String n2 = request.getParameter("n2");
 	
 	int num1 = Integer.parseInt(n1);
 	int num2 = Integer.parseInt(n2);
 	
 	int result = num1 - num2;
 	
 
%>

<%-- JSP 주석ㅋㅋ --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>
			<% out.print(result); %>
			<%= result %>
		</h1>
</body>
</html>