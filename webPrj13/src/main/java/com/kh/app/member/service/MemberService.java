package com.kh.app.member.service;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {

	// 회원가입처리
	public int join(MemberVo vo) throws Exception {
		
		// business logic
		if(vo.getMemberId().length() < 4) {
			throw new Exception("아이디 4글자 미만 ㄴㄴ");
		}
	
		if(!vo.getMemberPwd().equals(vo.getMemberPwd2())) {
			throw new Exception("비밀번호 불일치");
		}
		
		if(vo.getMemberPwd().length() < 4) {
			throw new Exception("비밀번호 4글자 미만 ㄴㄴ");
		}
		
		if(vo.getMemberNick().contains("관리자")) {
			throw new Exception("관리자 넣으면 안돼");
		}
		
		
		System.out.println(vo.getMemberId());
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.join(vo, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);			
		}
		
		JDBCTemplate.close(conn);
				
		return result;
	}

	public MemberVo login(MemberVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(vo, conn);
		//tx
		

		//close
		JDBCTemplate.close(conn);
				
	
		
		return loginMember;
	}

	public int quit(MemberVo vo) throws Exception {
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		int result = dao.quit(vo, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
