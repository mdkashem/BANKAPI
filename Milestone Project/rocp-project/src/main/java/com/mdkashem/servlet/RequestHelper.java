package com.mdkashem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static Object processGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String URI = request.getRequestURI().replace("/rocp-project", "");

		System.out.println(URI);

		switch (URI) {
		case "/superpower/all":
			//return new SuperPowerService().findAllSuperPowers();

		case "/supercharacter/all":
			return "To Be Implemented";

		default:
			return "No Such Endpoint";
		}
	}
	
	public static void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		final String URI = request.getRequestURI().replace("/Servlets/myapi", "");
		
		switch(URI) {
		case "/superpower/new":
			//new SuperPowerService().insertPowerSuper(request, response);
		
		default:
			response.getWriter().write("You're mistaken.");
		}
	}

}
