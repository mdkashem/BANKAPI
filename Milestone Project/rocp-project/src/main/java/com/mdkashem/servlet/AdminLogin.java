package com.mdkashem.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mdkashem.model.User;
import com.mdkashem.services.UserServices;
import com.mdkashem.utilities.DAOUtilities;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
      UserServices userServices; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        userServices = new UserServices();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username=request.getParameter("userNameTextBox");  
        String password=request.getParameter("passwordTextBox");  
        User user=  userServices.findUserByName(username);//DAOUtilities.getUserDAO().getUserByName(username);
        
      
     
      if(user==null) {
    	 
    	    request.getSession().setAttribute("message", "This user does not exist.");
    	    request.getRequestDispatcher("login.jsp").forward(request, response);
			//request.getSession().setAttribute("messageClass", "alert-success");
      }
      else if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
			//If the credentials are correct, grant this client a session.
			HttpSession session = request.getSession();
			//We can also set session attributes!
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("user_role", userServices.userRole(user.getRoleId()));
			if(DAOUtilities.getRoleDAO().getRoleById(user.getRoleId()).getRole().equalsIgnoreCase("Admin")) {
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}else if(DAOUtilities.getRoleDAO().getRoleById(user.getRoleId()).getRole().equalsIgnoreCase("Employee")) {
				request.getRequestDispatcher("employee.jsp").forward(request, response);
			}else {
				// for regular user only 
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("userBalance", userServices.userBalance(user.getAccountId()));
				request.getRequestDispatcher("user.jsp").forward(request, response);
			}
			
			/*
			 * If you wish to access your session attributes later, use:
			 */
			
			//System.out.println("sername " +session.getAttribute("username"));
		}else {
			request.getSession().setAttribute("message_log", "Invalid Credentials");
    	    request.getRequestDispatcher("login.jsp").forward(request, response);
		}
        
       
        
	}

}
