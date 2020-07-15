package com.simplypeople.controller.admin.employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplypeople.service.EmployeeServices;

@WebServlet("/admin/edit_employee")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditEmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeServices employeeServices = new EmployeeServices(request, response);
		employeeServices.editEmployee();
	}

}
