package com.jdbc_using_dao;

import java.util.List;

public class JDBCDemo {
	
	public static void main(String[] args) {
		
		StudentDAO stDao = new StudentDAO();
		stDao.getConnection();
		
		//to print whole content of the table
		List<Student> students = stDao.getStudents();
		for(Student st:students) {
			System.out.println(st.getId()+" "+st.getName());
		}
		
		System.out.println();
		
		//to print values corresponding to particular id
		Student s2 = stDao.getStudent(6);
		if(s2 != null) {
			System.out.println(s2.getId()+" "+s2.getName());
		}else {
			System.out.println("No such field!");
		}
		
		System.out.println();
		
		//to add student into the student table
		Student s1 = new Student(4, "aask");
		stDao.addStudent(s1);
		
		System.out.println();
		
		//to delete student from the student table corresponding to particular id
		stDao.deleteStudent(34);
		
		System.out.println();
		
		//to update student coresponding to the particular id
		stDao.updateStudent(2, "new_name");
	}

}
