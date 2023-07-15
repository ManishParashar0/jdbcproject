package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC4 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/office","root","umar25");
			
			PreparedStatement psmt=con.prepareStatement("delete from off1 where no=?");
			psmt.setInt(1,43);
			int a=psmt.executeUpdate();
			System.out.println(a+"successfull");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
