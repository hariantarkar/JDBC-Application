package hari.prop.code;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ReaddotPropFile {

	public static void main(String[] args)throws Exception {
		
		
		File f= new File("");
		
		  //FileInputStream  fis=new FileInputStream(f.getAbsolutePath()+"C:\\JDBCCSV\\config.properties");
		
		FileInputStream fis = new FileInputStream("C:\\JDBCCSV\\config.properties");
		
		
		
		
		

		  
		  Properties p=new Properties();
		  
		  p.load(fis);
		  
		  String username=p.getProperty("uname");
		  String userpass=p.getProperty("upass");
		  String url=p.getProperty("url");
		  String driverclassName=p.getProperty("driverName");
		  
		Class.forName(driverclassName);
		
		  
		Connection conn=DriverManager.getConnection(url,username,userpass);
		
		if(conn!=null)
		{
			System.out.println("database connect");
		}
		else
		{
			System.out.println("database not connect");
			
		}
		
	}

}

