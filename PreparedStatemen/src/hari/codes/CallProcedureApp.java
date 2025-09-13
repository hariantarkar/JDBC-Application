package hari.codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class CallProcedureApp {

	public static void main(String[] args)throws Exception {
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbcapp","root","root");
		
		if(conn !=null)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter name and email");
			String name=sc.nextLine();
			String email=sc.nextLine();
			
			 CallableStatement cs=(CallableStatement) conn.prepareCall("{call employeepro(?,?)}");

			cs.setString(1, name);
			cs.setString(2, email);
			
			boolean b=cs.execute();
			
			if(!b)
			{
				System.out.println("procedure excuted");
			}
			else
			{
				System.out.println("procedure not excuted ");
			}
		}
		else
		{
		System.out.println("Database not connect");
		}
		
		
	}

}
