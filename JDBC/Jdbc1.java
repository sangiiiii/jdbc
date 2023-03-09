package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Jdbc1 {
	public static void main(String args[]) {
		try {
			String userName = "root";
			String password = "Radhamani@98";
			Class.forName("com.mysql.cj.jdbc.Driver");//register the driver
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details", userName,password);  //ctreate connection
			Statement stmt = connection.createStatement();//create statement
			int noOFRecrdDeleted = stmt.executeUpdate("DELETE FROM emp_details WHERE emp_id = 68310"); //execute query
			System.out.println(noOFRecrdDeleted + "deleted");
			int noOFRecrdInserted = stmt.executeUpdate("INSERT INTO emp_details(emp_id,manager_id,salary,dep_id) VALUES(68319,68319,6000.00,1001)"); 
			System.out.println(noOFRecrdInserted+ "inserted");
			int noOFRecrdInserted1 = stmt.executeUpdate("INSERT INTO emp_details(emp_name,job_name,hire_date,commision)VALUES('KAYLING','PRESIDENT','1991-11-18','NULL')"); 
			System.out.println(noOFRecrdInserted1 + "inserted");
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM emp_details");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+ " " +resultSet.getString(2)+ " " +resultSet.getString(3)+" " +resultSet.getInt(4)+" " +resultSet.getString(5)+" "+resultSet.getInt(6)+" "+resultSet.getString(7)+" "+resultSet.getString(8));
			}
			connection.close();
		}	
		catch (Exception obj)
		{	
			System.out.println(obj);
		}
	}
}
