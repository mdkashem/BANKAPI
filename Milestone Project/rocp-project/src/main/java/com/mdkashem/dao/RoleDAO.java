package com.mdkashem.dao;

import java.util.List;

import com.mdkashem.model.Role;


public interface RoleDAO {
	public boolean addRole(Role role);
	public List<Role> getAllRole();
	public Role getRoleByName(String name);
	public List<Role> getRoleById(String id);
	
	boolean updateRole(Role role);
	public boolean deleteRoleByID(int id);
	
}
