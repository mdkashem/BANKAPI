package com.mdkashem.dao;

import java.util.List;

import com.mdkashem.model.User;

public interface userDAO {
	public List<User> getAllUser();
	
	public List<User> getUserByName(String name);
	public List<User> getUserByEmail(String email);
	public List<User> getBooksLessThanPrice(double price);
	public User getUserByID(int id);
	
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUserByID(int id);

}
