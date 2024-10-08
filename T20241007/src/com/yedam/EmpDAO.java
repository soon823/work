package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpDAO {
	
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs;
	
	public void getOpen() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.19:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결하기");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int insert(Employee emp) {
		getOpen();
		
		String sql = "" 
					+ "insert into Employee ( member, name, phone, hire, salary) "
					+ "values(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getMember());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getPhone());
			pstmt.setString(4, emp.getHire());
			pstmt.setInt(5, emp.getSalary());
			
			
			int rows = pstmt.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		getClose();
		return 0;
	}
	
	
	
	List<Employee> empList(){
		String sql = ""
					+ "select * "
					+ "from employee";
		List<Employee> result = new ArrayList<>();
		getOpen();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setMember(rs.getString("Member"));
				emp.setName(rs.getString("Name"));
				emp.setPhone(rs.getString("Phone"));
				emp.setHire(rs.getString("Hire"));
				emp.setSalary(rs.getInt("Salary"));
				
				
				result.add(emp);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return result;
}
	
	
	
	
	
	public void getClose() {
		if(conn != null) {
			try {
				conn.close();
				System.out.println("연결끊기");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}//end class
