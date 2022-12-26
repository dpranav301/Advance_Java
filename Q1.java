package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Q1 
{

	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kalyan?useSSL=false","root","sept22");
			Statement s = con.createStatement();
			boolean flag = s.execute("create table Student(rno int primary key,name varchar(25),marks float(10,2),dob date)");
			System.out.println(flag);
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
		
		
	}

}
