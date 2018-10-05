/* 
 * Contains the jdbc connectivity containing 7 steps but not in modular way.
 * 
 * other package in the project contains 3 classes and contains jdbc connectivity in modeular way
 */

package com.jdbc;

import java.sql.*;

public class DemoJDBC {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");//loads the Driver class(i.e->static block of Driver class gets called when it is loaded)
		
		String url = "jdbc:mysql://localhost:3306/db";
		Connection con = DriverManager.getConnection(url, "root", "root");
		
		//to execute query that returns table(like select)
//		Statement st = con.createStatement();
//		String query1 = "Select * from student";
//		ResultSet rs = st.executeQuery(query1);
//		while(rs.next()) {
//			System.out.println(rs.getString(1)+" "+rs.getString("name"));
//		}
//		
		//to execute query that update table content(DML queries)
//		String query2 = "insert into student values(4,'andl')";
//		int cnt = st.executeUpdate(query2);
//		System.out.println(cnt + " row/s affected!");
		
		//to execute statements of DML having dynamic data(eg: id,name in this eg)
		int id =34;
		String name = "namm";
		String query3 = "insert into student values (?,?)";
		PreparedStatement st = con.prepareStatement(query3);
		st.setInt(1, id);
		st.setString(2, name);
		int cnt = st.executeUpdate();
		System.out.println(cnt+" row afected!!!");
		
		st.close();
		con.close();
	}

}
