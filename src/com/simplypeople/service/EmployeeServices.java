package com.simplypeople.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplypeople.dao.EmployeeDAO;
import com.simplypeople.entity.Employee;

public class EmployeeServices {
	private EmployeeDAO employeeDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public EmployeeServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		employeeDAO = new EmployeeDAO();
	}

	public void listEmployee()
			throws ServletException, IOException {
		listEmployee(null);
	}

	public void listEmployee(String message)
			throws ServletException, IOException {
		List<Employee> listEmployee = employeeDAO.listAll();

		request.setAttribute("listEmployee", listEmployee);

		if (message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "employee_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

		requestDispatcher.forward(request, response);

	}

	public void createEmployee() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");

		Employee existEmployee = employeeDAO.findByEmail(email);
		
		if (existEmployee != null) {
			String message = "Could not create employee. A employee with email " 
								+ email + " already exists";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
			
		} else {		
			Employee newEmployee = new Employee(email, fullName, password);
			employeeDAO.create(newEmployee);
			listEmployee("New employee created successfully");
		}

	}

	public void editEmployee() throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeDAO.get(employeeId );

		String destPage = "employee_form.jsp";
		
		if (employee == null) {
			destPage = "message.jsp";
			String errorMessage = "Could not find employee with ID " + employeeId;
			request.setAttribute("message", errorMessage);
		} else {
			request.setAttribute("employee", employee);			
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destPage);
		requestDispatcher.forward(request, response);
		
	}

	public void updateEmployee() throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		Employee employeeById = employeeDAO.get(employeeId);
		
		Employee employeeByEmail = employeeDAO.findByEmail(email);
		
		if (employeeByEmail != null && employeeByEmail.getEmployeeId() != employeeById.getEmployeeId()) {
			String message = "Could not update employee. Employee with email " + email + " already exists.";
			request.setAttribute("message", message);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);			
			
		} else {
			Employee employee = new Employee(employeeId, email, fullname, password);
			employeeDAO.update(employee);

			String message = "Employee has been updated successfully";
			listEmployee(message);
		}
		
	}

	public void deleteEmployee() throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		
		Employee employee = employeeDAO.get(employeeId);
		String message = "Employee has been deleted successfully";
		
		if (employee == null) {
			message = "Could not find employee with ID " + employeeId
					+ ", or it might have been deleted by another admin";
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);			
		} else {
			employeeDAO.delete(employeeId);
			listEmployee(message);
		}		
	}
	
	public void login() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean loginResult = employeeDAO.checkLogin(email, password);
		
		if (loginResult) {
			request.getSession().setAttribute("employeeemail", email);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response);
			
		} else {
			String message = "Login failed!";
			request.setAttribute("message", message);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);			
		}
	}
}
