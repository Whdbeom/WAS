<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
       <%
    	MemberVo vo = (MemberVo)session.getAttribute("userData");
	
    	String x = "게스트";
    	
    	if(vo != null){
    		x = vo.getMemberNick();
    	}
	   
	    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	닉네임 : <% out.print(x); %>
    <form action="/app13/member/quit" method="post">
        <table>

            <tr>
                <td>
                    <label for="">비밀번호를 입력하세요</label>
                </td>
                <td>
                    <input type="password" name="memberPwd">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="회원탈퇴">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>