package com.simplypeople.controller.admin.grievances;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.simplypeople.service.GrievanceServices;

@WebServlet("/admin/create_grievance")
public class CreateGrievanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateGrievanceServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GrievanceServices grievanceServices = new GrievanceServices(request, response);
		grievanceServices.createGrievance();
	}

}
