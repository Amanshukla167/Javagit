package MavenDemo.com;

import java.sql.Connection;
import java.sql.*;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
	static  final String  Driver = "com.mysql.cj.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo";
	
	
	static final String  User = "root";
	static final String Password = "aman";
	
	
	
    public static void main( String[] args )throws Exception
    {
        System.out.println( "Hello World!" );
        System.out.println("you have publis to git repo");
        
        int emp_id = 104;
        String emp_name = "Anushree";
        int emp_age = 22;
        
        try {
        	 Class.forName(Driver);
             
             Connection connection = DriverManager.getConnection(URL, User, Password);
             
             System.out.println("connection stablize");
             
             String sql = "select * from employee";
             String sql2 =  "insert into employee values(?,?,?)";
             
             Statement statement = connection.createStatement();
             
             PreparedStatement statement2 =  connection.prepareStatement(sql2);
             statement2.setInt(1, emp_id);
             statement2.setString(2, emp_name);
             statement2.setInt(3, emp_age);
             
             
             
              ResultSet resultset =  statement.executeQuery(sql);
              
                statement2.execute();
              
              System.out.println("your query has been execute");
              
              System.out.println("");
              
            while(resultset.next()) {
            	 Integer ID = resultset.getInt(1);
                 String Name = resultset.getString(2);
                 Integer Age = resultset.getInt(3);
                 
                 
                 System.out.println("Id : " + ID+ " " + "Name :"+ " " + Name + " "+ "Age :" + Age);
            }
            System.out.println("");
            connection.close();
            System.out.println("your connection is closed");
            statement.close();
            System.out.println("your statement is get closed");
            resultset.close();
            System.out.println("your Resultset is get closed");
    
              
        }catch (SQLException e) {
			// TODO: handle exception
        	System.out.println("plese connect your Database.");
		}
     
    }
}
