package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCrud {

	    // Create
	    public void addUser(String name, String email, String country) {
	        String query = "INSERT INTO users (name, email, country) VALUES (?, ?, ?)";
	        try (Connection myConnection = MySQLDatabase.getConnection();
	             PreparedStatement myPreparedStatement = myConnection.prepareStatement(query)) {
	            if (myConnection == null) {
	                System.out.println("Connection to database failed!");
	                return;
	            }
	            myPreparedStatement .setString(1, name);
	            myPreparedStatement .setString(2, email);
	            myPreparedStatement .setString(3, country);
	            myPreparedStatement .executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Read
	    public List<InfoUser> getUsers() {
	        List<InfoUser> users = new ArrayList<>();
	        String query = "SELECT * FROM users";
	        try (Connection myConnection = MySQLDatabase.getConnection();
	             PreparedStatement myPreparedStatement = myConnection .prepareStatement(query);
	             ResultSet myResultSet = myPreparedStatement .executeQuery()) {
	            while (myResultSet.next()) {
	                int id = myResultSet.getInt("id");
	                String name = myResultSet.getString("name");
	                String email = myResultSet.getString("email");
	                String country = myResultSet.getString("country");
	                users.add(new InfoUser(id, name, email, country));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }

	    // Update
	    public void updateUser(int id, String name, String email, String country) {
	        String query = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?";
	        try (Connection myConnection = MySQLDatabase.getConnection();
	             PreparedStatement myPreparedStatement = myConnection.prepareStatement(query)) {
	            if (myConnection == null) {
	                System.out.println("Connection to database failed!");
	                return;
	            }
	            myPreparedStatement .setString(1, name);
	            myPreparedStatement .setString(2, email);
	            myPreparedStatement .setString(3, country);
	            myPreparedStatement .setInt(4, id);
	            myPreparedStatement .executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Delete
	    public void deleteUser(int id) {
	        String query = "DELETE FROM users WHERE id = ?";
	        try (Connection myConnection = MySQLDatabase.getConnection();
	             PreparedStatement myPreparedStatement = myConnection .prepareStatement(query)) {
	            if (myConnection  == null) {
	                System.out.println("Connection to database failed!");
	                return;
	            }
	            myPreparedStatement .setInt(1, id);
	            myPreparedStatement .executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


