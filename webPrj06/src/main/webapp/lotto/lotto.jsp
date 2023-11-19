<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String num1 = request.getParameter("a");
    	String num2 = request.getParameter("b");
    	
    	int a = Integer.parseInt(num1);
    	int b = Integer.parseInt(num2);
    	
    	int result = (int)(Math.random() * (b-a+1) + a);
    			
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>
		<%=a %> ~ <%=b %> 사이의 랜덤 숫자 : <%= result %>
	</h1>
</body>
</html>