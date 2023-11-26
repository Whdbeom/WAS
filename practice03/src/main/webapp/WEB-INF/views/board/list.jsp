<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<BoardVo> boardVoList = (List<BoardVo>) request.getAttribute("boardVoList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>보드 리스트</h1>
	<table style="border = 1px;">
		<thead>
			<tr>
				<th>번호</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>			
				<th>작성일</th>			
			</tr>
		</thead>
		<tbody>
		<% for(BoardVo vo : boardVoList){ %>
			<tr>
				<td><%= vo.getNo() %></td>	
				<td><%= vo.getCategoryName() %></td>	
				<td><%= vo.getTitle() %></td>	
				<td><%= vo.getWriterNick() %></td>	
				<td><%= vo.getHit() %></td>	
				<td><%= vo.getEnrollDate() %></td>	
			</tr>
		<% } %>			
	
		</tbody>
	</table>
	
	<div class="page-area">
		<a href="">1</a>
		<a href="">2</a>
		<a href="">3</a>
		<a href="">4</a>
		<a href="">5</a>
	</div>	
</body>
</html>