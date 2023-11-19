package com.kh.app.member.join;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/join/processor")
public class MemberJoinProcessorServlet extends HttpServlet {
       
	// 회원가입을 진행하는 메소드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8;");
		//데이터
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String pwd2 = req.getParameter("pwd2");
		String nick = req.getParameter("nick");
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(pwd2);
		System.out.println(nick);
		
		
		//서비스 
		int result = 1;
		
		if(id.equals("ADMIN")) {
			result = 0;
		}
		
		// 결과
		PrintWriter out = resp.getWriter();
		if(result == 1) {
			out.write("<h1>성공</h2>");
		} else {
			out.write("<h1>실패</h2>");
		}
			
	
//		req.getRequestDispatcher("/WEB-INF/views/member/joinProcessor.jsp").forward(req, resp);				
		
	}

}
