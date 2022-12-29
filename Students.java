package schoolSql;

//import java.beans.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class Students {
	public static void menueFunction() {
		System.out.println("1:craete student table");
		System.out.println("2:craete subject table");
		System.out.println("3:top 10 students");
		System.out.println("4:top 15 students");
		System.out.println("5:ADD NEW STUDENT");
		System.out.println("6:ADD NEW SUBJECT");
		System.out.println(" 7: Exit App");

	}
	public static boolean addingStudentTable() {
	String url = "jdbc:mysql://localhost:3306/SchoolMgt";
	//String url = "jdbc:mysql://localhost:3306/stu_sql";
	String username = "root";
	String password = "root";
	 //Scanner sc = new Scanner(System.in);
	 String sqlDB = "CREATE TABLE Students " + "(id INTEGER not NULL, " + " fname VARCHAR(8), "
				+ " lname VARCHAR(8), " + " birthdate date, " + " PRIMARY KEY ( id ))";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url,username, password);
			Statement st = conn.createStatement();
			int m = st.executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		return false;
	
}

	public static boolean addingSubjectTable() {
		
		String url = "jdbc:mysql://localhost:3306/SchoolMgt";
		//String url = "jdbc:mysql://localhost:3306/stu_sql";
		String username = "root";
		String password = "root";
		// Scanner sc = new Scanner(System.in);
		 String sub = "CREATE TABLE Subject " 
		 + "(id INTEGER not NULL, " 
		 + " title  varchar(8),"
		 + " descc varchar(250)," 
		 +" pricePerStudent decimal)";
			Connection conn = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection(url,username, password);
				Statement st = conn.createStatement();
				int m = st.executeUpdate(sub);
				if (m >= 1) {
					System.out.println("Created table in given database...");
					return true;
				} else {
					System.out.println(" table already Created in given database...");
				}
				conn.close();
			}
			catch (Exception ex) {
				System.err.println(ex);
			}
			return false;
		
	}
	public static void topten() {
		String sql="SELECT * FROM Students ORDER BY id LIMIT 100;";
	}
	public static void topFifteen() {
		String sql="SELECT * FROM Subject ORDER BY id LIMIT 15;";
	}
	
	public static void addNewStudent() {
		String url = "jdbc:mysql://localhost:3306/SchoolMgt";
		//String url = "jdbc:mysql://localhost:3306/stu_sql";
		String username = "root";
		String password = "root";
		 try(Connection conn = DriverManager.getConnection( url, username, password );
		         Statement stmt = conn.createStatement();
		      ) {		      
			 String sql = "CREATE DATABASE STUDENTS";
	         stmt.executeUpdate(sql);
	         System.out.println("Database created successfully...");   	  
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      } 
	public static void addNewSubject() {
		String url = "jdbc:mysql://localhost:3306/SchoolMgt";
		//String url = "jdbc:mysql://localhost:3306/stu_sql";
		String username = "root";
		String password = "root";
		 try(Connection conn = DriverManager.getConnection( url, username, password );
		         Statement stmt = conn.createStatement();
		      ) {		      
		         // Execute a query
		         System.out.println("Inserting records into the table...");          
		         String sql = "INSERT INTO Registration VALUES (1, 'java', 'Ali', 20)";
		         stmt.executeUpdate(sql);
		         stmt.executeUpdate(sql);
		         System.out.println("Inserted records into the table...");   	  
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	}
	
	public static void exit() {
		System.out.println("**************");
		System.out.println("Thank You");
		System.exit (0);
		System.out.println("**************");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 boolean hasExit=true;
		do{
			menueFunction();
			int select = sc.nextInt();

			switch (select) {

			case 1:
				
		 addingStudentTable();
				
		 break;
			case 2:
		 addingSubjectTable();
		 break;
			case 3:
		 topten();
		 break;
			case 4:
		 topFifteen();
		 break;
			case 5:
				addNewStudent();
				break;
			case 6:
				addNewSubject();
				break;
			case 7:
				exit();
				break;
			}
	}while (hasExit); 
}
}