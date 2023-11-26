package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.page.vo.PageVo;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;

public class BoardDao {

	public List<BoardVo> selectBoardList(PageVo pvo, Connection conn) throws Exception {
		
//		String sql = "SELECT B.*, C.NAME CATEGORY_NAME, M.NICK WRITER_NICK FROM BOARD B JOIN CATEGORY C ON B.CATEGORY_NO = C.NO JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE B.STATUS = 'O'";
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.*, M.NICK WRITER_NICK, C.NAME CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.STATUS = 'O' ORDER BY B.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<BoardVo> boardVoList = new ArrayList<BoardVo>();
		while(rs.next()) {
		
			String no = rs.getString("NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String categoryName = rs.getString("CATEGORY_NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
		
			BoardVo vo = new BoardVo();
			
			vo.setNo(no);
			vo.setCategoryNo(categoryNo);
			vo.setCategoryName(categoryName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setWriterNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setStatus(status);
			
			boardVoList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return boardVoList;
	}

	public int selectBoardCount(Connection conn) throws Exception {
		
		String sql = "SELECT COUNT(*) as cnt FROM BOARD WHERE STATUS='O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 0;	
		
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return cnt;
	}

}
