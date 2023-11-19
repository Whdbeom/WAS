package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter pw = resp.getWriter();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		pw.write(id + pwd);
		req.getRequestDispatcher("WEB-INF/views/abc.jsp").forward(req, resp);
		
		
	}
}
