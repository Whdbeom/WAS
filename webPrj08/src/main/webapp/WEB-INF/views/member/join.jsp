<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입ㅋㅋ</h1>
	<% request.setCharacterEncoding("UTF-8"); %>
	<form action="/app08/member/join/processor" method="post">
		<label>아이디 : </label>
		<input type="text" name="id">
		<br>
		<label>비밀번호 : </label>
		<input type="password" name="pwd">
		<br>
		<label>비밀번호2 : </label>
		<input type="password" name="pwd2">
		<br>
		<label>닉네임 : </label>
		<input type="text" name="nick">
		<br>
		<input type="submit" value="회원가입">
		
	</form>
	
</body>
</html>