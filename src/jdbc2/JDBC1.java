package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.jws.soap.SOAPBinding.Use;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
import com.mysql.cj.xdevapi.Schema.CreateCollectionOptions;

//import com.mysql.cj.x.protobuf.MysqlxConnection.Close;


public class JDBC1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/office","root","umar25");
	
			
			
			Statement smt=con.createStatement();
			String a="create table off1(no int(11), name varchar(11), sal int(11))";
			smt.execute(a);
			
			System.out.println("connection successfull......");
			con.close();
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}


}


