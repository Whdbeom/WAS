package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet{	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		System.out.println("home이라는 요청받음");
		
		// 클라이언트가 보낸 데이터 받기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String nick = req.getParameter("nick");
		System.out.println("id ::: " + id);
		System.out.println("pwd ::: " + pwd);
		System.out.println("nick ::: " + nick);
		
//		resp.setCharacterEncoding("UTF-8");
//		pw.write("<meta charset=\"UTF-8\">");
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter pw =  resp.getWriter();
		
		pw.write("<!DOCTYPE HTML>");
		pw.write("<html>");
		pw.write("<head>");
		pw.write("<title>제목ㅋㅋㅋㅋ</title>");
		pw.write("</title>");
		pw.write("<style>");
		pw.write("h1 {"
				+ "background-color : lightgray;"
				+ "}");
		pw.write("</style>");
		pw.write("</head>");
		pw.write("<body>");
		
		pw.write("<h1>home page ~~~</h1>");
		pw.write("<h3>" + nick +"님 환영합니다</h3>");
		
		pw.write("<script>");
		pw.write("alert('"+ nick + "님 화녕ㅇ합니다.');");
		pw.write("</script>");
		
		pw.write("</body>");
		pw.write("</html>");
		
	}
}
