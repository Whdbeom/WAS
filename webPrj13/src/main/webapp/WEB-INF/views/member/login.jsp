<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/app13/member/login" method="post">
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
                <td colspan="2" align="right">
                    <input type="submit" value="로그인">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>