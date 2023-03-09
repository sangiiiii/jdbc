package JDBC;

import java.sql.*;

public class LaptopBlueprint {

	private String brandName;
	private int laptop_id;
	private int price;
	private String storage;
	private String colour;
	private String edition;
	private static String userName = "Room2";
	private static String passWord = "Welcome";

	public String getBrandName() {    //getter method to get the values
		return brandName;
	}
	public void setBrandname(String brandName) {   //setter method to put the values
		this.brandName=brandName;
	}
	public int laptop_id() {
		return laptop_id;
	}
	public void laptop_id(int laptop_id) {
		this.laptop_id=laptop_id;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage=storage;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour=colour;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition=edition;
	}

	public static void tologin(String username, String password)throws SQLException, Exception {

		if(userName.equals(username) && passWord.equals(password)){
			Driverclass.toAccessConnection();
		}
		else {
			System.out.println("check your credentials");
		}

	}
	public static void tologout() {
		System.out.println("Logged out Successfully");
	}
}


