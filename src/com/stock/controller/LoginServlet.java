package com.stock.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final String ERROR_MESSAGE = "Username or Password incorrect!";
	private static final String ERROR = "error";
	private static final long serialVersionUID = 1L;
	private static final String HOME_PAGE = "home/html/home.html";
	private static final String PASS = "pass";
	private static final String USERNAME = "username";
	private static final String ADMIN = "admin";
	private static final String LOGIN_PAGE = "login/jsp/login.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASS);
		
		if(ADMIN.equals(username) && ADMIN.equals(password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(HOME_PAGE);
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN_PAGE);
			request.setAttribute(ERROR, ERROR_MESSAGE);
			dispatcher.include(request, response);
		}
	}

}
