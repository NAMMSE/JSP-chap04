package chap04.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap04.database.DBConnector;

// 0726 사원 추가 문제 내 코드
@WebServlet("/servlet/addemp")
public class EmployeeAddProcess extends HttpServlet{
	String[] emp;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		emp = req.getParameterValues("info");
		System.out.println(Arrays.toString(emp));
		
		String sql="insert into employees (employee_id, first_name, last_name, email, hire_date, job_id) values (?,?, ?, ?, ? ,?)";
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			Date date = new Date();
			pstmt.setInt(1, Integer.parseInt(emp[0]));
			pstmt.setString(2, emp[1]);
			pstmt.setString(3, emp[2]);
			pstmt.setString(4, emp[3]);
			pstmt.setDate(5, new java.sql.Date(date.getTime()));
			pstmt.setString(6, emp[5]);
				
			pstmt.executeUpdate();
			
			System.out.println("DB insert success");	
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB insert error");
		}
		
		//resp.sendRedirect("/WEB-INF/views/employee/addForm.jsp");
		req.getRequestDispatcher("/WEB-INF/views/employee/addForm.jsp").forward(req, resp);
		
	}
}
