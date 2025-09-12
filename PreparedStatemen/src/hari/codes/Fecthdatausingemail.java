package hari.codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Fecthdatausingemail {
public static void main(String[] args) throws Exception {
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbcapp", "root", "root");

	if (conn != null)
	{
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter employee  email:");

			String email = sc.nextLine();
			PreparedStatement ps = conn.prepareStatement("select id, name,email from employee where email=?");
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("email"));

			}
			else
			{
				System.out.println("you enter email invalid");
			}
}
}
}

