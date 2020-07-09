package com.mdkashem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mdkashem.model.Role;
import com.mdkashem.model.User;
import com.mdkashem.utilities.DAOUtilities;

public class userDAOImplement implements userDAO{
	Connection connection = null;	// Our connection to the database
	PreparedStatement stmt = null;	// We use prepared statements to help protect against SQL injection
	
	/*------------------------------------------------------------------------------------------------*/

	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();

		try {
			connection = DAOUtilities.getConnection();	// Get our database connection from the manager
			String sql = "SELECT Role.roleId, Role.role, Users.userId, Users.username, Users.password, Users.firstName, Users.lastName, Users.email  FROM Role INNER JOIN Users ON Role.roleId = Users.roleId";			// Our SQL query
			//String sql = "SELECT * FROM Users";			// Our SQL query
			stmt = connection.prepareStatement(sql);	// Creates the prepared statement from the query
			
			ResultSet rs = stmt.executeQuery();			// Queries the database

			// So long as the ResultSet actually contains results...
			while (rs.next()) {
				// We need to populate a User object with info for each row from our query result
				User user = new User();
				Role role = new Role();
				role.setRoleId(Integer.parseInt(rs.getString("roleId")));
				role.setRole(rs.getString("role"));
				// Each variable in our User object maps to a column in a row from our results.
				user.setUserId(Integer.parseInt(rs.getString("userId")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				
				
				
				user.setRole(role);
			
				// Finally we add it to the list of Book objects returned by this query.
				users.add(user);
				
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// We need to make sure our statements and connections are closed, 
			// or else we could wind up with a memory leak
			closeResources();
		}
		
		// return the list of Book objects populated by the DB.
		return users;
	}

	public List<User> getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getBooksLessThanPrice(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUserByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	// Closing all resources to prevent memory leaks. 
		// Ideally, you really want to close them in the reverse-order you open them
		private void closeResources() {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				System.out.println("Could not close statement!");
				e.printStackTrace();
			}
			
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.out.println("Could not close connection!");
				e.printStackTrace();
			}
		}

}
