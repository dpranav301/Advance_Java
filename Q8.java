package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q8 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kalyan?useSSL=false","root","sept22");
			PreparedStatement s=con.prepareStatement("select avg(marks) from student");
			ResultSet rs=s.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getFloat(1));
			}
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

}
