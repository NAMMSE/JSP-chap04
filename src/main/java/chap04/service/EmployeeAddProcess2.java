package chap04.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap04.database.DBConnector;

public class EmployeeAddProcess2 implements Process{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		Integer employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hire_date = request.getParameter("hire_date");
		String job_id = request.getParameter("job_id");
		
		String sql="insert into employees2 (employee_id, last_name, email, hire_date, job_id) values (?, ?, ?, ? ,?)";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, employee_id);
			pstmt.setString(2, last_name);
			pstmt.setString(3, email);
			
			// preparedStatement의 setDate는 java.sql.Date를 요구한다
			//pstmt.setDate(4, new java.sql.Date(format.parse(hire_date).getTime()));
			
			//java.sql.Date의 static method 중 valueof에 html에서 받은 날짜 형식을 그대로 넘기면 java.sql.Date의 인스턴스를 반환한다
			pstmt.setDate(4, Date.valueOf(hire_date));
			pstmt.setString(5, job_id);
				
			int row = pstmt.executeUpdate();
			
			System.out.println("DB insert success");	
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB insert error");
		} 
		
		// 첨 배운 내용 / 어떤 기능이 있는게 아니라 if문으로 거르려고 그냥 앞에redirect를 붙인거임
		return "redirect:/chap04/employee/list";
	}
	
	

}
