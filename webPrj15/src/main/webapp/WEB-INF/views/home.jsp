<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈ㅋㅋ</h1>
	
	<h2>파일 업로드</h2>
	
	<form action="/app15/file/insert" method="post" enctype="multipart/form-data"> 
	    파일<input type="file" name="file"><br>
	    <input type="submit" value="파일업로드">
	</form>
</body>
</html>