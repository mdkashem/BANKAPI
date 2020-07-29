package com.mdkashem.dao;

import java.util.List;

import com.mdkashem.model.User;

public interface userDAO {
	public List<User> getAllUser();
	
	public User getUserByName(String name);
	public List<User> getUserByEmail(String email);
	public User getUserByID(int id);
	public User getUserByAccountId(int accId);
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUserByID(int id);
	public List<User>  findUser(String username, String password) ;
}
