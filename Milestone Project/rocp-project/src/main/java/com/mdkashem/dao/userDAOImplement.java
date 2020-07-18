package com.mdkashem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			String sql = "SELECT * FROM Users";			// Our SQL query
			//String sql = "SELECT * FROM Users";			// Our SQL query
			stmt = connection.prepareStatement(sql);	// Creates the prepared statement from the query
			
			ResultSet rs = stmt.executeQuery();			// Queries the database

			// So long as the ResultSet actually contains results...
			while (rs.next()) {
				// We need to populate a User object with info for each row from our query result
				User user = new User();
				// Each variable in our User object maps to a column in a row from our results.
				user.setUserId(Integer.parseInt(rs.getString("userId")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAccountId(Integer.parseInt(rs.getString("accountId")));
				user.setRoleId(Integer.parseInt(rs.getString("roleId")));
				
			
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
		
		// return the list of users objects populated by the DB.
		return users;
	}

	public User getUserByName(String name) {
		User user=null;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM Users WHERE username LIKE ?";
			stmt = connection.prepareStatement(sql);
			// This command populate the 1st '?' with the title and wildcards, between ' '
						stmt.setString(1, "%" + name + "%");
			ResultSet rs =stmt.executeQuery();
			
			while(rs.next()){
				user=new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				
				user.setAccountId(Integer.parseInt(rs.getString("accountid")));
				user.setRoleId(Integer.parseInt(rs.getString("roleid")));
				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// We need to make sure our statements and connections are closed, 
			// or else we could wind up with a memory leak
			closeResources();
		}

		return user;
	}



	public User getUserByID(int id) {
		User user=null;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM Users WHERE userid = ?";
			stmt = connection.prepareStatement(sql);
			
						stmt.setInt(1, id);
			ResultSet rs =stmt.executeQuery();
			
			while(rs.next()){
				user=new User();
				user.setUserId(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAccountId(Integer.parseInt(rs.getString("accountid")));
				user.setRoleId(Integer.parseInt(rs.getString("roleid")));
				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// We need to make sure our statements and connections are closed, 
			// or else we could wind up with a memory leak
			closeResources();
		}

		return user;
	}

	public boolean addUser(User user) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO Users (userid,username, password, firstname, lastname, accountid ,roleid )  VALUES ( default, ?, ?, ?, ?, ?, ?)"; // Were using a lot of ?'s here...
			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
			
			// But that's okay, we can set them all before we execute
		
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setInt(5, user.getAccountId());
			
			stmt.setInt(6, user.getRoleId());
		
			
			
			// If we were able to add our book to the DB, we want to return true. 
			// This if statement both executes our query, and looks at the return 
			// value to determine how many rows were changed
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}

	public boolean updateUser(User user) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE users SET username=?, password=?, firstname=?, lastname=?, accountid=?, roleid=? WHERE userid=?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setInt(5, user.getAccountId());
			stmt.setInt(6, user.getRoleId());
			stmt.setInt(7, user.getUserId());
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
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
/*
 * 
 * This method return true if the user exist 
 * 
 * 
 * */
		public List<User>  findUser(String username, String password) {
			
			return null;
		}

		public List<User> getUserByEmail(String email) {
			// TODO Auto-generated method stub
			return null;
		}

		

		

}
