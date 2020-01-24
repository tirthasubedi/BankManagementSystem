package BankManagementSystem;
import java.sql.*;

public class conn {
	Connection c;
	Statement s;
	
	public conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///bankingsystem", "root",""); //Database URL, Username, and password
			s = c.createStatement();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
