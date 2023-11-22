package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {

	public int join(MemberVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//business logic
		//아이디 4~12 영문소문자+숫자
		String id = vo.getMemberId();
		boolean idOk = id.matches("[a-z0-9]{4,12}");
		
		if(!idOk){
			throw new Exception("아이디 값 잘못됨");
		}
		
		//비밀번호 일치여부체크
		if(!vo.getMemberPwd().equals(vo.getMemberPwd2())) {
			throw new Exception("비밀번호 불일치");
		}
		
		//비밀번호 4글자 이상
		if(vo.getMemberPwd().length() <= 4) {
			throw new Exception("ㅂㅣ밀번호짧음");
		}
		
		//닉네임에 admin 금지
		if(vo.getMemberNick().contains("admin")) {
			throw new Exception("닉에 admin안됨");
		}
		
		
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
		MemberVo loginMember = dao.login(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return loginMember;
	}

}
