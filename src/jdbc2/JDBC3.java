package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/office","root","umar25");
			
			PreparedStatement psmt=con.prepareStatement("update off1 set name=? where no=?");
			psmt.setString(1,"sorry");
			psmt.setInt(2,343);
			
			int i=psmt.executeUpdate();
			System.out.println(i+"sucessfull");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
