package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/quit")
public class MemberQuitController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/quit.jsp").forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("userData");
			
			String id = loginMember.getMemberId();
			String nick = loginMember.getMemberNick();
			String pwd = req.getParameter("memberPwd");
			
			if(!pwd.equals(loginMember.getMemberPwd())){
				throw new Exception("비밀번호 불일치");
			}
			
			MemberVo vo = new MemberVo();
			
			vo.setMemberId(id);
			vo.setMemberNick(nick);
			vo.setMemberPwd(pwd);
			
			MemberService ms = new MemberService();
			int result = ms.quit(vo);
			
			req.setAttribute("str", "회원탈퇴");
			
			if(result != 1) {
				throw new Exception("result 1 아님");				
			}
			
			session.invalidate();
			req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
			
			
		} catch(Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);			
		}
			
	}
}
