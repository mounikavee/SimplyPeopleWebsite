package com.simplypeople.controller.admin.employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplypeople.service.EmployeeServices;

@WebServlet("/admin/update_employee")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateEmployeeServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeServices employeeServices = new EmployeeServices(request, response);
		employeeServices.updateEmployee();		
	}

}
