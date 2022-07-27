package chap04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap04.database.DBConnector;
import chap04.model.Department;
// 0727
public class DepartmentDAO {
	public static List<Department> getList(){
		List<Department> list = new ArrayList<>();
		String sql = "select distinct department_id, department_name from departments";
		
		
		try(Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			while(rs.next()) {
				list.add(new Department(rs.getInt("department_id"), rs.getString("department_name")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
