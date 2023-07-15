package com.AdminProject1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.AdminProject.*;
public class BeanController {
	public static void main(String[] args) {
	   Bean bean=new Bean();
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Admins","root","umar25");
			PreparedStatement psmt=con.prepareStatement("insert into Admin values(?,?,?,?,?)");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println("enter the no");
				int no=Integer.parseInt(br.readLine());
				bean.setId(no);
				
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
			
			
			System.out.println("sucessfull");
			con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	   
	
}
