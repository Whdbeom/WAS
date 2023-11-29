package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청받음");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		BoardVo vo = new BoardVo();
		vo.setTitle("제ㅐ목ㅋㅋㅋㅋㅋㅋㅋㅋ");
		vo.setContent("내용ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ");
//		System.out.println(String.valueOf(vo));
//		System.out.println(vo.toString());
		
		String str = "{\"title\":\"ttt\",\"content\":\"ccc\"}";
		
		out.write(str);
	}
	
}
