package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.page.vo.PageVo;
import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			BoardService bs = new BoardService();
			
			//data
			int listCount = bs.selectBoardCount(); // 전체 게시글 갯수
			int currentPage = Integer.parseInt(req.getParameter("pno")); // 현재 페이지
			int pageLimit = 10;
			int boardLimit = 5;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			//service
			List<BoardVo> boardVoList = bs.selectBoardList(pvo);
			
			
			// result (==view)
			req.setAttribute("boardVoList", boardVoList);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	
}
