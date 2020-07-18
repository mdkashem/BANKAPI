package com.mdkashem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@WebServlet("/CreateUserServlet")
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

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		

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
		saveAccount(request, response, username, password, fName, lName, balance, statusId, typeId, roleId);
		//saveAccount( request, response,  balance,  statusId,  roleid);
	   //  saveUser(request, response, username, password, fName, lName, accId, roleid);
		
		    
		
		System.out.println(username + " " +password + " " + fName + " " + lName + " "+ balance+" " +statusName + " " + typeName +" "+ roleName);
		
		//if(LogInStatus.isLogged) {
			
			userDAO database = DAOUtilities.getUserDAO();
			Role role = new Role(roleId, roleName);
			
		//	User user = new User( username, password,fName, lName, email,  role);
			
		//	boolean isSuccess = database.addUser(user, role.getRoleId());
			//request.getSession().setAttribute("isbn_13", temTag.getIsbn13());
			request.getSession().setAttribute("tag_name", username);
			request.getRequestDispatcher("DisplayTag.jsp").forward(request, response);
			
	//	}
		
		/*
		userDAO database = DAOUtilities.getUserDAO();
		User tempUser = database.getBookByISBN(isbn13);
		TagDAO tag_database = DAOUtilities.getTagDAO();
		if (tempBook != null) {
			// ASSERT: book with isbn already exists

			//req.getSession().setAttribute("message", "ISBN of " + isbn13 + " is already in use");
			//req.getSession().setAttribute("messageClass", "alert-danger");
			//req.getRequestDispatcher("publishBook.jsp").forward(req, resp);
			BookTag bookTag = new BookTag();
			
			bookTag.setIsbn13(req.getParameter("isbn13"));
			bookTag.setTagName(req.getParameter("tagName"));
			boolean isSuccess = tag_database.addTag(bookTag);
			
			//TagDAO dao = DAOUtilities.getTagDAO();
			List<BookTag> tagList = tag_database.getAllTag();
			req.getSession().setAttribute("tags", tagList);
			req.getRequestDispatcher("DisplayAllTag.jsp").forward(req, resp);
			
		} else {
			
			req.getRequestDispatcher("DisplayAllTag.jsp").forward(req, resp);
		
		} //end else
		*/
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



