package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.page.vo.PageVo;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;

public class BoardService {

	public List<BoardVo> selectBoardList(PageVo pvo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		
		List<BoardVo> boardVoList = dao.selectBoardList(pvo, conn);
		
		JDBCTemplate.close(conn);
		
		return boardVoList;
	}

	public int selectBoardCount() throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		// dao
		BoardDao dao = new BoardDao();
		int cnt = dao.selectBoardCount(conn);
		// tx
		
		// close
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

}
