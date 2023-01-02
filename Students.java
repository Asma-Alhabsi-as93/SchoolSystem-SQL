package schoolSql;

//import java.beans.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class Students {
	public static void menueFunction() {
		System.out.println("1:craete student table");
		System.out.println("2:craete subject table");
		System.out.println("3:List Top 100 Students ");
		System.out.println("4:List Top 50 Students");
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
	 ;
	 String insert ="Insert into Students values (1,'abeer','kulaibi','1999-10-10'),"
	 		+ "(2,'salim','salim','1996-11-18'),"
	 		+ "(3,'hameed','habsi','1989-03-09'),"
	 		+ "(4,'mazin','mosawi','1996-11-18'),"
	 		+ "(5,'ruqia','mahroogi','1997-05-16'),"
	 		+ "(6,'muhammed','hamdani','1994-04-08'),"
	 		+ "(7,'sumaia','kasbi','2000-03-18'),"
	 		+ "(8,'kalid','jahdhami','1996-11-18'),"
	 		+ "(9,'samy','salami','1996-12-18'),"
	 		+ "(10,'khulood','jahdhami','1996-11-18'),"
	 		+ "(11,'humaid','habsi','2017-10-06'),"
	 		+ "(12,'omar','mawali','2009-03-09'),"
	 		+ "(13,'azzan','habsi','2018-12-08')";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url,username, password);
			Statement st = conn.createStatement();
			
			int m = st.executeUpdate(sqlDB);
			int l = st.executeUpdate(insert);
			if ((m >= 0) && (l >= 1)){
				System.out.println("Created table in given database...");
				System.out.println("inserted Successfully...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
				System.out.println("insertion failed...");
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
		
		  String sub = "CREATE TABLE Subject " + "(id INTEGER not NULL, " +
		  " title  varchar(8)," + " descc varchar(250)," +" pricePerStudent decimal)";
		 
		 
		 String insert ="Insert into subject values(1,'math','mathmatic',5.5),"
		 		+ "(2,'since','since',9.8),"
		 		+ "(3,'java','programm',3.9),"
		 		+ "(4,'arabic','languge',5.7),"
		 		+ "(5,'english','languge',7.9),"
		 		+ "(6,'it','programm',9.9),"
		 		+ "(7,'skills','skills',1.6),"
		 		+ "(8,'sycology','sycology',3.4),"
		 		+ "(9,'busness','business',3.4),"
		 		+ " (10,'hr','hr',3.4)";
			Connection conn = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection(url,username, password);
				Statement st = conn.createStatement();
				 int m = st.executeUpdate(sub);
				int n = st.executeUpdate(insert);
				if ((m >= 0) &&(n >= 1)){
					 System.out.println("Created table in given database..."); 
					System.out.println("inserted Successfully...");
					return true;
				} else {
					 System.out.println(" table already Created in given database..."); 
					System.out.println("insertion failed...");
				}
				conn.close();
			}
			catch (Exception ex) {
				System.err.println(ex);
			}
			return false;
		
	}
	public static void  Top100Students () {
		String url = "jdbc:mysql://localhost:3306/SchoolMgt";
		//String url = "jdbc:mysql://localhost:3306/stu_sql";
		String username = "root";
		String password = "root";
		String tenl="SELECT * FROM Students ORDER BY id LIMIT 100;";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url,username, password);
			Statement st = conn.createStatement();
			ResultSet m = st.executeQuery(tenl);
			 while(m.next()){
		            //Display values
		            System.out.print("ID: " + m.getInt("id"));
		            System.out.print(", FirstName: " + m.getString("fname"));
		            System.out.print(", LastName: " + m.getString("lname"));
		            System.out.println(", BirthDate: " + m.getString("birthdate"));
			 }
			
			conn.close();
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		
	}
	
	public static void Top50Students () {
	String url = "jdbc:mysql://localhost:3306/SchoolMgt";
	//String url = "jdbc:mysql://localhost:3306/stu_sql";
	String username = "root";
	String password = "root";
	String tenl="SELECT * FROM Students ORDER BY id LIMIT 50;";
	Connection conn = null;
	try {
		Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url,username, password);
		Statement st = conn.createStatement();
		ResultSet m = st.executeQuery(tenl);
		 while(m.next()){
	            //Display values
	            System.out.print("ID: " + m.getInt("id"));
	            System.out.print(", FirstName: " + m.getString("fname"));
	            System.out.print(", LastName: " + m.getString("lname"));
	            System.out.println(", BirthDate: " + m.getString("birthdate"));
		 }
		
		conn.close();
	}
	catch (Exception ex) {
		System.err.println(ex);
	}
	
}
	public static void addNewStudent() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/SchoolMgt";
		//String url = "jdbc:mysql://localhost:3306/stu_sql";
		String username = "root";
		String password = "root";
		 try(Connection conn = DriverManager.getConnection( url, username, password );
		         Statement stmt = conn.createStatement();
		      ) {	
			 Scanner scanner = new Scanner(System.in);

			 
			 System.out.println("enter ID no");
		        Integer id = scanner.nextInt();
		        
		        
		        System.out.println("enter First name");
		        String fName = scanner.next();
		        System.out.println("enter Last name");
		        String lName = scanner.next();
		        

		        System.out.println("enter Birthdate");
		        String bDay = scanner.next();
		        
		        
			 String sql = "INSERT INTO STUDENTS VALUES (" + id + ",'"+fName+"','" + lName+"','"+bDay+"')";
	       
	         int m = stmt.executeUpdate(sql);
	            if (m >=  1) 
	                System.out.println(
	                        "inserted successfully : " + sql);
	            else 
	                System.out.println("insertion failed");
	                
	            
	      } 
		 }
	public static void addNewSubject() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/SchoolMgt";
		//String url = "jdbc:mysql://localhost:3306/stu_sql";
		String username = "root";
		String password = "root";
		 try(Connection conn = DriverManager.getConnection( url, username, password );
		         Statement stmt1 = conn.createStatement();
		      ) {	
			 Scanner scanner = new Scanner(System.in);

			 
			 System.out.println("enter ID no");
		        Integer id = scanner.nextInt();
		        
		        
		        System.out.println("enter Titel");
		        String title = scanner.next();
		        
		        System.out.println("enter descc name");
		        String descc = scanner.next();
		        

		        System.out.println("enter price pre student");
		        float pPS = scanner.nextFloat();
		        
		        
			 String sql = "INSERT INTO SUBJECT VALUES (" + id + ",'"+title+"','" + descc+"','"+pPS+"')";
	       
	         int m = stmt1.executeUpdate(sql);
	            if (m >=  1) 
	                System.out.println(
	                        "inserted successfully : " + sql);
	            else 
	                System.out.println("insertion failed");
	                
	            
	      } 
		 }
	
	public static void exit() {
		System.out.println("**************");
		System.out.println("Thank You");
		System.exit (0);
		System.out.println("**************");
	}
	public static void main(String[] args) throws SQLException {
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
				Top100Students ();
		 break;
			case 4:
				Top50Students ();
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