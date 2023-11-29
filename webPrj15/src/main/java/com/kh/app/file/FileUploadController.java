package com.kh.app.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
			maxFileSize = 1024 * 1024 * 10		 // 파일 하나당 크기
			, maxRequestSize = 1024 * 1024 * 50  // 리퀘스트 전체 크기
			
		)
@WebServlet("/file/insert")
public class FileUploadController extends HttpServlet {

	// 파일 업로드 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("메소드 호출 ㅇㅋ");
		
		Part file = req.getPart("file");
		System.out.println(file);
		System.out.println(file.getSubmittedFileName());
		
		// 읽기 준비
		InputStream in = file.getInputStream();
		
		// 내보내기 준비
		String sep = File.separator;
		String path = req.getServletContext().getRealPath(sep + "resources" + sep + "upload" + sep + "img");
		String fileName = sep + "abc.png";
		
		File target = new File(path + fileName);
		FileOutputStream out = new FileOutputStream(target);
		
		int data = 0;
		while((data = in.read()) != -1) {
			out.write(data);			
		}
		
		// 정리
		in.close();
		out.close();
	}
	
}
