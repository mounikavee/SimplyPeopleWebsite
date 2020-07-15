package com.simplypeople.service;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.simplypeople.service.CommonUtitlity.*;

import com.simplypeople.dao.ProjectmanagerDAO;
import com.simplypeople.entity.Projectmanager;



public class ProjectmanagerServices {
	private ProjectmanagerDAO ProjectmanagerDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ProjectmanagerServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		ProjectmanagerDAO = new ProjectmanagerDAO();
	}
	
	public void listProjectmanager() throws ServletException, IOException {
		listProjectmanager(null);
	}
	
	
	public void listProjectmanager(String message) throws ServletException, IOException {
List<Projectmanager> listManager = ProjectmanagerDAO.listAll();
	
		
		request.setAttribute("listManager", listManager);
		
		if(message != null) {	
			request.setAttribute("message", message);
		}
		
		String listPage = "projectmanager_list.jsp";
		
        RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);	
	}
	
	
	
	public void createProjectmanager() throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		Projectmanager existProjectmanager = ProjectmanagerDAO.findByEmail(email);
		
		if (existProjectmanager != null) {

			String message = "Could not create projectmanager.A projectmanager with this email " + email + " already exists";

			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);

		} else {
		
		
			Projectmanager newProjectmanager = new Projectmanager(pid,email,fullname,password);
			ProjectmanagerDAO.create(newProjectmanager);
		listProjectmanager("New projectmanager created successfully");
	}
	}

	public void editProjectmanager() throws ServletException, IOException {
		int pmid = Integer.parseInt(request.getParameter("pmid"));
		Projectmanager projectmanager = ProjectmanagerDAO.get(pmid);
		
		String editPage = "projectmanager_form.jsp";
		request.setAttribute("projectmanager", projectmanager);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
		}

	public void updateProjectmanager() throws ServletException, IOException {
		Integer pmid = Integer.parseInt(request.getParameter("pmid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		
		
		Projectmanager projectmanagerById = ProjectmanagerDAO.get(pmid);
		
		Projectmanager projectmanagerByEmail = ProjectmanagerDAO.findByEmail(email);
		
		if (projectmanagerByEmail != null && projectmanagerByEmail.getPmid() != projectmanagerById.getPmid()) {
			String message = "Could not update projectmanager. Projectmanager with email " + email + " already exists.";
			request.setAttribute("message", message);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);			
			
		} else {
		
			Projectmanager projectmanager = new Projectmanager(pmid,pid,email,fullname,password);
			ProjectmanagerDAO.update(projectmanager);
		
		String message = "Projectmanager has been updated successfully";
		listProjectmanager(message);
		}
		
	}

	public void deleteProjectmanager() throws ServletException, IOException {
		int pmid = Integer.parseInt(request.getParameter("pmid"));
		ProjectmanagerDAO.delete(pmid);
		String message = "Projectmanager has been deleted successfully";
		listProjectmanager(message);
		
	}
	public void registerProjectmanager() throws ServletException, IOException {
		//int pid = Integer.parseInt(request.getParameter("pid"));
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		String message = "";
		//System.out.println("email :" +email);
		
		Projectmanager existProjectmanager = ProjectmanagerDAO.findByEmail(email);
		
		if (existProjectmanager != null) {
			message = "Could not register. The email "
					+ email + " is already registered by another Projectmanager.";
		} else {
			
			Projectmanager newProjectmanager = new Projectmanager();
			updateProjectmanagerFieldsFromForm(newProjectmanager);			
			ProjectmanagerDAO.create(newProjectmanager);
			
			message = "You have registered successfully! Thank you.<br/>"
					+ "<a href='login'>Click here</a> to login";			
		}
		
		showMessageFrontend(message, request, response);
	}	
	
	private void updateProjectmanagerFieldsFromForm(Projectmanager projectmanager) {
		//int pid = Integer.parseInt(request.getParameter("pid"));
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		
		if (email != null && !email.equals("")) {
			projectmanager.setEmail(email);
		}
		
		
		
		if (password != null && !password.equals("")) {
			projectmanager.setPassword(password);
		}
		  projectmanager.setFullname(fullname);
		}

	public void showLogin() throws ServletException, IOException {
		forwardToPage("frontend/login.jsp", request, response);

		
	}

	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("checking login");
		Projectmanager projectmanager = ProjectmanagerDAO.checkLogin(email, password);
		
		if (projectmanager == null) {
			String message = "Login failed. Please check your email and password.";
			request.setAttribute("message", message);
			showLogin();
			
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loggedManager", projectmanager);
			
			Object objRedirectURL = session.getAttribute("redirectURL");
			
			if (objRedirectURL != null) {
				String redirectURL = (String) objRedirectURL;
				session.removeAttribute("redirectURL");
				response.sendRedirect(redirectURL);
			} else {
				showManagerProfile();
			}
		}
		
	}
	
	public void showManagerProfile() throws ServletException, IOException {
		forwardToPage("frontend/projectmanager_profile.jsp", request, response);
	}
	}
	
	
	
	

