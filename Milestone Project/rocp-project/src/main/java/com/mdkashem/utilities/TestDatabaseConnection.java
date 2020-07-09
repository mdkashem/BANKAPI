package com.mdkashem.utilities;

import java.util.List;

import com.mdkashem.model.User;

public class TestDatabaseConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	List<User> users =	DAOUtilities.getUserDAO().getAllUser();
	
	System.out.println("User Name : "+users.get(0).getFirstName() + " Role "+ users.get(0).getRole().getRole());

	}

}
