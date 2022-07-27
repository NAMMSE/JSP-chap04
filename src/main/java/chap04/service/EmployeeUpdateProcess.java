package chap04.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap04.database.DBConnector;
import chap04.model.Job;

// 0727
public class EmployeeUpdateProcess implements Process{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println(request.getParameter("employee").getClass().getName());
//		String intOrString = request.getParameter("employee").getClass().getName();
//		if(intOrString.equals("java.lang.String")) {}	
//return new EmployeeAddFormProcess().process(request, response).substring(0,23)+"update.jsp";
		
		Integer employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String hire_date = request.getParameter("hire_date");
		String job_id = request.getParameter("job_id");
		Integer emp_id = Integer.parseInt(request.getParameter("employee"));
		
		String sql="update employees2 set employee_id = ?, first_name = ?, last_name = ?, "
				+ "email = ?, phone_number = ?, hire_date = ?, job_id = ? where employee_id = ?";
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, employee_id);
			pstmt.setString(2, first_name);
			pstmt.setString(3, last_name);
			pstmt.setString(4, email);
			pstmt.setString(5, phone_number);
			pstmt.setDate(6, Date.valueOf(hire_date));
			pstmt.setString(7, job_id);
			pstmt.setInt(8, emp_id);
				
			int row = pstmt.executeUpdate();
			
			System.out.println("DB update success");	
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB update error");
		} 
		
		return "/WEB-INF/views/employee/list.jsp";
		
	}

}
