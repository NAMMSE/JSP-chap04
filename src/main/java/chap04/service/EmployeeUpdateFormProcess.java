package chap04.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap04.database.DBConnector;
import chap04.model.Job;

// 0727
public class EmployeeUpdateFormProcess implements Process{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String sql1 = "SELECT MAX(employee_id) as max_id FROM employees2";
		String sql2 = "SELECT DISTINCT job_id, job_title FROM jobs";
		
		
		try(Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);	
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			ResultSet rs1 = pstmt1.executeQuery();
			ResultSet rs2 = pstmt2.executeQuery();
		) {
			//rs1.next(); // rs는 한번 꺼내줘야한다
			request.setAttribute("employee_id",rs1.next() ? rs1.getInt("max_id") : null);
			
			ArrayList<Job> jobs = new ArrayList<>();
			
			while(rs2.next()) {
				jobs.add(new Job(rs2.getString("job_id"), rs2.getString("job_title")));
			}
			
			
			request.setAttribute("jobs", jobs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "/WEB-INF/views/employee/update.jsp";
	}
	
	

}
