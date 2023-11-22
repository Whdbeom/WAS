<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="wrap">
	
		<%@ include file ="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<h1 align="center">회원가입</h1>

			<form action="/app99/member/join" method="post" onsubmit="return checkValidate();">
				<table>
					<tbody>
						<tr>
							<td>* 아이디</td>
							<td><input type="text" name="memberId"></td>
						</tr>
						<tr>
							<td>* 비밀번호</td>
							<td><input type="password" name="memberPwd"></td>
						</tr>
						<tr>
							<td>* 비밀번호 확인</td>
							<td><input type="password" name="memberPwd2"></td>
						</tr>
						<tr>
							<td>* 닉네임</td>
							<td><input type="text" name="memberNick"></td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><input type="tel" name="phone"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="email" name="email"></td>
						</tr>
						<tr>
							<td>취미</td>
							<td>
								<label for="cb01">게임</label> <input id="cb01" type="checkbox" name="hobbys" value="game">
								<label for="cb02">요리</label> <input id="cb02" type="checkbox" name="hobbys" value="cook">
								<label for="cb03">운동</label> <input id="cb03" type="checkbox" name="hobbys" value="workout">
								<br>
								<label for="cb04">자바</label> <input id="cb04" type="checkbox" name="hobbys" value="Java">
								<label for="cb05">JS</label> <input id="cb05" type="checkbox" name="hobbys" value="js">
								<label for="cb06">쿼리</label> <input id="cb06" type="checkbox" name="hobbys" value="sql">
							</td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="회원가입"></td>				
						</tr>
						
					</tbody>
				</table>
			</form>
		</main>	
	</div>

</body>
</html>

<script>

	function checkValidate(){

		// 아이디 길이
		const memberId = document.querySelector("main input[name=memberId]").value;
		const memberIdRegex = /^[a-z0-9]{4,12}$/;
		if(!memberIdRegex.test(memberId)){
			alert('아이디를 올바르게 입력하세요');
			document.querySelector("input[name=memberId]").focus();
			return false;
		}

		// 패스워드 일치 여부
		const memberPwd = document.querySelector("main input[name=memberPwd]").value;
		const memberPwd2 = document.querySelector("main input[name=memberPwd2]").value;

		if(memberPwd !== memberPwd2){
			document.querySelector("main input[name=memberPwd]").focus();
			alert('패스워드가 일치하지 않습니다');                       
			return false;                                                                                                                                               
		}
		// 패스워드 길이
		if(memberPwd.length < 4){
			document.querySelector("main input[name=memberPwd]").focus();
			alert("비밀번호는 4글자 이상이어야합니다.")
			return false; 
		}
		// 닉네임에 부적절한 단어 없는지
		const memberNick = document.querySelector("main input[name=memberNick]").value;
		if(memberNick.includes("admin")){
			document.querySelector("main input[name=memberNick]").focus();
			alert("부적절한 닉네임 입니다.");
			return false;
		}
		// 이메일 형식 (정규식)
		// 전화번호 형식 (정규식)

		return true;
	}

</script>