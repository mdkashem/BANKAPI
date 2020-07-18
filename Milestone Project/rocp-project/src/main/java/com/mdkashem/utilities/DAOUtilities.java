package com.mdkashem.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mdkashem.dao.AccountDAO;
import com.mdkashem.dao.AccountDAOImpl;
import com.mdkashem.dao.AccountTypeDAO;
import com.mdkashem.dao.AccountTypeImplements;
import com.mdkashem.dao.RoleDAO;
import com.mdkashem.dao.RoleDAOImpl;
import com.mdkashem.dao.StatusDAO;
import com.mdkashem.dao.StatusDAOImplements;
import com.mdkashem.dao.userDAO;
import com.mdkashem.dao.userDAOImplement;



/**
 * Class used to retrieve DAO Implementations. Serves as a factory. Also manages a single instance of the database connection.
 */
public class DAOUtilities {

	private static final String CONNECTION_USERNAME = System.getenv("dbUserName"); //accessing the system environment variable for user Name
	private static final String CONNECTION_PASSWORD = System.getenv("dbPassword");  //accessing the system environment variable for password
	private static final String URL = System.getenv("dbConnectionString"); //accessing the system environment variable for  url
	private static Connection connection;
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		return connection;
	}
	
	public static userDAO getUserDAO() {
		return new userDAOImplement();
	
	}
	
	public static RoleDAO getRoleDAO() {
		return new RoleDAOImpl();
	
	}
	public static StatusDAO getStatusDAO() {
		return new StatusDAOImplements();
	
	}
	
	public static AccountTypeDAO getAccountTypeDAO() {
		return new AccountTypeImplements();
	}
	public static AccountDAO getAccountDAO() {
		return new AccountDAOImpl();
	}
}
