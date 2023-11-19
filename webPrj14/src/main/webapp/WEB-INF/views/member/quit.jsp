<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>회원탈퇴</h1>

    <form action="/app14/member/quit" method="post">
        <table>
            <tr>
                <td>비밀번호를 입력해주세요</td>
                <td><input type="password" name="memberPwd"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="회원탈퇴"></td>
            </tr>
        </table>
	</form>
</body>
</html>