package com.kh.app.member;

import java.sql.Connection;
import java.sql.DriverManager;

import com.kh.app.db.util.JDBCTemplate;

public class MemberService {
	//회원가입
	public int join(MemberVo vo) throws Exception {
		//business logic
		if(!vo.getMemberPwd().equals(vo.getMemberPwd2())) {
			throw new Exception("[ERROR-M002] 비밀번호 불일치");
		}
		
//		if(vo.getMemberId().length() < 4 ) {
//			throw new Exception("아이디 길이 짧음");
//		}
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}
	
}
