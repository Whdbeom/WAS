package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberDao {

	public int join(MemberVo vo, Connection conn) throws Exception {
 
		String sql = "INSERT INTO MEMBER(NO,ID,PWD,NICK,PHONE,EMAIL,ADDRESS,HOBBYS) VALUES( SEQ_MEMBER_NO.NEXTVAL ,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		pstmt.setString(3, vo.getMemberNick());
		pstmt.setString(4, vo.getPhone());
		pstmt.setString(5, vo.getEmail());
		pstmt.setString(6, vo.getAddr());		
		pstmt.setString(7, vo.getHobbyStr());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo loginMember = null;
		
		if(rs.next()) {
			
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String phone = rs.getString("PHONE");
			String email = rs.getString("EMAIL");
			String address = rs.getString("ADDRESS");
			String hobbyStr = rs.getString("HOBBYS");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			
			loginMember = new MemberVo();
			loginMember.setNo(no);
			loginMember.setMemberId(id);
			loginMember.setMemberPwd(pwd);
			loginMember.setMemberNick(nick);
			loginMember.setPhone(phone);
			loginMember.setEmail(email);
			loginMember.setAddr(address);
			loginMember.setHobbyStr(hobbyStr);
			loginMember.setEnrollDate(enrollDate);
			loginMember.setModifyDate(modifyDate);
			loginMember.setStatus(status);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		
		return loginMember;
	}

}
