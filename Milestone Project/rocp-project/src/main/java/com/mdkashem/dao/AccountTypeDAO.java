package com.mdkashem.dao;

import java.util.List;

import com.mdkashem.model.AccountType;


public interface AccountTypeDAO {
	    public boolean addAccountType(AccountType type);    
	    public List<AccountType> getAllAccountType();
		public AccountType getAccountTypeByName(String name);
		public List<AccountType> getAccountTypeById(String id);
		public boolean updateAccountType(AccountType type);
		public boolean deleteAccountTypeByID(int id);

}
