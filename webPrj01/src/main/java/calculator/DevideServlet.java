package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/devide")
public class DevideServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter pw = resp.getWriter();
		
		String num = req.getParameter("num");
		String num2 = req.getParameter("num2");
		
		int n = Integer.parseInt(num);
		int n2 = Integer.parseInt(num2);
		int result = n/n2;
		
		System.out.println(result);
		pw.write("<h1>" + result + "</h1>");
	}

}
