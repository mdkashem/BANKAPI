package com.mdkashem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mdkashem.dao.AccountTypeDAO;
import com.mdkashem.dao.RoleDAO;
import com.mdkashem.dao.StatusDAO;
import com.mdkashem.model.AccountStatus;
import com.mdkashem.model.AccountType;
import com.mdkashem.model.Role;
import com.mdkashem.utilities.DAOUtilities;

/**
 * Servlet implementation class DisplayAllAccountTypeServlet
 */
public class DisplayAllAccountTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllAccountTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		AccountTypeDAO dao = DAOUtilities.getAccountTypeDAO();
		List<AccountType> typeList = dao.getAllAccountType();
		System.out.println("Account type"+typeList.get(0));
		request.getSession().setAttribute("typeFromServlet", typeList);
		
		sendAllStutaus( request); //this private method find all status from db table to send the client 
		sendAllRole( request);// this private method send role list to the client side 
		//request.getRequestDispatcher("AddUser.jsp").forward(request, response); // this line don't work because AddUser.jsp call this servlet. 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/*
	 * The sendAllStatus method will send to client side 
	 * from batabase table 
	 */
	
	
	private void sendAllStutaus(HttpServletRequest request) {
		StatusDAO dao = DAOUtilities.getStatusDAO();
		List<AccountStatus> statusList = dao.getAllStatus();
		//System.out.println("Status "+statusList.get(0));
		request.getSession().setAttribute("statusListServlet", statusList);
		
	}
	
	/*
	 * The sendAllRole method will send list of role to the client side 
	 */
	private void sendAllRole(HttpServletRequest request) {
		RoleDAO dao = DAOUtilities.getRoleDAO();
		List<Role> roleList = dao.getAllRole();
		//System.out.println("Status "+roleList.get(0));
		request.getSession().setAttribute("roleListServlet", roleList);
		
	}

}
