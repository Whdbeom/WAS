package zzz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.JDBCTemplate;

@WebServlet("/home")
public class home extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Connection conn = new JDBCTemplate().getConnection();

	        String query = "select 1 from dual";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        ResultSet rs = pstmt.executeQuery();

	        if(rs.next()) {
	            int result = rs.getInt(1);
	            System.out.println(result);
	        }
	        
		} catch(Exception e) {
			
		}

	}
	
}
