package chap04.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap04.database.DBConnector;
import chap04.model.Employee;

//0726 수업
public class EmployeeListProcess implements Process{
	// 빌드패스로 ojdbc8 add하기 - deployment assembly도 추가
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employees";
		
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		) {
			while(rs.next()) {
				employees.add(new Employee(rs));
				
		}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error");
		}
		
		// 꺼낸 데이터를 실어 놓는다
		request.setAttribute("employees", employees);
		
		// 다음으로 가야 할 페이지의 URL을 리턴한다
		return "/WEB-INF/views/employee/list.jsp";
	
	}
}
