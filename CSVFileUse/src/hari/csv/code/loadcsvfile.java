package hari.csv.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class loadcsvfile {

	public static void main(String[] args) throws Exception{


		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbcapp","root","root");
		
		if(conn!=null)
		{
			FileReader fr=new FileReader("C:\\JDBCCSV\\employee.csv");
			
			BufferedReader br=new BufferedReader(fr);
			
			String  data;
			int count=0;
			while((data=br.readLine())!=null)
			{
			
			
				String cols[]=data.split(",");
				System.out.println(cols[0]+"\t"+cols[1]);
				   
				PreparedStatement ps=conn.prepareStatement("insert into employee (name,email) values(?,?)");
				
			
				ps.setString(1,cols[0]);
				ps.setString(2,cols[1]);
				
				ps.executeUpdate();
				count++;
				
				
			}
			System.out.println(count+"   rows data inserted success");

			
		}
		else
		{
			System.out.println("database not connect");
		}
		

	}

}









