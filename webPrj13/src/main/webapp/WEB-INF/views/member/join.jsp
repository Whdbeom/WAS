<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입페이지</h1>
    <form action="/app13/member/join" method="post">
        <table>
            <tr>
                <td>
                    <label for="">아이디</label>
                </td>
                <td>
                    <input type="text" name="memberId">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="">비밀번호</label>
                </td>
                <td>
                    <input type="password" name="memberPwd">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="">비밀번호확인</label>
                </td>
                <td>
                    <input type="password" name="memberPwd2">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="">닉네임</label>
                </td>
                <td>
                    <input type="text" name="memberNick">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="회원가입">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>