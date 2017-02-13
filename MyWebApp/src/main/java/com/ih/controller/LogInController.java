package com.ih.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.dao.DaoTemplate;
import com.car.hib.dao.UserDao;
import com.ih.code.UserLogin;

/**
 * Servlet implementation class LogInController
 */
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao = new UserDao();
       
    public LogInController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	request.getSession().invalidate();
    	
    	request.setAttribute("logoutMessage", "Logout successful. Thanks for using our site!");
    	
    	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("inputUsername");
		String password = request.getParameter("inputPassword");
		
		String realPassword = null;
		
		realPassword = userDao.getEntryPassword(username);
		RequestDispatcher rd=null;
		
		if (password.equals(realPassword)){
			UserLogin userLogin = new UserLogin();
			userLogin.setUsername(username);
			
			request.getSession().setAttribute("userLogin", userLogin);
			
			rd = request.getRequestDispatcher("index.jsp");
			
		}else{
			
			rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("loginMessage", "Incorrect username and password combination.");
			
		}
		 
		rd.forward(request, response);

	}

}
