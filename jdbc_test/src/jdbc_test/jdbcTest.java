package jdbc_test;
import java.sql.*;
import javax.sql.*;

public class jdbcTest {
	jdbcTest(){
	}
	public static void main(String[] args)throws SQLException{
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		try {
			String s="jdbc:mysql://localhost:3306/sakila";
			myConn= DriverManager.getConnection(s,"student","student");
			System.out.println("DB connection successful\n");
			myStmt=myConn.createStatement();
			String q="select * from actor";
			myRs=myStmt.executeQuery(q);
			while(myRs.next()) {
				System.out.println(myRs.getString("first_name"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
