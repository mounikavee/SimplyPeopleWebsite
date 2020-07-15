package com.simplypeople.dao;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.AfterClass;

import org.junit.BeforeClass;
import org.junit.Test;

import com.simplypeople.entity.Employee;
import com.simplypeople.entity.Projectmanager;
import com.simplypeople.entity.Review;

public class ReviewDAOTest  {

	private static ReviewDAO reviewDao;
	

	@BeforeClass
	public static void setUpClass() throws Exception {
		reviewDao = new ReviewDAO();		
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDao.close();
	}

	

	@Test
	public void testCreateReview() {
		Review review = new Review();
		Employee employee = new Employee();
		employee.setEmployeeId(6);
		
		Projectmanager projectmanager = new Projectmanager();
		projectmanager.setPmid(6);
		
		review.setEmployee(employee);
		review.setProjectmanager(projectmanager);
		
		
	
		review.setRating(3);
		review.setComment("Deliverables were wrong");
		
		Review savedReview = reviewDao.create(review);
		
		assertTrue(savedReview.getReviewId() > 0);
	}

	@Test
	public void testGet() {
		Integer reviewId = 1;
		Review review = reviewDao.get(reviewId);
		
		assertNotNull(review);
	}

	@Test
	public void testUpdateReview() {
		Integer reviewId = 4;
		Review review = reviewDao.get(reviewId);
		review.setComment("2 Deliverables  went wrong");
		
		Review updatedReview = reviewDao.update(review);
		
		assertEquals(review.getComment(), updatedReview.getComment());
		
	}
	
	@Test
	public void testDeleteReview() {
		int reviewId = 7;
		reviewDao.delete(reviewId);
		
		Review review = reviewDao.get(reviewId);
		
		assertNull(review);
		
	}

	@Test
	public void testListAll() {
		List<Review> listReview = reviewDao.listAll();
		
		for (Review review : listReview) {
			System.out.println(review.getReviewId() + " - " + 
					 " - " 
					+ " - " + review.getComment() + " - " + review.getRating());
		}
		
		assertTrue(listReview.size() > 0);
	}

	@Test
	public void testCount() {
		long totalReviews = reviewDao.count();
		System.out.println("Total Reviews: " + totalReviews);
		assertTrue(totalReviews > 0 );
	}

	@Test
	public void testFindByProjectmanagerAndEmployeeNotFound() {
		Integer projectmanagerId = 100;
		Integer employeeId = 99;
		
		Review result = reviewDao.findByProjectmanagerAndEmployee(projectmanagerId, employeeId);
		
		assertNull(result);
	}
	
	@Test
	public void testFindByProjectmanagerAndEmployeeFound() {
		Integer projectmanagerId = 1;
		Integer employeeId = 1;
		
		Review result = reviewDao.findByProjectmanagerAndEmployee(projectmanagerId, employeeId);
		
		assertNotNull(result);
	}
	
	
}
