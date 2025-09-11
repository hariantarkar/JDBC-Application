package hari.code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class crudapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbcapp","root","root");
		if(conn!=null) {
			System.out.println("Database is connected");
			Statement stmt=conn.createStatement();
		int value=stmt.executeUpdate("insert into employee values('ram','ram@gmail.com','1234567891')");
		if(value>0) {
			System.out.println("Record Save successfully......");
		}
		else {
			System.out.println("Some problem is there...........");
		}
		}
		else {
			System.out.println("Database is not connected");
		}
	}
}
