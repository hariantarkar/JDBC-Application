package hari.codes;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FecthAllData 
{
    
	public static void main(String[] args) throws Exception
	{
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbcapp", "root", "root");

	        if (conn != null) {
	            Scanner sc = new Scanner(System.in);
					 PreparedStatement ps = conn.prepareStatement("select *from employee");
			            
			            ResultSet rs=ps.executeQuery();
			            while(rs.next())
			            {
			            	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			            	
			            }
	        }
	        else
	        {
	        	System.out.println("data not available");
	        }
			
	}
}


