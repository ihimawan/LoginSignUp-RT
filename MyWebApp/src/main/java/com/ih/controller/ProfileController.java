package com.ih.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.dao.AddressDao;
import com.car.dao.DaoTemplate;
import com.car.dao.ProfileDao;
import com.car.dto.Address;
import com.car.dto.Profile;
import com.ih.code.UserLogin;

/**
 * Servlet implementation class ProfileController
 */
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoTemplate addressDao = new AddressDao();
	DaoTemplate profileDao = new ProfileDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserLogin userLogin = (UserLogin) request.getSession().getAttribute("userLogin");
		
		String username = userLogin.getUsername();
		Address a = null;
		Profile p = null;
		
		try {
			a = (Address) addressDao.findById(username);
			p = (Profile) profileDao.findById(username);
			
			System.out.println("ADDRESS = " + a.getState());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("userAddress", a);
		request.setAttribute("userProfile", p);
		
		RequestDispatcher rd = request.getRequestDispatcher("userProfile.jsp");
		rd.forward(request, response);
		
	}


}
