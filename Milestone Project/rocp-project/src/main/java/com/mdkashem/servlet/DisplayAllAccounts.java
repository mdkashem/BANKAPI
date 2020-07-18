package com.mdkashem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdkashem.services.AccountLogics;

/**
 * Servlet implementation class DisplayAllAccounts
 */
public class DisplayAllAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountLogics account;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllAccounts() {
        super();
       this.account = new AccountLogics();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*
		 * Let's instead use a standard format for sending data to the client: JSON.
		 * In order to send JSON, we can either:
		 * 
		 * 1) Manually format the string we write to the response body as JSON. That
		 *    said, this is unnecessary if you already have a tool that does the
		 *    formatting for you!
		 * 2) Use a tool that takes care of formatting for you (hint: Jackson's
		 *    ObjectMapper). NOTE: Jackson is not the only option for serialization.
		 *    There are other tools, one such tool being the GSON library.
		 */
		//ObjectMapper imTheMap = new ObjectMapper();
		
		/*
		 * Note that the only thing that the ObjectMapper does in this line of code
		 * is convert your Java object into a JSON string representation of itself.
		 * It doesn't actually write to the response body!
		 */
	//	final String JSON = imTheMap.writeValueAsString(this.account.allAccounts());
		
		//Write your JSON to the response body!
//		response.getWriter().write(JSON);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String accountId = request.getParameter("accountId");
		
		System.out.println(accountId);
		/*
		 * Let's instead use a standard format for sending data to the client: JSON.
		 * In order to send JSON, we can either:
		 * 
		 * 1) Manually format the string we write to the response body as JSON. That
		 *    said, this is unnecessary if you already have a tool that does the
		 *    formatting for you!
		 * 2) Use a tool that takes care of formatting for you (hint: Jackson's
		 *    ObjectMapper). NOTE: Jackson is not the only option for serialization.
		 *    There are other tools, one such tool being the GSON library.
		 */
		ObjectMapper imTheMap = new ObjectMapper();
		
		/*
		 * Note that the only thing that the ObjectMapper does in this line of code
		 * is convert your Java object into a JSON string representation of itself.
		 * It doesn't actually write to the response body!
		 */
		final String JSON = imTheMap.writeValueAsString(this.account.findAccountById(Integer.parseInt(accountId)));
		
		//Write your JSON to the response body!
		response.getWriter().write(JSON);
		
	}

}
