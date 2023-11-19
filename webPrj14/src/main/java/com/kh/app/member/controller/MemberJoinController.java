package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String id = req.getParameter("memberId");
			String pwd = req.getParameter("memberPwd");
			String pwd2 = req.getParameter("memberPwd2");
			String nick = req.getParameter("memberNick");
			
			MemberVo vo = new MemberVo();
			vo.setMemberId(id);
			vo.setMemberPwd(pwd);
			vo.setMemberPwd2(pwd2);
			vo.setMemberNick(nick);
			
			MemberService ms = new MemberService();
			
			int result = ms.join(vo);
			
			if(result != 1) {
				throw new Exception();
			}
			req.setAttribute("str", "회원가입");
			req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);				
		} catch(Exception e) {
			System.out.println("회원가입중에러발생");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
	}
	
}
