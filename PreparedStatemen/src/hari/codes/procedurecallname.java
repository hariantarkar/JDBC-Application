package hari.codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class procedurecallname {
public static void main(String[] args)throws Exception  {
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbcapp","root","root");
	
	if(conn !=null)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter  email");
		
		String email=sc.nextLine();
		
		 CallableStatement cs=(CallableStatement) conn.prepareCall("{call getemployeenamebyemail(?,?)}");

		cs.registerOutParameter(1, Types.VARCHAR);
		cs.setString(2,email);
		
		boolean b=cs.execute();
		
		if(!b)
		{
			String name=cs.getString(1);
			
			System.out.println("procedure value : "+name);
			
		}
		else
		{
			System.out.println("procedure not execute");
		}
		
	}
	else
	{
	System.out.println("Database not connect");
	}
}
}
