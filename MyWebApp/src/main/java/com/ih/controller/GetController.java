package com.ih.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.hib.dao.CarDao;
import com.car.hib.dto.Car;

/**
 * Servlet implementation class FrontController
 */
public class GetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CarDao cd = new CarDao();
	List<Car> list = null;
	//List<Car> list = new ArrayList<Car>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String model = request.getParameter("model");
		
		try {
			
			if (model==null){
				list = cd.read();
			}else{
				list = cd.getCarsFilterByModel(model);
			}
			
			request.setAttribute("result", list);
			
		} catch (Exception e) {
			request.setAttribute("result", "Unable to obtain list of car.");
		}finally{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp"); 
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
