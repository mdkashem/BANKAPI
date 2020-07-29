package com.mdkashem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mdkashem.services.UserServices;

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServices userServices;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        userServices = new UserServices();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("user_role")==null) {
			request.getSession().setAttribute("message", " Invalid permission. Only Admin can delete user.");
    	    request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			
		
		if(((String) request.getSession().getAttribute("user_role")).equalsIgnoreCase("Admin")) {
			String userId = request.getParameter("userId");
			userServices.delete(Integer.parseInt(userId));
			request.getSession().setAttribute("message", "you successfully deleted the user.");
			request.getSession().setAttribute("messageClass", "alert-danger");
    	    request.getRequestDispatcher("DisplayAllUsersServlet").forward(request, response);
		}else {
			request.getSession().setAttribute("message", " Invalid permission. Only Admin can delete user.");
			request.getSession().setAttribute("messageClass", "alert-danger");
    	    request.getRequestDispatcher("DisplayAllUsersServlet").forward(request, response);
		}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
