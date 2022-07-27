package chap04.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap04.service.EmployeeAddFormProcess;
import chap04.service.EmployeeAddProcess2;
import chap04.service.EmployeeDeleteProcess;
import chap04.service.EmployeeDeleteProcess2;
import chap04.service.EmployeeListProcess;
import chap04.service.EmployeeModifyFormProcess;
import chap04.service.EmployeeModifyProcess;
import chap04.service.EmployeeUpdateFormProcess;
import chap04.service.EmployeeUpdateProcess;
import chap04.service.Process;

// 0726 수업
public class DispatcherServlet extends HttpServlet{
	
	private final static String REDIRECT = "redirect:";
	
	HashMap<String, Process> uri_mapping; //= new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		uri_mapping = new HashMap<>();
		uri_mapping.put("/employee/list", new EmployeeListProcess());
		uri_mapping.put("/employee/add_form", new EmployeeAddFormProcess()); // addForm2로 이동
		uri_mapping.put("/employee/add", new EmployeeAddProcess2());
		uri_mapping.put("/employee/update_form", new EmployeeUpdateFormProcess());
		uri_mapping.put("/employee/update", new EmployeeUpdateProcess());
		uri_mapping.put("/employee/delete", new EmployeeDeleteProcess());
		uri_mapping.put("/employee/modify", new EmployeeModifyProcess()); //강사님
		uri_mapping.put("/employee/delete2", new EmployeeDeleteProcess2()); //강사님
		uri_mapping.put("/employee/modify_form", new EmployeeModifyFormProcess()); //강사님
	
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		
		System.out.println("request uri : " + uri);
		System.out.println("remove context path : " + uri.substring(req.getContextPath().length()));
		
		
		uri = uri.substring(req.getContextPath().length());
		
		// 사용자가 접속한 주소(URI)로 알맞은 처리(process)를 꺼낸다
		Process process = uri_mapping.get(uri);
		
		String nextPath;
		if(process != null) {
			nextPath =  process.process(req, resp);
			
			if(nextPath.startsWith(REDIRECT)) { // 이 리디렉트는 정말 문자열 그 자체고 if문에서 거르려고 붙인 것 
				resp.sendRedirect(nextPath.substring(REDIRECT.length())); // 리디렉트 경로는 뒤에 붙어있으니 잘라준다
				return; // 경로로 리디렉트하고 포워딩은 안할거니까 리턴
			}
		}else {
			nextPath = "/WEB-INF/employee/error.jsp";
		}
		req.getRequestDispatcher(nextPath).forward(req, resp);
	}
}
