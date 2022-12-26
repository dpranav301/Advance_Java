package pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Q11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the roll number");
		int rno=sc.nextInt();
		System.out.println("Enter the Name");
		String name=sc.next();
		System.out.println("Enter the marks");
		float marks=sc.nextFloat();
		System.out.println("Enter dob");
		String dob=sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kalyan?useSSL=false","root","sept22");
			CallableStatement s = con.prepareCall("{ call insert1(?,?,?,?) }");
			s.setInt(1, rno);
			s.setString(2, name);
			s.setFloat(3,marks);
			s.setString(4, dob);
			int i=s.executeUpdate();
			System.out.println("No of rows affected="+i);
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
