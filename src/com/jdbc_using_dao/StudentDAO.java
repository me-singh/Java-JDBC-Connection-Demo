package com.jdbc_using_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	Connection con;
	
	public void getConnection() {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			String query = "select * from student";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				students.add(new Student(rs.getInt(1), rs.getString(2)));
			}
			return students;
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		return null;
	}
	
	public Student getStudent(int id) {
		try {
			Statement st = con.createStatement();
			String query = "select * from student where id = "+id;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			return new Student(id,rs.getString(2));
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return null;
	}
	
	public void addStudent(Student s) {
		String query = "insert into student values(?,?)";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, s.getId());
			st.setString(2, s.getName());
			int cnt = st.executeUpdate();
			System.out.println(cnt+" row/s affected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(int id) {
		String query = "delete from student where id = ?";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			int cnt = st.executeUpdate();
			System.out.println(cnt+" row/s affected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(int id,String name) {
		String query = "update student set name = ? where id = ?";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			st.setInt(2, id);
			int cnt = st.executeUpdate();
			System.out.println(cnt+" row/s affected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
