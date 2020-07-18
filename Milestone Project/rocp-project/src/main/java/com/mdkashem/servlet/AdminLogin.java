package com.mdkashem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mdkashem.model.User;
import com.mdkashem.utilities.DAOUtilities;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username=request.getParameter("userNameTextBox");  
        String password=request.getParameter("passwordTextBox");  
      User user=  DAOUtilities.getUserDAO().getUserByName(username);
      
     
      if(user==null) {
    	  request.getRequestDispatcher("login.jsp").forward(request, response);
      }
      else if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
			//If the credentials are correct, grant this client a session.
			HttpSession session = request.getSession();
			//We can also set session attributes!
			session.setAttribute("username", username);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
			/*
			 * If you wish to access your session attributes later, use:
			 */
			
			session.getAttribute("username");
		}else {
			 request.getRequestDispatcher("login.jsp").forward(request, response);
		}
        
       
        
	}

}
