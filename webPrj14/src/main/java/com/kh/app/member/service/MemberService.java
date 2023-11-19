package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {

	public int join(MemberVo vo) throws Exception {
		
		if(!vo.getMemberPwd().equals(vo.getMemberPwd2())) {
			throw new Exception("비밀번호 불일치");
		}	
		
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
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(vo, conn);	
		
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
