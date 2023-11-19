package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String id = req.getParameter("memberId");
			String pwd = req.getParameter("memberPwd");
			
			MemberVo vo = new MemberVo();
			vo.setMemberId(id);
			vo.setMemberPwd(pwd);
			
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
				
			req.setAttribute("str", "로그인");
			
			if(loginMember == null) {
				throw new Exception("유저없음");			
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("userData", loginMember);
			
//			req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
			resp.sendRedirect("/app14/home");
			
		} catch(Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
		
		
		
	}
	
}
