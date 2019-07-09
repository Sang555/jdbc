import java.sql.*;
import java.util.Scanner;
public class DynamicJava {
	public static void main(String[] args)
	{
		
		try {
			Scanner scanner=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Sapient123");			
			PreparedStatement preparedStatement=connection.prepareStatement("insert into emp values(?,?)");
			String name=scanner.nextLine();
			preparedStatement.setString(1, name);
			int age=scanner.nextInt();
			preparedStatement.setInt(2, age);
			Statement statement= connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from emp");
			while(rs.next())
			{
				System.out.println("name: "+rs.getString(1));
				System.out.println("Age: "+rs.getString(2) );
			}
			rs.close();
			statement.close();
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
