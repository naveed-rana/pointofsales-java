package pointofsale;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectDb {

	public static final String USERNAME = "scott";
	public static final String PASSWORD = "ranalove1214";
	public static final String CONN_STRING = 
			"jdbc:mysql://localhost/point_of_sale_system";
	
	   public Connection getConnection()
	    {
	        Connection con=null;
	        try
	        {
	        Class.forName("com.mysql.jdbc.Driver");
	        con=DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
	      
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }

	        return con;        
	    }

}
