<%@page import="edu.kh.test.user.model.vo.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% UserDTO userInfo = (UserDTO) request.getAttribute("userInfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보</h1>
	<table border=1>
		<tr>
			<td>회원번호</td>
			<td>회원아이디</td>
			<td>회원이름</td>
			<td>회원나이</td>			
		</tr>
		<tr>
			<td><%= userInfo.getUserNo() %></td>
			<td><%= userInfo.getUserId() %></td>
			<td><%= userInfo.getUserName() %></td>
			<td><%= userInfo.getUserAge() %></td>			
		</tr>
	</table>	
	
	<a href="/Test1">메인페이지로 돌아가기</a>

</body>
</html>