package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 게시글 상세조회
		// SELECT * FROM BOARD WHERE NO = ? AND STATUS = 'O'
		try {
			// data
			String boardNo = req.getParameter("no");
			// service
			BoardService ms = new BoardService();
			BoardVo vo = ms.selectBoardByNo(boardNo);
			
			if(vo == null) {
				throw new Exception();
			}
			
			// result == view
			req.setAttribute("currPage", req.getParameter("currPage"));
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);		
		} catch(Exception e) {
			System.out.println("[ERROR-B003] 게시글 상세조회 중 에러 발샹...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 상세조회 실패..");
			req.getRequestDispatcher("/WEB-INF/views/board/error.jsp").forward(req, resp);		
			
		}
	}
	
	
	
}
