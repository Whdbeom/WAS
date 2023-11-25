package edu.kh.test.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;

@WebServlet("/selectUser")
public class SelectUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {		
			String userNum = req.getParameter("userNum");	
			
			UserDAO dao = new UserDAO();
			
			UserDTO dto = dao.search(userNum);
			System.out.println("servlet" + dto);

			if(dto == null) {
				throw new Exception("dto == null");
			}
			
			System.out.println("servlet" + dto);

			req.setAttribute("userInfo", dto);
			req.getRequestDispatcher("/WEB-INF/views/searchSuccess.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/searchFail.jsp").forward(req, resp);
		}
		
		
	}
	
}
