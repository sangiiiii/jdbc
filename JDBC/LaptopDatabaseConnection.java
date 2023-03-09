package JDBC;

import java.sql.*;
import java.util.Scanner;

public class LaptopDatabaseConnection {
	private static Scanner scan = new Scanner(System.in);

	public void toAddValues(Connection connection) throws SQLException,Exception {
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Laptop_Details  values(?,?,?,?,?,?)");
		System.out.println("Enter the values that you want to add");
		pstmt.setString(1,scan.next());
		pstmt.setInt(2,scan.nextInt());
		pstmt.setInt(3,scan.nextInt());
		pstmt.setString(4,scan.next());
		pstmt.setString(5,scan.next());
		pstmt.setString(6,scan.next());
		int noOfRecordsInserted = pstmt.executeUpdate();
	}
	public void toDisplayAll(Connection connection) throws SQLException,Exception{
		Statement stmt = connection.createStatement();
		ResultSet resultSet= stmt.executeQuery("SELECT * FROM Laptop_Details");
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2)+ " "+ resultSet.getInt(3) +" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6));

		}
	}

	public void toSearchById(Connection connection) throws SQLException, Exception  {
		PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Laptop_Details WHERE laptop_id = ? ");
		System.out.println("Enter the ID you want to search: ");
		int id = scan.nextInt();
		pstmt.setInt(1,id);
		ResultSet resultSet = pstmt.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2) + " "+ resultSet.getInt(3) +" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6));

		}		
	}
	public void toDeleteById(Connection connection) throws SQLException,Exception {
		PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Laptop_Details WHERE laptop_id = ? ");
		System.out.println("Enter the ID you want to delete: ");
		int lap_id= scan.nextInt();
		pstmt.setInt(1,lap_id);
		int resultSet = pstmt.executeUpdate();
		System.out.println(resultSet);
	}
	public void toUpdateById(Connection connection) throws SQLException,Exception {
		System.out.println("Enter the record no to be update");
		int laptop_id = scan.nextInt();
		System.out.println("Enter the price to be updated");
		int price = scan.nextInt();
		PreparedStatement pstmt = connection.prepareStatement("UPDATE Laptop_Details SET price = ? where laptop_id =? ");
		pstmt.setInt(1,price);
		pstmt.setInt(2,laptop_id);
		int noOfRecordsUpdated = pstmt.executeUpdate();
	}



}



