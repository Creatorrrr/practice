package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionFactory;
import constants.SGConstants.EOrderItems;
import controller.SGStudent;

public class SGStoreDB {


	public SGStoreDB() {}
	
	public void insertStudent(SGStudent student) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
// 1. Query 备巩 积己 棺 角青
		conn = ConnectionFactory.getInstance().createConnnection();
		
		pstmt = conn.prepareStatement("INSERT INTO student_tb VALUES(?,?,?,?,?)");
		
		pstmt.setString(1, student.getStudentId());
		pstmt.setString(2, student.getName());
		pstmt.setString(3, student.getKor() + "");
		pstmt.setString(4, student.getEng() + "");
		pstmt.setString(5, student.getMath() + "");
		
		pstmt.executeUpdate();
	}
	
	public void updateStudent(SGStudent student, String targetId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
// 1. Query 备巩 积己 棺 角青
		conn = ConnectionFactory.getInstance().createConnnection();
		
		pstmt = conn.prepareStatement(
				"UPDATE student_tb SET studentId = ?,"
									+ "name = ?,"
									+ "kor = ?,"
									+ "eng = ?, "
									+ "math = ? WHERE studentId = ?");
		
		pstmt.setString(1, student.getStudentId());
		pstmt.setString(2, student.getName());
		pstmt.setString(3, student.getKor() + "");
		pstmt.setString(4, student.getEng() + "");
		pstmt.setString(5, student.getMath() + "");
		pstmt.setString(6, targetId);
		
		pstmt.executeUpdate();
	}
	
	public void deleteStudent(String studentId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
// 1. Query 备巩 积己 棺 角青
		conn = ConnectionFactory.getInstance().createConnnection();
		
		pstmt = conn.prepareStatement(
				"DELETE FROM student_tb WHERE studentId = ?");
		
		pstmt.setString(1, studentId);
		
		pstmt.executeUpdate();
	}
	
	public ArrayList<SGStudent> selectStudent(String studentId, EOrderItems order) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		ArrayList<SGStudent> studentList = new ArrayList<>();
		
// 1. Query 备巩 积己 棺 角青
		conn = ConnectionFactory.getInstance().createConnnection();
		
		if(studentId != null) {
			pstmt = conn.prepareStatement(
					"SELECT studentId, name, kor, eng, math "
					+ "FROM student_tb "
					+ "WHERE studentId = ? "
					+ "ORDER BY ? DESC");
		} else {
			pstmt = conn.prepareStatement(
					"SELECT studentId, name, kor, eng, math "
					+ "FROM student_tb "
					+ "ORDER BY ? DESC");
		}
		pstmt.setString(1, studentId);
		
		switch(order) {
		case STUDENT_ID:
			pstmt.setString(2, "studentId");
			break;
		case TOTAL:
			pstmt.setString(2, "kor");
			break;
		default:
			pstmt.setString(2, "studentId");
			break;
		}
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			studentList.add(new SGStudent(rs.getString("name"),
					rs.getString("studentId"), 
					rs.getInt("kor"), 
					rs.getInt("eng"),
					rs.getInt("math")));
		}
		
		return studentList;
	}
}
