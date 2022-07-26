package chap04.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 강사님 코드
public class EmployeeAddFormProcess implements Process{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		//web.xml에 서블릿 매핑을 추가하는 것이 아니라 프로세스를 만들어서 경로를 리턴해주면 된다 
		return "/WEB-INF/views/employee/addForm2.jsp";
	}

}
