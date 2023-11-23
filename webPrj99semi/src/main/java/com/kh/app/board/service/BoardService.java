package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class BoardService {

	public List<BoardVo> selectBoardList() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		List<BoardVo> boardVoList = dao.selectBoardList(conn);
		
		JDBCTemplate.close(conn);
		
		return boardVoList;
	}

	public int write(BoardVo vo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		int result = dao.write(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public BoardVo selectBoardByNo(String boardNo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BoardDao dao = new BoardDao();
		int result = dao.increaseHit(conn, boardNo);
		
		BoardVo vo = null;	
		if(result == 1) {
			vo = dao.selectBoardByNo(boardNo, conn);			
		}
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	
		JDBCTemplate.close(conn);
		return vo;
	}

	public int delete(String memberNo, String no) throws Exception {
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		int result = dao.delete(memberNo, no, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
