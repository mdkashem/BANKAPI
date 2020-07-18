package com.mdkashem.dao;

import java.util.List;

import com.mdkashem.model.AccountStatus;


public interface StatusDAO {
	    
	
	    public boolean addStatus(AccountStatus status);
	    public List<AccountStatus> getAllStatus();
		public AccountStatus getStatusByName(String name);
		public List<AccountStatus> getStatusById(String id);
		public boolean updateStatus(AccountStatus status);
		public boolean deleteStausByID(int id);
}
