package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase {
	

	    private static final String url = "jdbc:mysql://localhost:3306/crud_example";
	    private static final String userName = "root";
	    private static final String password = "Uncharted4455"; // Replace with your MySQL password

	    public static Connection getConnection() {
	        Connection myConnection = null;
	        try {
	        	myConnection = DriverManager.getConnection(url, userName, password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return myConnection;
	    }
	}


