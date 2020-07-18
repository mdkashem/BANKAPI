package com.mdkashem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mdkashem.model.User;
import com.mdkashem.services.UserServices;

/**
 * Servlet implementation class UpdateUserFinallyServelet
 */
public class UpdateUserFinallyServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServices userServices;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserFinallyServelet() {
        super();
        userServices = new UserServices();
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
		
		String userId = request.getParameter("userId");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String accountId = request.getParameter("accountId");
		String roleId = request.getParameter("roleId");
		
		User user = new User(Integer.parseInt(userId), username, password, fName, lName, Integer.parseInt(accountId), Integer.parseInt(roleId));
		System.out.println(user);
		
	boolean isUpdated=	userServices.update(user);
		
		
	
	}

}
