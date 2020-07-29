package com.mdkashem.services;

import java.util.ArrayList;
import java.util.List;

import com.mdkashem.dao.AccountDAO;
import com.mdkashem.dao.AccountDAOImpl;
import com.mdkashem.model.Account;

public class AccountLogics {
	AccountDAO account;
	
	public AccountLogics() {
		account = new AccountDAOImpl();
	}
	
	public List<Account> allAccounts(){
		List<Account> accounts = new ArrayList<Account>();
		accounts = this.account.getAllAccount();
		
		//for(Account acc: accounts) {
			
			//acc.setBalance(acc.getBalance());
	//	}
		
		return accounts;
		
	}
	
	public Account findAccountById(int id) {
		
		
		return this.account.getAccountById(id);
		
	}
	
	public boolean upadate(Account acc) {
		
		return this.account.updateAccount(acc);
	}
	
	public boolean delete(int id) {
		return this.account.deleteAccountByID(id);
	}
	
	
	

}
