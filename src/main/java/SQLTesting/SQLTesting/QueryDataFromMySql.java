package SQLTesting.SQLTesting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class QueryDataFromMySql {
	public static void main(String[] args) throws Exception{
		Connection con = null;
		String dbUrl = "jdbc:mysql://localhost:3306/automationtesting?useSSL=true";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root1";
		String password = "root";
		
		Class.forName(driver).newInstance();
		con = DriverManager.getConnection(dbUrl, userName, password);
		
		System.out.println("Connection Established Succesfully");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from credentials");
		
		while(rs.next()) {
			System.out.println("UserNames: "+ rs.getString("UserName")+"---"+("Passwords: "+ rs.getString("Password")+"---"+("DateCreated: "+ rs.getString("DateCreated")+"---"+("NoOfAttempts: "+ rs.getString("NoOfAttempts")+"---"+("Result: "+ rs.getString("Result"))))));
		}
		rs.close();
	}
}
