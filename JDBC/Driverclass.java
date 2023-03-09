package JDBC;

import java.sql.*;
import java.util.Scanner;

public class Driverclass {
	private static Scanner scan = new Scanner(System.in);
	public static Connection createConnection() {
		Connection connection = null;
		try {
			String userName = "root";
			String password = "Radhamani@98";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Laptop_Management", userName, password);
			Statement stmt = connection.createStatement();
		}
		catch(Exception obj) {
			System.out.println(obj);
		}
		return connection;
	}
	public static void toAccessConnection() throws SQLException, Exception{
		Connection databaseConnection = createConnection();
		LaptopDatabaseConnection laptopobj = new LaptopDatabaseConnection();
		Scanner scan = new Scanner(System.in); //get input from user
		//to display menu
		System.out.println("1. Add a Laptop");
		System.out.println("2. Display all Number of laptop");
		System.out.println("3. search an Modelnumber");
		System.out.println("4. Delete an Soldgoods");
		System.out.println("5. update an Newstock");
		System.out.println("6. Logout");

		byte enterChoice; 
		do{ 
			// switch cases
			enterChoice = scan.nextByte();
			switch(enterChoice) {
			case 1:
				laptopobj.toAddValues(databaseConnection);
				break;
			case 2:
				laptopobj.toDisplayAll(databaseConnection);
				break;
			case 3:
				laptopobj.toSearchById(databaseConnection);
				break;
			case 4:
				laptopobj.toDeleteById(databaseConnection);
				break;
			case 5:
				laptopobj.toUpdateById(databaseConnection);
				break;

			case 6:
				LaptopBlueprint.tologout();
				break;
			}
		}while(enterChoice !=6);
		scan.close();
	}
	public static void main(String args[]) throws SQLException, Exception {
		System.out.print("Enter user name: ");
		String username = scan.next();
		System.out.print("Enter Password: ");
		String password = scan.next();
		LaptopBlueprint.tologin(username, password);

	}
}


