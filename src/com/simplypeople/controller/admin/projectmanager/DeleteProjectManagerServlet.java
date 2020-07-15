package com.simplypeople.controller.admin.projectmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.simplypeople.service.ProjectmanagerServices;


@WebServlet("/admin/delete_manager")
public class DeleteProjectManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProjectManagerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProjectmanagerServices projectmanagerServices = new ProjectmanagerServices(request, response);
		projectmanagerServices.deleteProjectmanager();
	}

}
