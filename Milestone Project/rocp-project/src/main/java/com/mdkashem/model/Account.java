package com.mdkashem.model;

import java.io.Serializable;

public class Account implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int accountId; // primary key
	  private double balance;  // not null
	  private int statusId ;
	  private int typeId;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountId, double balance, int statusId, int typeId) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + statusId;
		result = prime * result + typeId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (statusId != other.statusId)
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Acccount [accountId=" + accountId + ", balance=" + balance + ", statusId=" + statusId + ", typeId="
				+ typeId + "]";
	}
	  
	  
	
}
