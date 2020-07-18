package com.mdkashem.services;

import com.mdkashem.dao.userDAO;
import com.mdkashem.dao.userDAOImplement;
import com.mdkashem.model.User;

public class UserServices {
	
	userDAO user;
	public UserServices() {
		user = new userDAOImplement();
		
	}
	
	public User findUserById(int id) {
		return this.user.getUserByID(id);
		
	}
	
	public boolean update(User user) {

		return this.user.updateUser(user);
	}

}
