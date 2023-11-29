<%@page import="com.kh.app.page.vo.PageVo"%>
<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% List<BoardVo> boardVoList = (List<BoardVo>) request.getAttribute("boardVoList"); %>
  	<% PageVo pvo = (PageVo)request.getAttribute("pvo"); %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/app99/resources/css/board/list.css">

</head>
<body>

	<div id="wrap">
			
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<h1>게시글 목록</h1>
			<table border="1">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>작성일시</th>
							<th>카테고리<th>
						</tr>
					</thead>
					<tbody>
			<% for(BoardVo vo : boardVoList){ %>
						<tr class="zzzz">
							<td><%= vo.getNo() %></td>
							<td><%= vo.getTitle() %></td>
							<td><%= vo.getWriterNick() %></td>
							<td><%= vo.getHit() %></td>
							<td><%= vo.getEnrollDate() %></td>
							<td><%= vo.getCategoryName() %></td>						
						</tr>
			<% } %>
					</tbody>
				</table>
			<% if(loginMember != null){ %>
				<button onclick="location.href='/app99/board/write'">작성하기</button>
			<% } %>
			
			<div class="page-area">
				<% if(pvo.getStartPage() != 1){ %>
			 		<a href="/app99/board/list?pno=<%= pvo.getStartPage()-1 %>">이전</a>				
				<% } %>
				<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++ ){ %>
					<% if(i == pvo.getCurrentPage()){ %>
						<span><%= i %></span>
					<% } else { %>
						<a href="/app99/board/list?pno=<%= i %>"><%= i %></a>
					<% } %>				
				<% } %>
				<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
			 		<a href="/app99/board/list?pno=<%= pvo.getEndPage()+1 %>">다음</a>					
				<% } %>
			</div>	
		</main>
		
	</div>
	
</body>
</html>

<script>
	const trArr = document.querySelectorAll("main > table > tbody > tr");
	for(let i = 0; i < trArr.length; i++){
		trArr[i].addEventListener('click', handleClick);
	}

	function handleClick(event){
		const tr = event.currentTarget;
		const no = tr.children[0].innerText
		location.href = '/app99/board/detail?no=' + no + '&currPage=<%= pvo.getCurrentPage() %>';
	}
</script>