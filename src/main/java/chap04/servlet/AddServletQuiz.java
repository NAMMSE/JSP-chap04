package chap04.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 0726 사원 추가 문제 내 코드
public class AddServletQuiz extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/employee/addForm.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
}
