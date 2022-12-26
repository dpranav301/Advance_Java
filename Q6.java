package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Q6 {
	private static ResultSet rs;
	private static Scanner sc;

	public static void main(String[] args) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kalyan?useSSL=false&allowPublicKeyRetrieval=true","root","sept22");
			PreparedStatement s = con.prepareStatement("select * from Student",
					ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = s.executeQuery();
			sc = new Scanner(System.in);
			boolean flag = true;
			do
			{
				System.out.println("0 to exit");
				System.out.println("1 to insert record");
				System.out.println("2 to update record");
				System.out.println("3 to delete record");
				byte ch=sc.nextByte();
				switch(ch)
				{
				case 0:
					flag=false;
					break;
				case 1:
					insertRec();
					break;
				case 2:
					updateRec();
					break;
				case 3:
					deleteRec();
					break;
				default:
					System.out.println("Wrong choice");
				}
			}while(flag);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	private static void insertRec() throws SQLException 
	{
		System.out.println("Enter rno");
		int rno = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter marks");
		float marks = sc.nextFloat();
		System.out.println("Enter dob");
		String dob = sc.next();
		rs.moveToInsertRow();
		rs.updateInt(1, rno);
		rs.updateString(2, name);
		rs.updateFloat(3, marks);
		rs.updateString(4, dob);
		
		rs.insertRow();
	
		rs.moveToCurrentRow();
	}
	private static void updateRec() throws SQLException 
	{
		System.out.println("Enter rno");
		int rno = sc.nextInt();
		boolean flag = false;
		rs.beforeFirst();
		while(rs.next()) 
		{
			if(rs.getInt(1)==rno)
			{
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter marks");
				float marks = sc.nextFloat();
				System.out.println("Enter dob");
				String dob = sc.next();
				
				rs.updateString(2, name);
				rs.updateFloat(3, marks);
				rs.updateString(4, dob);
				
				rs.updateRow();
				rs.moveToCurrentRow();
				flag = true;
				break;
			}
			if(!flag) 
			{
				System.out.println("record not found");
			}
		}
		
	}
	private static void deleteRec() throws SQLException 
	{
		System.out.println("Enter rno");
		int rno = sc.nextInt();
		boolean flag = false;
		rs.beforeFirst();
		while(rs.next()) {
			if(rs.getInt(1)==rno) {
				rs.deleteRow();
				rs.moveToCurrentRow();
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			System.out.println("record not found");
		}
	}

}
