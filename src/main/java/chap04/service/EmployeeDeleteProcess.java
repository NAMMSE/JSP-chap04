package chap04.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap04.database.DBConnector;
// 0727 
public class EmployeeDeleteProcess implements Process{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("삭제될 사원의 사원번호 : " + request.getParameter("employee"));
		Integer employee_id = Integer.parseInt(request.getParameter("employee"));
		
		String sql = "delete from employees2 where employee_id = ?";
		
		try(Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);	
		) {
			pstmt.setInt(1, employee_id);
			int row = pstmt.executeUpdate();
			System.out.println(row + " row Delete success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "redirect:/chap04/employee/list";
	}

}
