<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id"); 
		String pwd = request.getParameter("pwd"); 
		String pwd2 = request.getParameter("pwd2"); 
		String nick = request.getParameter("nick"); 
	%>
	
	아이디 : <%= id %>
	<br>
	비밀번호 : <%= pwd %>
	<br>
	비밀번호2 : <%= pwd2 %>
	<br>
	닉네임 : <%= nick %>

	<script>
		alert('<%= nick %> ㅎㅇ');
	</script>
	
</body>
</html>