package hari.code;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class crudapp {
	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
				String URL="jdbc:mysql://localhost:3307/jdbcapp";
				String USERNAME = "root";
				String PASSWORD = "root";
			
				try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
				    System.out.println("Database is connected");

				    try (Statement stmt = conn.createStatement()) {

				        int value = stmt.executeUpdate("insert into employee values('0','ganu','ganu@gmail.com')");
				        if (value > 0) {
				            System.out.println("Record saved successfully......");
				        }				        
				    } catch (SQLException e) {
				        System.out.println("SQL error statment: " + e.getMessage());
				    }

				} catch (SQLException e) {
				    System.out.println("Database connection failed: " + e.getMessage());
				}


			}

		}

