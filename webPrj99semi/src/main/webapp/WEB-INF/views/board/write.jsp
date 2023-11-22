<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/app99/resources/css/board/write.css">
</head>
<body>

	<div id="wrap">
		
		<%@ include file ="/WEB-INF/views/common/header.jsp" %>
		
		<form action="/app99/board/write" method="post">
			<main>
				<h1>게시글 작성</h1>
				<a>카테고리</a>
				<select name="category">
					<option value="1">자유</option>
					<option value="2">게임</option>
					<option value="3">요리</option>
					<option value="4">운동</option>
				</select>
				<a>제목</a>
				<input type="text" name="title" placeholder="제목을 입력하세요">
				<a>내용</a>
				<textarea name="content" placeholder="내용을 입력하세요"></textarea>
				<div></div>
				<div>
					<input type="submit" value="작성하기">
				</div>
			</main>
		</form>
	</div>
</body>
</html>