package com.simplypeople.controller.admin.projectmanager;



import com.simplypeople.service.ProjectmanagerServices;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/update_manager")
public class UpdateProjectManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public UpdateProjectManagerServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProjectmanagerServices projectmanagerServices = new ProjectmanagerServices(request, response);
		projectmanagerServices.updateProjectmanager();
	}

}
