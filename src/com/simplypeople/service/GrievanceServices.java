package com.simplypeople.service;

import static com.simplypeople.service.CommonUtitlity.forwardToPage;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplypeople.dao.GrievancesDAO;
import com.simplypeople.entity.Users;
import com.simplypeople.entity.Employee;


import com.simplypeople.entity.Grievances;


public class GrievanceServices {
	private GrievancesDAO GrievancesDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	

	public GrievanceServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.GrievancesDAO = new GrievancesDAO();
	}
	
	public void listAllGrievances() throws ServletException, IOException {
		listAllGrievances(null);
	}
	
	public void listAllGrievances(String message) throws ServletException, IOException {
		List<Grievances> listGrievances = GrievancesDAO.listAll();
		
		request.setAttribute("listGrievances", listGrievances);
		forwardToPage("grievance_list.jsp", message, request, response);		
	}


	public void createGrievance() throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		String comment = request.getParameter("comment");
		
		
		
		
		
					Employee employee = new Employee();
			Users user = new Users();
			employee.setEmployeeId(empid);
			user.setUsersId(userId);
		
			Grievances grievance = new Grievances(employee,user,comment);
			GrievancesDAO.create(grievance);
			listAllGrievances("New Grievance created successfully");
	}

		
	}


