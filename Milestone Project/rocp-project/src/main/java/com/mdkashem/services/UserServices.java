package com.mdkashem.services;

import java.util.List;

import com.mdkashem.dao.userDAO;
import com.mdkashem.dao.userDAOImplement;
import com.mdkashem.model.User;
import com.mdkashem.utilities.DAOUtilities;

public class UserServices {
	
	userDAO user;
	public UserServices() {
		user = new userDAOImplement();
		
	}
	
	public User findUserById(int id) {
		return this.user.getUserByID(id);
		
	}
	public User findUserByAccountId(int accId) {
		return this.user.getUserByAccountId(accId);
		
	}
	public User findUserByName(String name) {
		return this.user.getUserByName(name);
	}
	
	public boolean update(User user) {

		return this.user.updateUser(user);
	}
	public boolean delete(int id) {

		return this.user.deleteUserByID(id);
	}
	public String userRole(int roleId) {
		
		return DAOUtilities.getRoleDAO().getRoleById(roleId).getRole();
	}
	public double userBalance(int id) {
		return DAOUtilities.getAccountDAO().getAccountById(id).getBalance();
	}
	public List<User> getAllUser(){
		return this.user.getAllUser();
	}
	public boolean updateUserBalance(int userId, double newBalance) {
		 
		return DAOUtilities.getAccountDAO().updateBalance(findUserById(userId).getAccountId(), newBalance);
	}

}
