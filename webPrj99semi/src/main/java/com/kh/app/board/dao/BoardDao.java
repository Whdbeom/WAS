package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class BoardDao {

	public List<BoardVo> selectBoardList(Connection conn) throws Exception {
		// SQL
		String sql = "SELECT B.*, M.NICK WRITER_NICK, C.NAME CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.STATUS = 'O' ORDER BY B.NO DESC"; 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
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

	public int write(Connection conn, BoardVo vo) throws Exception {
		
		String sql ="INSERT INTO BOARD (NO, CATEGORY_NO, TITLE, CONTENT, WRITER_NO) VALUES ( SEQ_BOARD_NO.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getCategoryNo());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
		pstmt.setString(4, vo.getWriterNo());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public BoardVo selectBoardByNo(String boardNo, Connection conn) throws Exception {
		
		String sql = "SELECT B.*, M.NICK WRITER_NICK, C.NAME CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.NO = ? AND B.STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		BoardVo vo = null;
		
		if(rs.next()) {
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

			vo = new BoardVo();
			
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
			
		}
		
		
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	public int increaseHit(Connection conn, String boardNo) throws Exception {
		
		String sql = "UPDATE BOARD SET HIT = HIT+1 WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardNo);
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int delete(String memberNo, String no, Connection conn) throws Exception {
		
		String sql = "UPDATE BOARD SET STATUS = 'X' WHERE NO = ? AND WRITER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setString(2, memberNo);
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}
