package com.mdkashem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mdkashem.dao.AccountDAO;
import com.mdkashem.dao.AccountTypeDAO;
import com.mdkashem.dao.RoleDAO;
import com.mdkashem.dao.StatusDAO;
import com.mdkashem.dao.userDAO;
import com.mdkashem.model.Account;
import com.mdkashem.model.Role;
import com.mdkashem.model.User;
import com.mdkashem.utilities.DAOUtilities;



/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/register")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		if(session == null ) {
			
			// request.getSession().setAttribute("message", "You Logged Out!");
		 	 request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(session.getAttribute("username")==null){
			System.out.println("session not null" + " user "+session.getAttribute("username"));
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else {
			 request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String username = request.getParameter("userNameTextBox");
		String password = request.getParameter("passwordTextBox");
		String fName = request.getParameter("firstNameTextBox");
		String lName = request.getParameter("lastNameTextBox");
		double balance = Double.parseDouble(request.getParameter("depositBalanceTextBox"));
		String statusName = request.getParameter("statusSelection");
		String typeName = request.getParameter("accountTypeSelection");
		AccountTypeDAO type = DAOUtilities.getAccountTypeDAO();
		int typeId = type.getAccountTypeByName(typeName).getTypeId();
		
		String roleName = request.getParameter("roleTextBox");
		
		StatusDAO statusDB = DAOUtilities.getStatusDAO();
		int statusId = statusDB.getStatusByName(statusName).getStatusId();
		RoleDAO roleDB = DAOUtilities.getRoleDAO();
		int roleId = roleDB.getRoleByName(roleName).getRoleId();
		/*
		 * SaveAccount method create user account only if the role is admin 
		 */
		if(((String) request.getSession().getAttribute("user_role")).equalsIgnoreCase("Admin")) {
			saveAccount(request, response, username, password, fName, lName, balance, statusId, typeId, roleId);
		}else if(((String) request.getSession().getAttribute("user_role")).equalsIgnoreCase("Employee")){
			request.getSession().setAttribute("message", "Permission Denied!");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("employee.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("message", "Permission denied!");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}
		
		//System.out.println(username + " " +password + " " + fName + " " + lName + " "+ balance+" " +statusName + " " + typeName +" "+ roleName);
		
		//if(LogInStatus.isLogged) {
			
		//	userDAO database = DAOUtilities.getUserDAO();
		//	Role role = new Role(roleId, roleName);
			
		//	User user = new User( username, password,fName, lName, email,  role);
			
		//	boolean isSuccess = database.addUser(user, role.getRoleId());
			//request.getSession().setAttribute("isbn_13", temTag.getIsbn13());
			
		
	
	}//end dopost
	
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
			request.getRequestDispatcher("AddUser.jsp").forward(request, response);
			
			
			
		} else {
			
            User user = new User();
			user.setUsername(username);
			user.setPassword(pass);
			user.setFirstName(fName);
			user.setLastName(lName);
			user.setAccountId(accId);
			user.setRoleId(roleId);
			database.addUser(user);
			request.getSession().setAttribute("message", "you successfully added the user.");
    	    request.getRequestDispatcher("DisplayAllUsersServlet").forward(request, response);
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



