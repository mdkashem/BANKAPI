package com.mdkashem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mdkashem.dao.AccountDAO;
import com.mdkashem.dao.AccountTypeDAO;
import com.mdkashem.dao.RoleDAO;
import com.mdkashem.dao.StatusDAO;
import com.mdkashem.dao.userDAO;
import com.mdkashem.model.Account;
import com.mdkashem.model.User;
import com.mdkashem.services.AccountLogics;
import com.mdkashem.services.UserServices;
import com.mdkashem.utilities.DAOUtilities;

/**
 * Servlet implementation class TransferServlet
 */
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServices userService;  
	AccountLogics accountService;
    public TransferServlet() {
        super();
        userService = new UserServices();
        accountService = new AccountLogics();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String URI = request.getRequestURI().replace("/rocp-project/accounts", "");
		String userId;
		if(request.getSession().getAttribute("userId")==null) {
			switch (URI) {
			 case"/register":
	        	 String username = request.getParameter("userNameTextBox");
	     		String password = request.getParameter("passwordTextBox");
	     		String fName = request.getParameter("firstNameTextBox");
	     		String lName = request.getParameter("lastNameTextBox");
	     		double Register_balance = Double.parseDouble(request.getParameter("depositBalanceTextBox"));
	     		String statusName = request.getParameter("statusSelection");
	     		String typeName = request.getParameter("accountTypeSelection");
	     		String roleName = request.getParameter("roleTextBox");
	     		System.out.println(username + " " +password + " " + fName + " " + lName + " "+ Register_balance+" " +statusName + " " + typeName +" "+ roleName);
	     		
	     		AccountTypeDAO type = DAOUtilities.getAccountTypeDAO();
	     		int typeId = type.getAccountTypeByName(typeName).getTypeId();
	     		
	     		
	     		
	     		StatusDAO statusDB = DAOUtilities.getStatusDAO();
	     		int statusId = statusDB.getStatusByName(statusName).getStatusId();
	     		RoleDAO roleDB = DAOUtilities.getRoleDAO();
	     		int roleId = roleDB.getRoleByName(roleName).getRoleId();
	     		
	     		
	     			saveAccount(request, response, username, password, fName, lName, Register_balance, statusId, typeId, roleId);
	   
	 			break;
			}
		}else {
			
		
		
		
		int id = (int) request.getSession().getAttribute("userId");
		User user = userService.findUserById(id);
		double balance;
		 if(user==null) {
	    	 
	    	    request.getSession().setAttribute("message", "This user does not exist.");
	    	   
	    	    response.sendRedirect("../login.jsp");
				//request.getSession().setAttribute("messageClass", "alert-success");
	      }
	      else if(user.getUsername().equals(request.getSession().getAttribute("username")) & user.getPassword().equals(request.getSession().getAttribute("password"))) {
		switch (URI) {
		case "/transfer":
			userId = request.getParameter("userId");
			if(((String) request.getSession().getAttribute("user_role")).equalsIgnoreCase("Employee") & id!=Integer.parseInt(userId)) {
				request.getSession().setAttribute("message", "Permission Denied!");
				request.getSession().setAttribute("messageClass", "alert-danger");
				response.sendRedirect("../employee.jsp");
			}
			 
			 user = userService.findUserById(Integer.parseInt(userId));
			 balance = userService.userBalance(user.getAccountId());// find the user balance 
			List<User> receiverList = userService.getAllUser();
			request.getSession().setAttribute("receiverList", receiverList );
			request.getSession().setAttribute("userBalance", balance );
			response.sendRedirect("../Transfer.jsp");
			
				break;
		case "/transferInfo":
			 userId = request.getParameter("userId");
			 user = userService.findUserById(Integer.parseInt(userId));
			
			 balance = userService.userBalance(user.getAccountId());
			String sentAmount = request.getParameter("sentAmount");
			double sender_balance = balance - Double.parseDouble(sentAmount);
			
			String receiverId = request.getParameter("receiverTextBox");
			
			double receiver_balance = userService.userBalance(userService.findUserById(Integer.parseInt(receiverId))
					.getAccountId())+Double.parseDouble(sentAmount);
			//update sender's account balance 
			boolean b1=userService.updateUserBalance(Integer.parseInt(userId), sender_balance);
			
			//update receiver's balance 
		    boolean b2=	userService.updateUserBalance(Integer.parseInt(receiverId), receiver_balance);
		  //  response.sendRedirect("../AdminLogin");
		    request.getSession().setAttribute("user", user);
		    request.getSession().setAttribute("message", "Transfer successful.");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getSession().setAttribute("userBalance", sender_balance );
		    response.sendRedirect("../user.jsp");
			//System.out.println("transferInfo case Id ; " +userId + "sent amount "+sentAmount+ "sender_balance "
				//	+sender_balance + "receiver_balance "+receiver_balance+b1+b2);
				break;
		case"/withdraw":
			//System.out.println("withdraw request");
			 userId = request.getParameter("userId");
			 user = userService.findUserById(Integer.parseInt(userId));
			 balance = userService.userBalance(user.getAccountId());// find the user balance 
			 request.getSession().setAttribute("userBalance", balance );
			 response.sendRedirect("../withdraw.jsp");
			break;
		case"/withdrawConfirm":
			//System.out.println("withdraw request");
			 userId = request.getParameter("userId");
			 user = userService.findUserById(Integer.parseInt(userId));
			 balance = userService.userBalance(user.getAccountId());// find the user balance 
			 String withdrawAmount = request.getParameter("withdrawAmount");
				double new_balance = balance - Double.parseDouble(withdrawAmount);
				userService.updateUserBalance(Integer.parseInt(userId), new_balance); //update into database
			 request.getSession().setAttribute("userBalance", new_balance );
			 request.getSession().setAttribute("user", user);
			    request.getSession().setAttribute("message", "Withdrawal successful.");
				request.getSession().setAttribute("messageClass", "alert-danger");
			 response.sendRedirect("../user.jsp");
			break;
		case"/deposit":
			//System.out.println("withdraw request");
			 userId = request.getParameter("userId");
			 user = userService.findUserById(Integer.parseInt(userId));
			 balance = userService.userBalance(user.getAccountId());// find the user balance 
			 request.getSession().setAttribute("userBalance", balance );
			 response.sendRedirect("../deposit.jsp");
			break;
			
		case"/depositConfirm":
			//System.out.println("withdraw request");
			 userId = request.getParameter("userId");
			 user = userService.findUserById(Integer.parseInt(userId));
			 balance = userService.userBalance(user.getAccountId());// find the user balance 
			 String depositAmount = request.getParameter("depositAmount");
			 double deposit_balance = balance + Double.parseDouble(depositAmount); // add deposit amount with existing balance 
			 userService.updateUserBalance(Integer.parseInt(userId), deposit_balance); //update into database
			 request.getSession().setAttribute("userBalance", deposit_balance );
			 request.getSession().setAttribute("user", user);
			 request.getSession().setAttribute("message", "Deposit successful.");
			 request.getSession().setAttribute("messageClass", "alert-danger");
			 response.sendRedirect("../user.jsp");
			break;
		case"/all":
			
			List<Account> accountList = accountService.allAccounts();
			//System.out.println("Account type"+typeList.get(0));
			request.getSession().setAttribute("accountFromServlet", accountList);
			response.sendRedirect("../DisplayAccounts.jsp");
			break;
		case"/accountUpdate":
			
			if(((String) request.getSession().getAttribute("user_role")).equalsIgnoreCase("Admin")) {
				String accId = request.getParameter("accountId");
				request.getSession().setAttribute("account", accountService.findAccountById(Integer.parseInt(accId)));
				response.sendRedirect("../accountDetail.jsp");
			}else if(((String) request.getSession().getAttribute("user_role")).equalsIgnoreCase("Employee")){
				request.getSession().setAttribute("message", "Permission Denied!");
				request.getSession().setAttribute("messageClass", "alert-danger");
				//request.getRequestDispatcher("employee.jsp").forward(request, response);
				response.sendRedirect("../employee.jsp");
			}else {
				String accId = request.getParameter("accountId");
				request.getSession().setAttribute("account", accountService.findAccountById(Integer.parseInt(accId)));
				response.sendRedirect("../accountDetail.jsp");
			}
			break;
		case"/accountUpdateFinally":
			
			Account acc = new Account(Integer.parseInt(request.getParameter("accountId")), Double.parseDouble(request.getParameter("balance")),Integer.parseInt(request.getParameter("statusId")),Integer.parseInt(request.getParameter("typeId")));
			accountService.upadate(acc);
			 request.getSession().setAttribute("message", "Account Update successful.");
			 request.getSession().setAttribute("messageClass", "alert-danger");
			request.getSession().setAttribute("accountFromServlet", accountService.allAccounts());
			response.sendRedirect("../DisplayAccounts.jsp");
			
			break;
         case"/accountDelete":
        	 if(((String) request.getSession().getAttribute("user_role")).equalsIgnoreCase("Employee")) {
 				request.getSession().setAttribute("message", "Permission Denied!");
 				request.getSession().setAttribute("messageClass", "alert-danger");
 				response.sendRedirect("../employee.jsp");
 			}else {
        	 
			int accountId = Integer.parseInt(request.getParameter("accountId"));
			User account_user = userService.findUserByAccountId(accountId);
			if(account_user==null) {
				// delete account 
				accountService.delete(accountId);
				 request.getSession().setAttribute("message", "Account Delete successful.");
				 request.getSession().setAttribute("messageClass", "alert-danger");
				request.getSession().setAttribute("accountFromServlet", accountService.allAccounts());
				response.sendRedirect("../DisplayAccounts.jsp");
			}else {
				 request.getSession().setAttribute("message", "Not success!!! Please, delete the user "+account_user.getUsername()+" of the account before delete this account.");
				 request.getSession().setAttribute("messageClass", "alert-danger");
				request.getSession().setAttribute("accountFromServlet", accountService.allAccounts());
				response.sendRedirect("../DisplayAccounts.jsp");
			    }
			
 			}
			break;
         case"/register":
        	 String username = request.getParameter("userNameTextBox");
     		String password = request.getParameter("passwordTextBox");
     		String fName = request.getParameter("firstNameTextBox");
     		String lName = request.getParameter("lastNameTextBox");
     		double Register_balance = Double.parseDouble(request.getParameter("depositBalanceTextBox"));
     		String statusName = request.getParameter("statusSelection");
     		String typeName = request.getParameter("accountTypeSelection");
     		String roleName = request.getParameter("roleTextBox");
     		System.out.println(username + " " +password + " " + fName + " " + lName + " "+ Register_balance+" " +statusName + " " + typeName +" "+ roleName);
     		
     		AccountTypeDAO type = DAOUtilities.getAccountTypeDAO();
     		int typeId = type.getAccountTypeByName(typeName).getTypeId();
     		
     		
     		
     		StatusDAO statusDB = DAOUtilities.getStatusDAO();
     		int statusId = statusDB.getStatusByName(statusName).getStatusId();
     		RoleDAO roleDB = DAOUtilities.getRoleDAO();
     		int roleId = roleDB.getRoleByName(roleName).getRoleId();
     		
     		
     			saveAccount(request, response, username, password, fName, lName, Register_balance, statusId, typeId, roleId);
   
 			break;
         case"/AdminTransfer":
        	 userId = request.getParameter("userId");
        	 if(((String) request.getSession().getAttribute("user_role")).equalsIgnoreCase("Employee") & id!=Integer.parseInt(userId)) {
 				request.getSession().setAttribute("message", "Permission Denied!");
 				request.getSession().setAttribute("messageClass", "alert-danger");
 				response.sendRedirect("../employee.jsp");
 			}else{
 				 user = userService.findUserById(Integer.parseInt(userId));
 				 balance = userService.userBalance(user.getAccountId());// find the user balance 
 				 request.getSession().setAttribute("user", user );
 				request.getSession().setAttribute("receiverList", userService.getAllUser() );
 				request.getSession().setAttribute("userBalance", balance );
 				response.sendRedirect("../AdminTransfer.jsp");
 			}
        	 
			
        	 break;
         case"/AdminTransferInfo":
        	 userId = request.getParameter("userId");
        	 System.out.println("User id : "+ userId);
			 user = userService.findUserById(Integer.parseInt(userId));
			System.out.println(user);
			 balance = userService.userBalance(user.getAccountId());
			
			double admin_send_balance = balance - Double.parseDouble(request.getParameter("sentAmount"));
			
			String receiverId2 = request.getParameter("receiverTextBox");
			
			double receiver_balance2 = userService.userBalance(userService.findUserById(Integer.parseInt(receiverId2))
					.getAccountId())+Double.parseDouble(request.getParameter("sentAmount"));
			//update sender's account balance 
			userService.updateUserBalance(Integer.parseInt(userId), admin_send_balance);
			
			//update receiver's balance 
		    userService.updateUserBalance(Integer.parseInt(receiverId2), receiver_balance2);
		  //  response.sendRedirect("../AdminLogin");
		    request.getSession().setAttribute("user", user);
		    request.getSession().setAttribute("message", "Transfer successful.");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getSession().setAttribute("userBalance", admin_send_balance );
		    response.sendRedirect("../DisplayAllUser.jsp");
        	 break;
			
		default:
			response.sendRedirect("../index.jsp");
		}
	 }else {
		 response.sendRedirect("../index.jsp");
		 
	 }//lower else
		} //upper else	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	/*
	 * this saveUser will save the user information into database
	 */
	private void saveUser(HttpServletRequest request, HttpServletResponse response, String username, String pass, String fName, String lName, int accId, int roleId) throws ServletException, IOException {
		
		
		userDAO database = DAOUtilities.getUserDAO();
		User tempUser = database.getUserByName(username);
		//TagDAO tag_database = DAOUtilities.getTagDAO();
		if (tempUser != null) {
			// username already exists

			request.getSession().setAttribute("message", "user name " + username + " is already in use");
			request.getSession().setAttribute("messageClass", "alert-danger");
			response.sendRedirect("../Register.jsp");
			
			
			
		} else {
			
            User user = new User();
			user.setUsername(username);
			user.setPassword(pass);
			user.setFirstName(fName);
			user.setLastName(lName);
			user.setAccountId(accId);
			user.setRoleId(roleId);
			database.addUser(user);
			request.getSession().setAttribute("message", "You successfully added the user. You can login now");
			response.sendRedirect("../login");
		} //end else
		
	}// saveUser end 
	
private void saveAccount(HttpServletRequest request, HttpServletResponse response, String username, String pass, String fName, String lName, double balance, int statusId, int typeId, int roleId) throws ServletException, IOException {
		
		AccountDAO database = DAOUtilities.getAccountDAO();
            Account account = new Account();
           // account.setAccountId(accountID);
			account.setBalance(balance);
			account.setStatusId(statusId);
			account.setTypeId(typeId);
			
		int accountID=	database.findLastAccountId(account);
		if(accountID>0) {
			saveUser(request,  response,  username,  pass,  fName,  lName, accountID, roleId);
		}
		
		
		
		} //end saveAccount
		
	}


