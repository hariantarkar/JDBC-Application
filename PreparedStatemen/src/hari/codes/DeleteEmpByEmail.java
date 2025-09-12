package hari.codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DeleteEmpByEmail {
public static void main(String[] args)throws Exception  {
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbcapp", "root", "root");

	if (conn != null)
	{
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter employee  email:");

			String email = sc.nextLine();
			PreparedStatement ps = conn.prepareStatement("delete from employee where email=?");
			ps.setString(1,email);
			int  rowsAffected=ps.executeUpdate();
			
			
			if(rowsAffected > 0)
			{
				System.out.println("Deleted success");

			}
			else
			{
				System.out.println("you enter email invalid");
			}
	}
	else
	{
		System.out.println("Database not connect");
	}
	
}
}
