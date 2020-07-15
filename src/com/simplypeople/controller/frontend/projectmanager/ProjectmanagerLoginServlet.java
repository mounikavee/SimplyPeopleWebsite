package com.simplypeople.controller.frontend.projectmanager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplypeople.service.ProjectmanagerServices;

@WebServlet("/login")
public class ProjectmanagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectmanagerLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProjectmanagerServices projectmanagerServices = new ProjectmanagerServices(request, response);
		projectmanagerServices.showLogin();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProjectmanagerServices projectmanagerServices = new ProjectmanagerServices(request, response);
		projectmanagerServices.doLogin();		
	}

}
