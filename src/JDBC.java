	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;

public class JDBC {
	public static void main(String[] args) {
			try  
			{	
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employe","root","umar25");
				//here umar is database name,		
				
				Statement smt=con.createStatement();
				String a="employe";
				smt.execute("use "+a);
				//smt.execute("create table emp( no int(11) ,name varchar(12) ,sal int(11) )";
				String wa="CREATE TABLE emp(id int(22), name varchar(45))";
				smt.execute(wa);
				//smt.executeUpdate("insert into sinfo values(1111,'normal','india','c+++' )");				
				System.out.println("table made succesfully");
				con.close();		
			} 
			catch (Exception e) {
				//System.out.println(e);
			e.printStackTrace();
			}
		}
}
