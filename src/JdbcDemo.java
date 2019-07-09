import java.sql.*;
public class JdbcDemo {
	
	
	public static void main(String[] args)
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Sapient123");
			Statement statement= connection.createStatement();
			statement.executeUpdate("insert into emp values('tash',21)");
			statement.executeUpdate("delete from emp where age>30");
			statement.executeUpdate("update emp set age=age+1");
			ResultSet rs=statement.executeQuery("select * from emp");
			while(rs.next())
			{
				System.out.println("name: "+rs.getString(1));
				System.out.println("Age: "+rs.getString(2) );
			}
			rs.close();
			statement.close();
			
					
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
