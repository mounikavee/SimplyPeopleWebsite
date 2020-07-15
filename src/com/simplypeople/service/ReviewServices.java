package com.simplypeople.service;

import static com.simplypeople.service.CommonUtitlity.forwardToPage;
import static com.simplypeople.service.CommonUtitlity.showMessageBackend;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplypeople.dao.EmployeeDAO;
import com.simplypeople.dao.ReviewDAO;
import com.simplypeople.entity.Employee;
import com.simplypeople.entity.Projectmanager;

import com.simplypeople.entity.Review;

public class ReviewServices {
	private ReviewDAO reviewDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public ReviewServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		reviewDAO = new ReviewDAO();
	}
	
	public void listAllReview() throws ServletException, IOException {
		listAllReview(null);
	}
	
	public void listAllReview(String message) throws ServletException, IOException {
		List<Review> listReviews = reviewDAO.listAll();
		
		request.setAttribute("listReviews", listReviews);
		forwardToPage("review_list.jsp", message, request, response);		
	}
	
public void createReview() throws ServletException, IOException {
		
		
		
		int empid = Integer.parseInt(request.getParameter("empid"));
		int pmid = Integer.parseInt(request.getParameter("pmid"));
		float rating = Float.parseFloat(request.getParameter("rating"));
		String comment = request.getParameter("comment");
		
		
		
		Review existReview = reviewDAO.findByProjectmanagerAndEmployee(pmid,empid);
		
		if (existReview != null) {

			String message = "Could not create review.A review with this combination " + pmid + "  "+empid+" " +"already exists";

			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);

		} else {
			Employee employee = new Employee();
			Projectmanager projectmanager = new Projectmanager();
			employee.setEmployeeId(empid);
			projectmanager.setPmid(pmid);
		
			Review newReview = new Review(employee,projectmanager,comment,rating);
			reviewDAO.create(newReview);
			listAllReview("New Review created successfully");
	}
		
	}
	

	public void editReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		Review review = reviewDAO.get(reviewId);
		
		if (review != null) {		
			request.setAttribute("review", review);		
			forwardToPage("review_form.jsp", request, response);
		} else {
			String message = "Could not find review with ID " + reviewId;
			showMessageBackend(message, request, response);
		}
	}

	public void updateReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("reviewId"));
		
		String comment = request.getParameter("comment");
		
		Review review = reviewDAO.get(reviewId);
		
		review.setComment(comment);
		
		reviewDAO.update(review);
		
		String message = "The review has been updated successfully.";
		
		listAllReview(message);
		
	}

	public void deleteReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		Review review = reviewDAO.get(reviewId);
		
		if (review != null) {
			reviewDAO.delete(reviewId);
			String message = "The review has been deleted successfully.";
			listAllReview(message);
		} else {
			String message = "Could you find review with ID " + reviewId
					+ ", or it might have been deleted by another admin";
			showMessageBackend(message, request, response);
		}		
	}

	
	

	
}
