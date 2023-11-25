package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.kh.test.user.model.vo.UserDTO;
import edu.kh.test.user.util.JDBCTemplate;

public class UserDAO {

	public UserDTO search(String userNum) throws Exception {
		
		System.out.println("DAO" + userNum);
		
		Connection conn = JDBCTemplate.getConnection();

		String sql = "SELECT * FROM C##SEMI.TB_USER WHERE USER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userNum);
		ResultSet rs = pstmt.executeQuery();
		
		
		UserDTO dto = null;
		if(rs.next()) {
			String userNo = rs.getString("USER_NO");
			String userId = rs.getString("USER_ID");
			String userName = rs.getString("USER_NAME");
			String userAge = rs.getString("USER_AGE");

			dto = new UserDTO();
			
			dto.setUserNo(userNo);
			dto.setUserId(userId);
			dto.setUserName(userName);
			dto.setUserAge(userAge);
		}
		
		System.out.println("dao" + dto);
		
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return dto;
	}

}
