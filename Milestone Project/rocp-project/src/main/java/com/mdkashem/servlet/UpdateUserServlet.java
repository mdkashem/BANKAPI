package com.mdkashem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mdkashem.model.User;
import com.mdkashem.services.UserServices;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	UserServices userServices;
    public UpdateUserServlet() {
        super();
        userServices = new UserServices();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(((String) request.getSession().getAttribute("user_role")).equalsIgnoreCase("Admin")) {
			String userId = request.getParameter("userId");
			User user = userServices.findUserById(Integer.parseInt(userId));
			request.setAttribute("user", user);
			request.getRequestDispatcher("userDetails.jsp").forward(request, response);
		}else if(((String) request.getSession().getAttribute("user_role")).equalsIgnoreCase("Employee") & (int)request.getSession().getAttribute("userId") != Integer.parseInt(request.getParameter("userId"))){
			request.getSession().setAttribute("message", "Permission Denied!");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("employee.jsp").forward(request, response);
		}else {
			//request.getSession().setAttribute("message", "Permission denied!");
			//request.getSession().setAttribute("messageClass", "alert-danger");
			//request.getRequestDispatcher("user.jsp").forward(request, response);
			String userId = request.getParameter("userId");
			User user = userServices.findUserById(Integer.parseInt(userId));
			request.setAttribute("user", user);
			request.getRequestDispatcher("userDetails.jsp").forward(request, response);
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
