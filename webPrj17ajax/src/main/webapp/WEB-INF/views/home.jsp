<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이ㅣㅈ</h1>

	<button onclick="f01();">ajax 방식으로 요청 보내기</button>
	
	<script>
	
		function handleResult( x ){
			console.log(x.text());
		}
	
		function f01(){
			
			// 서버한테 요청 보내기
			fetch("http://localhost:8888/app17/test")
			.then( (resp) => { return resp.json() } ) //데이터를 가공
			.then( (x) => { 
					console.log(x);
					console.log(x.title);
					console.log(x.content);
			} );		 // 가공된 데이터로 하고싶은짓
		}
		
	</script>
	
</body>
</html>