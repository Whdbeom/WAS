package com.kh.app.board;

import java.sql.Connection;

import com.kh.app.util.JDBCTemplate;

public class BoardService {

	public int write(BoardVo vo) throws Exception {		
		
//		if(vo.getTitle().length() > ){
		
		
		Connection conn = JDBCTemplate.getConnection();
		BoardDao dao = new BoardDao();
		int result = dao.write(vo, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}	
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
