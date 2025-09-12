
package hari.codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStatements {

    public static void main(String[] args) throws Exception {

      
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbcapp", "root", "root");

        if (conn != null) {
            Scanner sc = new Scanner(System.in);
             System.out.println("Enter employee name and email:");
            String name = sc.nextLine();
            String email = sc.nextLine();
          
            PreparedStatement ps = conn.prepareStatement("INSERT INTO employee(name ,email) VALUES (?,?)");
            ps.setString(1, name);
            ps.setString(2, email);

            int value = ps.executeUpdate();
            if (value > 0) {
                System.out.println("Record Saved");
            } else {
                System.out.println("Record Not Saved");
            }
            

            sc.close();
            ps.close();
            conn.close();
        } else {
            System.out.println("Database is not connected");
        }
    }
}


