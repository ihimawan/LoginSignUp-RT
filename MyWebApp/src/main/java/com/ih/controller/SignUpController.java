package com.ih.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.hib.dto.Address;
import com.car.hib.dto.Profile;
import com.car.hib.dto.User;
import com.car.hib.dao.UserDao;
import com.ih.code.UserLogin;

/**
 * Servlet implementation class SignUpController
 */
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao = new UserDao();

    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("inputUsername");
		String password = request.getParameter("inputPassword");
		String street = request.getParameter("inputStreet");
		String state = request.getParameter("inputState");
		String gender = request.getParameter("inputGender");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		Address address = new Address();
		address.setUser(user);
		address.setStreet(street);
		address.setState(state);
		
		Profile profile = new Profile();
		profile.setUser(user);
		profile.setGender(gender);
		
		user.setAddress(address);
		user.setProfile(profile);
		
		RequestDispatcher rd=null;

			if (userDao.create(user)){
				System.out.println("ok");
			}else{
				System.out.println("no");
			}
			
			UserLogin userLogin = new UserLogin();
			userLogin.setUsername(username);
			
			request.getSession().setAttribute("userLogin", userLogin);
			
			rd = request.getRequestDispatcher("index.jsp");

		
		rd.forward(request, response);
		
		
		
		
	}

}
