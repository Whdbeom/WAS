package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberDao {

	public int join(MemberVo vo, Connection conn) throws Exception {
		
		String sql = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		pstmt.setString(3, vo.getMemberNick());
		
		int result = pstmt.executeUpdate();
	
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public MemberVo login(MemberVo vo, Connection conn) throws Exception {
		
		// sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		
		// rs
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo loginMember = null;
		
		if(rs.next()) {
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			
			loginMember = new MemberVo();
			loginMember.setMemberId(id);
			loginMember.setMemberPwd(pwd);
			loginMember.setMemberNick(nick);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginMember;
	}

	public int quit(MemberVo vo, Connection conn) throws Exception {
		
		String sql = "DELETE FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
	
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}
