package jdbc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.omg.IOP.TaggedComponentHelper;

public class JDBC5 {
	public static void main(String[] args) {
		try {
			Scanner scanner=new Scanner(System.in);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/office","root","umar25");
			
	/*		System.out.println("what  you want  to do into table");
			System.out.println("for insert press 1");
			System.out.println("for delete press 2");
			System.out.println("for table detail press 3");*/
			
			
			
			PreparedStatement psmt=con.prepareStatement("insert into off1 values(?,?,?)");
			
			 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
			while(true)
			{
				System.out.println("enter the no");
				int no=Integer.parseInt(br.readLine());
				
				System.out.println("enter the name");
				String name=br.readLine();
				
				System.out.println("enter the salary");
				double sal=Double.parseDouble(br.readLine());
				
				psmt.setInt(1,no);
				psmt.setString(2,name);
				psmt.setDouble(3,sal);
				
				
				int count=psmt.executeUpdate();
				if(count>0)
				System.out.println(count+"record inserted");

				else 
				System.out.println("no record inserted");
				
				System.out.println("due you want  maore record");
				String ch=br.readLine();
				if(ch.equalsIgnoreCase("no"))
					break;
				
			}
			System.out.println("do you want to update table yes/no");
			String s=scanner.next();
			while(s.equalsIgnoreCase("yes"))
			{
				System.out.println("what did you want change in you table no,name,sal ");
				String change=br.readLine();
				//update
				while(change.equalsIgnoreCase("no")) {
				PreparedStatement psm=con.prepareStatement("update off1 set no=? where name=?");
				
				System.out.println("enter the name where whose id you want to update ");
				String name=br.readLine();
				System.out.println("enter the changing no");
				int no=Integer.parseInt(br.readLine());
				
				psm.setInt(1,no);
				psm.setString(2,name);
				
				int i=psm.executeUpdate();
				System.out.println(i+"sucessfull");
				System.out.println("do you want more update in id");
				String no1=scanner.next();
				if(no1.equalsIgnoreCase("no"))
					break;
			
			}//no  while loop close
				while(change.equalsIgnoreCase("name")) {
					PreparedStatement psm=con.prepareStatement("update off1 set name=? where no=?");
					
					System.out.println("enter the id where whose name you want to update ");
					int no=Integer.parseInt(br.readLine());
				
					System.out.println("enter the changing name");
					String name=br.readLine();
					
					psm.setString(1,name);
					psm.setInt(2,no);
					
					int i=psm.executeUpdate();
					System.out.println(i+"sucessfull");
					System.out.println("do you want more update in name");
					String name1=scanner.next();
					if(name1.equalsIgnoreCase("no"))
						break;
		
				System.out.println("do you want more update");
				String str=scanner.next();
				if(str.equalsIgnoreCase("no"))
					break;
			
		}//name loop close
				while(change.equalsIgnoreCase("sal")) {
					PreparedStatement psm=con.prepareStatement("update off1 set sal=? where name=?");
					
					System.out.println("enter the name where whose salary  you want to update ");
					String name=br.readLine();
					System.out.println("enter the changing sal");
					int sal=Integer.parseInt(br.readLine());
					
					psm.setInt(1,sal);
					psm.setString(2,name);
					
					int i=psm.executeUpdate();
					System.out.println(i+"sucessfull");
					System.out.println("do you want more update in salary");
					String sal1=scanner.next();
					if(sal1.equalsIgnoreCase("no"))
						break;
				}//sal loop close
			}	
				System.out.println("do you want to delete any entry into table, write  yes/no");
				PreparedStatement psmt1=con.prepareStatement("delete from off1 where no=?");
				String yes=scanner.next();
				while(yes.equalsIgnoreCase("yes"))
				{
					System.out.println("enter the no which entry you want to delete into table");
					int no=Integer.parseInt(br.readLine());
					psmt.setInt(1,no);
					int a=psmt.executeUpdate();
					System.out.println(a+"successfull");
					System.out.println("do you want more deleting task, write yes/no");
					String delt=scanner.next();
					if(delt.equalsIgnoreCase("no"))
					{
						break;
					}
				}
				
				PreparedStatement stmt=con.prepareStatement("select * from off1");
				System.out.println("do you want to check your table detail, write yes/no");
				String cktable=scanner.next();
				while(cktable.equalsIgnoreCase("yes"))
				{
					ResultSet rs=stmt.executeQuery();  
				while(rs.next()){  
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));  
					System.out.println(rs+"successfull");
				}
					break;
				
				}

				
				System.out.println("do you want more update");
				String str=scanner.next();
				if(str.equalsIgnoreCase("no"))
					break;
			
		}
	
			
			System.out.println("sucessfull");
			con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
}
