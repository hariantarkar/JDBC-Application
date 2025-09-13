package hari.codes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
public class UpdateEmp {
public static void main(String[] args)throws Exception  {
	
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbcapp","root","root");
	
	if(conn!=null)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee current email which employee name update  ");
		System.out.println("enter  employee new name");
		String name=sc.nextLine();
		String email=sc.nextLine();
		
		PreparedStatement ps = conn.prepareStatement("update employee set name=? where email=?");

		ps.setString(1,name);
		ps.setString(2, email);
		
		int value=ps.executeUpdate();
		if(value > 0)
		{
			System.out.println("data updated ");
		}
		else
		{
			System.out.println("data not update ");
			
		}
	}
	else
	{
		System.out.println("Dtabase not connect");
	}
	
}
}
