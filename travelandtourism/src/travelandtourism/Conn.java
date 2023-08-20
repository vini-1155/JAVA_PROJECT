package travelandtourism;

import java.sql.*;

public class Conn {


	Connection c;
	Statement st;
	Conn(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///travelnmanagement","root","Mintu@115511"); //Connection
			st = c.createStatement(); // Creating the statemnt
			
		}catch(Exception e) {
			e.setStackTrace(null);
		}

	}

}
