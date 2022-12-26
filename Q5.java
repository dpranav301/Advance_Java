package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Q5 {

	public static void main(String[] args) {
		int count=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kalyan?useSSL=false","root","sept22");
			PreparedStatement s=con.prepareStatement("select * from student");
			ResultSet rs=s.executeQuery();
			//ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next())
			{
				count++;
			}
			System.out.println("The number of record="+count);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

}
