package SQLTesting.SQLTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDataToMySql {
	public static void main(String[] args) throws Exception{
		Connection con = null;
		String dbUrl = "jdbc:mysql://localhost:3306/automationtesting?useSSL=true";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root1";
		String password = "root";
		
		Class.forName(driver).newInstance();
		con = DriverManager.getConnection(dbUrl, userName, password);
		
		System.out.println("Connection Established Succesfully");
		
		PreparedStatement ps = con.prepareStatement("INSERT into credentials(UserName,Password,DateCreated,NoOfAttempts,Result)VALUES('DemoUser','demo@123','2025-02-24','4','Pass')");
		ps.executeUpdate();
		
		con.close();
	}
}
